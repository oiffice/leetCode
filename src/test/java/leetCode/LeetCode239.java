package leetCode;

import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Deque;

public class LeetCode239 {
    @Test
    public void test1() {
        int[] result = maxSlidingWindow(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3);
        for (int i :
                result) {
            System.out.println(i);
        }
    }
    @Test
    public void test2() {
        int[] result = maxSlidingWindow(new int[]{1}, 1);
        for (int i :result) {
            System.out.println(i);
        }
    }
    @Test
    public void test3() {
        int[] result = maxSlidingWindow(new int[]{1, -1}, 1);
        for (int i :result) {
            System.out.println(i);
        }
    }
    @Test
    public void test4() {
        int[] result = maxSlidingWindow(new int[]{1,3,1,2,0,5}, 3);
        for (int i :result) {
            System.out.println(i);
        }
    }
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> deque = new ArrayDeque<>();
        int[] result = new int[nums.length - k + 1];
        int maxIdx = 0;

        for (int i = 0; i < nums.length; i++) {
            if (i - k + 1 > maxIdx) {
                deque.pollFirst();
            }

            if (deque.isEmpty() || nums[deque.peekLast()] >= nums[i]) {
                deque.offer(i);
            } else {

                while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
                    deque.pollLast();
                }
                deque.offerLast(i);
            }

            if (i >= k - 1) {
                result[i - k + 1] = nums[deque.peekFirst()];
                maxIdx = deque.peekFirst();
            }
        }
        return result;
    }
}
