package leetCode.XXIToXXX;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class LeetCode024 {

    @Test
    public void test1() {

        ListNode listNode1 = new ListNode(2);
        ListNode listNode2 = new ListNode(1);
        ListNode listNode3 = new ListNode(4);
        ListNode listNode4 = new ListNode(3);
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = null;


        ListNode result = this.swapPairs(listNode1);
        Assert.assertEquals(1, result.val);
        Assert.assertEquals(2, result.next.val);
        Assert.assertEquals(3, result.next.next.val);
        Assert.assertEquals(4, result.next.next.next.val);
    }

    @Test
    public void test2() {

        ListNode listNode1 = new ListNode(2);
        ListNode listNode2 = new ListNode(1);
        ListNode listNode3 = new ListNode(4);
        ListNode listNode4 = new ListNode(3);
        ListNode listNode5 = new ListNode(5);
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = listNode5;
        listNode5.next = null;


        ListNode result = this.swapPairs(listNode1);
        Assert.assertEquals(1, result.val);
        Assert.assertEquals(2, result.next.val);
        Assert.assertEquals(3, result.next.next.val);
        Assert.assertEquals(4, result.next.next.next.val);
        Assert.assertEquals(5, result.next.next.next.next.val);
    }


    public ListNode swapPairs(ListNode head) {

        List<ListNode> listNodes = new ArrayList<>();

        while (Objects.nonNull(head)) {

            listNodes.add(new ListNode(head.val));
            head = head.next;

        }

        for (int i = 0; i < listNodes.size(); i += 2) {

            if ( (i+1) < listNodes.size()) {
                Collections.swap(listNodes, i, i+1);
            }

        }

        ListNode result = null;

        for (int i = listNodes.size() - 1; i >= 0; i--) {

            ListNode temp = listNodes.get(i);
            temp.next = result;
            result = temp;

        }



        return result;

    }
    
     public class ListNode {
         int val;
         ListNode next;

         ListNode(int x) {
             val = x;
         }
     }
}
