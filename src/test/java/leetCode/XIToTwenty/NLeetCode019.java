package leetCode.XIToTwenty;

import org.junit.Assert;
import org.junit.Test;

import java.util.Objects;

/**
 * Created by oiffice on 2018/8/27.
 */
public class NLeetCode019 {

    @Test
    public void test() {

        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);

        l2.next = null;
        l1.next = l2;

        ListNode result = this.removeNthFromEnd(l1, 2);
        Assert.assertEquals(2, result.val);


    }

    public ListNode removeNthFromEnd(ListNode head, int n) {

        ListNode fast = head;
        ListNode slow = head;

        while (n > 0) {
            fast = fast.next;
            n--;
        }

        if (Objects.isNull(fast)) {
            head = head.next;
            return head;
        }

        while (Objects.nonNull(fast.next)) {

            fast = fast.next;
            slow = slow.next;
        }

        slow.next = slow.next.next;
        return head;
    }

    public class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }
}
