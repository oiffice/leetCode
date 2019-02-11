package leetCode.XXIToXXX;

import org.junit.Assert;
import org.junit.Test;

import javax.swing.*;
import java.util.Objects;

public class NLeetCode021 {

    @Test
    public void test() {

        ListNode l11 = new ListNode(1);
        ListNode l12 = new ListNode(2);
        ListNode l13 = new ListNode(4);

        l13.next = null;
        l12.next = l13;
        l11.next = l12;


        ListNode l21 = new ListNode(1);
        ListNode l22 = new ListNode(3);
        ListNode l23 = new ListNode(4);

        l23.next = null;
        l22.next = l23;
        l21.next = l22;

        ListNode result = this.mergeTwoLists(l11, l21);

        Assert.assertEquals(1, result.val);
        Assert.assertEquals(1, result.next.val);
        Assert.assertEquals(2, result.next.next.val);
        Assert.assertEquals(3, result.next.next.next.val);
        Assert.assertEquals(4, result.next.next.next.next.val);
        Assert.assertEquals(4, result.next.next.next.next.next.val);
        Assert.assertNull(result.next.next.next.next.next.next);
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        if (Objects.isNull(l1)) {
            return l2;
        }

        if (Objects.isNull(l2)) {
            return l1;
        }

        if (l1.val > l2.val) {

            l2.next = this.mergeTwoLists(l1, l2.next);
            return l2;

        } else {
            l1.next = this.mergeTwoLists(l1.next, l2);
            return l1;
        }

    }

    public class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
    }
}
