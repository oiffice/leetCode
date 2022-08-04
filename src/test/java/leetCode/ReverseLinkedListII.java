package leetCode;

import org.junit.Test;

import java.util.Stack;

public class ReverseLinkedListII {
    @Test
    public void test1() {
        ListNode head = new ListNode(1,
                new ListNode(2, new ListNode(3,
                        new ListNode(4, new ListNode(5)))));
        print(reverseBetween(head, 2, 4));
    }
    @Test
    public void test2() {
        ListNode head = new ListNode(1,
                new ListNode(2, new ListNode(3,
                        new ListNode(4, new ListNode(5)))));
        print(reverseBetween(head, 2, 5));
    }
    @Test
    public void test3() {
        ListNode head = new ListNode(1,
                new ListNode(2, new ListNode(3,
                        new ListNode(4, new ListNode(5)))));
        print(reverseBetween(head, 4, 5));

    }
    @Test
    public void test4() {
        ListNode head = new ListNode(1,
                new ListNode(2, new ListNode(3,
                        new ListNode(4, new ListNode(5)))));
        print(reverseBetween(head, 1, 5));

    }
    private void print(ListNode node) {
        while (node != null) {
            System.out.println(node.val);
            node = node.next;
        }
    }
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (head == null || left >= right)
            return head;

        ListNode curr = head;
        ListNode prev = null;

        for (int i = 1; i < left && curr != null; i++) {
            prev = curr;
            curr = curr.next;
        }

        ListNode lastNodeOnMainList = prev;
        ListNode lasNodeOnSubList = curr;
        ListNode next = null;
        prev = null;

        for (int i = 0; i < right - left + 1 && curr != null; i++) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        if (lastNodeOnMainList == null) {
            head = prev;
        } else {
            lastNodeOnMainList.next = prev;
        }

        lasNodeOnSubList.next = curr;

        return head;
    }
}
