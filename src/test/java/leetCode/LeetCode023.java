package leetCode;

import org.junit.Test;

import java.util.Objects;

public class LeetCode023 {

    @Test
    public void test1() {

        ListNode listNodeA1 = new ListNode(1);
        ListNode listNodeA2 = new ListNode(4);
        ListNode listNodeA3 = new ListNode(5);
        listNodeA1.next = listNodeA2;
        listNodeA2.next = listNodeA3;
        listNodeA3.next = null;

        ListNode listNodeB1 = new ListNode(1);
        ListNode listNodeB2 = new ListNode(3);
        ListNode listNodeB3 = new ListNode(4);
        listNodeB1.next = listNodeB2;
        listNodeB2.next = listNodeB3;
        listNodeB3.next = null;

        ListNode listNodeC1 = new ListNode(2);
        ListNode listNodeC2 = new ListNode(6);
        listNodeC1.next = listNodeC2;
        listNodeC2.next = null;

        ListNode[] input = new ListNode[0];
        ListNode result = this.mergeKLists(input);

        System.out.println(result);


    }

    public ListNode mergeKLists(ListNode[] lists) {

        if (lists.length == 0) {
            return null;
        }

        int i;
        for (i = 0; i < lists.length; i++) {

            if ( (i+1) < lists.length) {
                lists[i+1] = this.merge(lists[i], lists[i+1]);
            }

        }

        return lists[i-1];

    }

    public ListNode merge(ListNode m, ListNode n) {
        ListNode head = new ListNode(0);
        ListNode p = head;
        while (m != null && n != null) {
            if (m.val < n.val) {
                p.next = m;
                p = p.next;
                m = m.next;
            } else {
                p.next = n;
                p = p.next;
                n = n.next;
            }
        }
        if (m != null)
            p.next = m;
        else
            p.next = n;
        return head.next;
    }

    public class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }
}
