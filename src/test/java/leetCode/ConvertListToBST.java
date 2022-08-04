package leetCode;

import org.junit.Test;

public class ConvertListToBST {
    @Test
    public void test1() {
        ListNode node5 = new ListNode(2, new ListNode(9));
        ListNode node4 = new ListNode(0, node5);
        ListNode node3 = new ListNode(-3, node4);
        ListNode node2 = new ListNode(-5, node3);
        ListNode node1 = new ListNode(-10, node2);

        TreeNode node = sortedListToBST(node1);
        System.out.println("asdf");

    }

    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) {
            return null;
        } else if (head.next == null) {
            return new TreeNode(head.val);
        } else {
            int count = 0;
            ListNode temp = head;
            while (temp != null) {
                temp = temp.next;
                count++;
            }
            return convert(head, count / 2);
        }
    }

    public TreeNode convert(ListNode head, int center) {
        ListNode leftPartNode = new ListNode(head.val);
        int lCount = 1;
        ListNode tempListNode = leftPartNode;

        while (lCount < center) {
            head = head.next;
            tempListNode.next = new ListNode(head.val);
            tempListNode = tempListNode.next;
            lCount++;
        }

        head = head.next;
        TreeNode node = new TreeNode(head.val);
        head = head.next;
        if (head == null) {
            node.left = new TreeNode(leftPartNode.val);
            return node;
        }
        ListNode rightPartNode = new ListNode(head.val);
        tempListNode = rightPartNode;
        int rCount = 1;
        while (head.next != null) {
            head = head.next;
            tempListNode.next = new ListNode(head.val);
            tempListNode = tempListNode.next;
            rCount++;
        }
        node.left = (leftPartNode.next != null) ?
            convert(leftPartNode, lCount / 2) : new TreeNode(leftPartNode.val);
        node.right = (rightPartNode.next != null) ?
                convert(rightPartNode, rCount / 2) : new TreeNode(rightPartNode.val);
        return node;
    }
}
