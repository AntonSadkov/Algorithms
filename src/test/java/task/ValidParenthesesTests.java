package task;

import org.junit.jupiter.api.Test;

import java.util.ArrayDeque;
import java.util.Deque;

import static org.assertj.core.api.Assertions.assertThat;

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
