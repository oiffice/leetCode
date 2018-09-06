package leetCode;

import org.junit.Assert;
import org.junit.Test;

import java.math.BigInteger;
import java.util.Objects;

/**
 * Created by oiffice on 2018/7/3.
 */
public class NLeetCode002 {

    @Test
    public void test() {

//        ListNode listNode11 = new ListNode(9);
//
//        ListNode listNode21 = new ListNode(1);
//        ListNode listNode22 = new ListNode(9);
//        ListNode listNode23 = new ListNode(9);
//        ListNode listNode24 = new ListNode(9);
//        ListNode listNode25 = new ListNode(9);
//        ListNode listNode26 = new ListNode(9);
//        ListNode listNode27 = new ListNode(9);
//        ListNode listNode28 = new ListNode(9);
//        ListNode listNode29 = new ListNode(9);
//        ListNode listNode30 = new ListNode(9);
//
//        listNode29.next = listNode30;
//        listNode28.next = listNode29;
//        listNode27.next = listNode28;
//        listNode26.next = listNode27;
//        listNode25.next = listNode26;
//        listNode24.next = listNode25;
//        listNode23.next = listNode24;
//        listNode22.next = listNode23;
//        listNode21.next = listNode22;

        ListNode listNode11 = new ListNode(2);
        ListNode listNode12 = new ListNode(4);
        ListNode listNode13 = new ListNode(3);

        listNode13.next = null;
        listNode12.next = listNode13;
        listNode11.next = listNode12;

        ListNode listNode21 = new ListNode(5);
        ListNode listNode22 = new ListNode(6);
        ListNode listNode23 = new ListNode(4);

        listNode23.next = null;
        listNode22.next = listNode23;
        listNode21.next = listNode22;


        ListNode result = this.addTwoNumbers(listNode11, listNode21);

        Assert.assertEquals(7, result.val);
        Assert.assertEquals(0, result.next.val);
        Assert.assertEquals(8, result.next.next.val);
        Assert.assertEquals(null, result.next.next.next);


    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode privotNode = new ListNode(-1);
        ListNode resultNode = privotNode;
        int carry = 0;

        while (carry > 0 || Objects.nonNull(l1) || Objects.nonNull(l2)) {

            int result = (Objects.nonNull(l1) ? l1.val : 0) + (Objects.nonNull(l2) ? l2.val : 0) + carry;
            carry = (result >= 10) ? 1 : 0;
            result = result % 10;

            privotNode.val = result;

            l1 = (Objects.isNull(l1) || Objects.isNull(l1.next)) ? null : l1.next;
            l2 = (Objects.isNull(l2) || Objects.isNull(l2.next)) ? null : l2.next;

            if (carry > 0 || Objects.nonNull(l1) || Objects.nonNull(l2)) {
                privotNode.next = new ListNode(-1);
                privotNode = privotNode.next;
            }
        }

        return resultNode;
    }

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
}
