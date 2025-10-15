package task.linkedlisttask;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static task.linkedlisttask.ListNode.fromArray;
import static task.linkedlisttask.ListNode.toArray;

/**
 * Дан head односвязный список, перевернуть его и вернуть обратный список.
 */

public class ReversLinkedListTest {

    public ListNode reverseList(ListNode head) {
        // предыдущий элемент (изначально null)
        ListNode prev = null;
        // текущий элемент (изначально head)
        ListNode curr = head;

        while (curr != null) {
            ListNode next = curr.next; // сохранить следующий узел
            curr.next = prev; // перевернуть ссылку
            prev = curr; // сместить prev
            curr = next; // сместить curr
        }
        return prev;
    }

    @Test
    void reversLinkedListCase1Test() {
        assertThat(toArray(reverseList(fromArray(new int[]{1,2,3,4,5}))))
                .isEqualTo(new int[]{5,4,3,2,1});
    }

    @Test
    void reversLinkedListCase2Test() {
        assertThat(toArray(reverseList(fromArray(new int[]{1,2}))))
                .isEqualTo(new int[]{2,1});
    }

    @Test
    void reversLinkedListCase3Test() {
        assertThat(toArray(reverseList(fromArray(new int[]{}))))
                .isEqualTo(new int[]{});
    }
}
