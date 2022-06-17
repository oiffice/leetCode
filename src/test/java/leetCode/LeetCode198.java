package leetCode;

import org.junit.Test;

import java.util.Arrays;

import static junit.framework.TestCase.assertEquals;

public class LeetCode198 {
    @Test
    public void test1() {
        assertEquals(12, rob(new int[]{2, 7, 9, 3, 1}));
    }
    @Test
    public void test2() {
        assertEquals(4, rob(new int[]{1, 2, 3, 1}));
    }
    @Test
    public void test3() {
        assertEquals(14, rob(new int[]{5, 2, 1, 9, 3}));
    }
    @Test
    public void test4() {
        assertEquals(16, rob(new int[]{1, 14, 3, 2, 1}));
    }
    public int rob(int[] nums) {

        if (nums.length == 1) return nums[0];
        if (nums.length == 2) return Math.max(nums[0], nums[1]);

        int[] amount = new int[nums.length];
        Arrays.fill(amount, 0);

        amount[0] = nums[0];
        amount[1] = nums[1];
        for (int i = 2; i < nums.length; i++) {
            int max = 0;
            for( int j = 0; j <= i - 2; j++) {
                max = Math.max(max, amount[j]);
            }
            amount[i] = max + nums[i];
        }

        return Arrays.stream(amount).max().getAsInt();
    }
}
