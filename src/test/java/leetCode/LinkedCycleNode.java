package leetCode;


import org.junit.Test;

public class LinkedCycleNode {

    @Test
    public void test1() {
        ListNode node3 = new ListNode(4);
        ListNode node2 = new ListNode(0, node3);
        ListNode node1 = new ListNode(1, node2);
        ListNode head = new ListNode(3, node1);
        node3.next = node1;
        System.out.println(hasCycle(head));
    }

    @Test
    public void test2() {
        ListNode node3 = new ListNode(4);
        ListNode node2 = new ListNode(0, node3);
        ListNode node1 = new ListNode(1, node2);
        ListNode head = new ListNode(3, node1);
        System.out.println(hasCycle(head));
    }

    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        ListNode slow = new ListNode();
        ListNode fast = new ListNode();
        slow.next = head;
        fast.next = head;
        while (slow != null && fast.next != null) {

            if (slow == fast) {
                return true;
            }

            slow = slow.next;
            fast = fast.next.next;

        }

        return false;
    }
}
