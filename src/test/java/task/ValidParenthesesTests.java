package task;

import org.junit.jupiter.api.Test;

import java.util.ArrayDeque;
import java.util.Deque;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Если задана строка, s содержащая только символы '(', ')', '{', '}', '['и ']',
 * определите, является ли входная строка допустимой.
 * Входная строка действительна, если:
 * Открытые скобки должны быть закрыты скобками того же типа.
 * Открытые скобки должны быть закрыты в правильном порядке.
 * Каждой закрывающейся скобке соответствует открывающая скобка того же типа.
 */

public class ValidParenthesesTests {

    public boolean validParentheses(String s) {
        Deque<Character> stack = new ArrayDeque<>();

        for (char ch : s.toCharArray()) {
            if (ch == '(' || ch == '[' || ch == '{') {
                stack.push(ch);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                char top = stack.pop();
                if (ch == ')' && top != '(') return false;
                if (ch == ']' && top != '[') return false;
                if (ch == '}' && top != '{') return false;
            }
        }
        return stack.isEmpty();
    }

    @Test
    void validParenthesesTest() {
        assertThat(validParentheses("()")).isTrue();
        assertThat(validParentheses("()[]{}")).isTrue();
        assertThat(validParentheses("([])")).isTrue();
    }

    @Test
    void invalidParenthesesTest() {
        assertThat(validParentheses("(]")).isFalse();
        assertThat(validParentheses("([)]")).isFalse();
    }
}
