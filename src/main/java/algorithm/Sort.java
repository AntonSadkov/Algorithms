package algorithm;

public class Sort {

    public int[] sortDesc(int[] array) { // На вход получаем неотсортированный массив.
        for (int i = 0; i < array.length - 1; i++) { //Циклом выполняем проход по массиву.
            int maxIndex = i;

            for (int j = i + 1; //Впереди идущий индекс.
                 j < array.length; j++) {
                //Вложенным циклом сравниваем значение текущего индекса с впереди идущим.

                if (array[j] > array[maxIndex]) {
                    //Если значение под индексом j больше, то данный индекс становиться max.
                    maxIndex = j;
                }
            }

            if (maxIndex != i) {
                /*
                 * Если индексы не совпали, то нам нужно передвинуть значение под данным
                 * индексом вперёд. Выполняется это с помощью перезаписи в дополнительную
                 * переменную value.
                 */
                int value = array[i];
                array[i] = array[maxIndex];
                array[maxIndex] = value;
                /*
                 * Если значение ячейки впереди идущего индекса больше, чем значение
                 * позади идущей ячейки, то тогда позади идущая записывается вперёд,
                 * а та которая больше назад. Так выполняется сортировка по убыванию.
                 */
            }
        }
        return array;
    }

    //Теперь роди сортировку по возрастанию.
    public int[] sortAsc(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            int minIndex = i;

            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < array[minIndex]) {
                    minIndex = j;
                }
            }

            if (minIndex != i) {
                int value = array[i];
                array[i] = array[minIndex];
                array[minIndex] = value;
            }
        }

        return array;
    }
}
