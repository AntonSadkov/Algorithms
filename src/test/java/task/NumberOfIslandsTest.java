package task;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * У нас есть двумерная сетка (матрица) из '1' (земля) и '0' (вода).
 * Нужно посчитать количество островов,
 * где остров — это группа соседних '1', соединённых по горизонтали или вертикали (но не по диагонали).
 *
 * Ключевая идея:
 * Нужно пройти по всей матрице.
 * Как только мы встречаем '1', это начало нового острова → увеличиваем счётчик островов.
 * После этого мы должны «затопить» (или «отметить как посещённые») все клетки,
 * относящиеся к этому острову, чтобы не посчитать его дважды.
 * «Затопить» можно двумя способами: либо менять '1' → '0', либо вести отдельную матрицу visited.
 */


public class NumberOfIslandsTest {

    @Test
    void case1() {
        char[][] grid = {
            {'1','1','1','1','0'},
            {'1','1','0','1','0'},
            {'1','1','0','0','0'},
            {'0','0','0','0','0'}
        };

        assertThat(numIslands(grid)).isEqualTo(1);
    }

    @Test
    void case2() {
        char[][] grid = {
                {'1','1','0','0','0'},
                {'1','1','0','0','0'},
                {'0','0','1','0','0'},
                {'0','0','0','1','1'}
        };

        assertThat(numIslands(grid)).isEqualTo(3);
    }

    @Test
    void case3() {
        char[][] grid = {
                {'0','0','0'},
                {'0','0','0'},
                {'0','0','0'}
        };

        assertThat(numIslands(grid)).isEqualTo(0);
    }

    @Test
    void case4() {
        char[][] grid = {
                {'1'}
        };

        assertThat(numIslands(grid)).isEqualTo(1);
    }

    @Test
    void case5() {
        char[][] grid = {
                {'0'}
        };

        assertThat(numIslands(grid)).isEqualTo(0);
    }

    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }

        int count = 0;
        int rows = grid.length;
        int cols = grid[0].length;

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (grid[r][c] == '1') {
                    count ++;
                    dfs(grid, r, c);
                }
            }
        }
        return count;
    }

    private void dfs(char[][] grid, int r, int c) {
        int rows = grid.length;
        int cols = grid[0].length;

        // Условия для отслеживания границ.
        if (r < 0 || c < 0 || r >= rows || c >= cols || grid[r][c] == '0') {
            return;
        }

        grid[r][c] = '0';

        dfs(grid, r - 1, c); //Верх
        dfs(grid, r + 1, c); //Вниз
        dfs(grid, r, c - 1); //Влево
        dfs(grid, r, c + 1); //Вправо
    }
}
