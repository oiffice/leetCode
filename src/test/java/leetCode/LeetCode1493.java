package leetCode;

import org.junit.Test;

import java.util.Stack;

import static junit.framework.TestCase.assertEquals;

public class LeetCode1493 {
    @Test
    public void test1() {
        int[] ints = new int[] {1,1,0,1,0,0,1,1,1,1};
        assertEquals(4, longestSubarray(ints));
    }
    @Test
    public void test3() {
        int[] ints = new int[] {0,1,1,1,0,1,1,0,1};
        assertEquals(5, longestSubarray(ints));
    }
    @Test
    public void test4() {
        int[] ints = new int[] {1,1,1,1};
        assertEquals(3, longestSubarray(ints));
    }
    public int longestSubarray(int[] nums) {

        Stack<Integer> stack = new Stack<>();
        int count = 0;
        int lastCount = 0;
        int max = 0;

        for (int num : nums) {
            if (num == 1) {
                count++;
            } else {
                lastCount = count;
                count = 0;
            }
            max = Math.max(count + lastCount, max);
        }

        return max == nums.length ? max - 1 : max;
    }
}
