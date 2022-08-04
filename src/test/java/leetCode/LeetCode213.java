package leetCode;

import org.junit.Test;

import java.util.Arrays;

import static junit.framework.TestCase.assertEquals;

public class LeetCode213 {
    @Test
    public void test3() {
        assertEquals(12, rob(new int[]{5, 2, 1, 3, 6, 4}));
    }
    @Test
    public void test1() {
        assertEquals(3, rob(new int[]{1,2,3}));
    }
    public int rob(int[] nums) {
        if (nums.length == 1) return nums[0];
        if (nums.length == 2) return Math.max(nums[0], nums[1]);

        return Math.max(rob4(nums, 0, nums.length - 2), rob4(nums, 1, nums.length - 1));

    }

    public int rob4(int[] nums, int start, int end) {

        int n = end - start + 1;
        int[] p = new int[n];

        p[0] = nums[start];
        p[1] = Math.max(nums[start], nums[start + 1]);

        for(int i = 2; i < n; i++) {
            p[i] = Math.max(nums[i + start] + p[i - 2], p[i - 1]);
        }

        return p[n - 1];
    }

    public int robIII(int[] nums) {

        if (nums.length == 1) return nums[0];
        if (nums.length == 2) return Math.max(nums[0], nums[1]);

        // 1. take first
        int first = nums[0] + this.robII(Arrays.copyOfRange(nums, 2, nums.length - 1));
        // 2. take end
        int end = nums[nums.length - 1] + this.robII(Arrays.copyOfRange(nums, 1, nums.length - 2));
        // 3. take without first and end
        int max = this.robII(Arrays.copyOfRange(nums, 1, nums.length - 1));

        return Math.max(Math.max(first, end), max);

    }

    public int robII(int[] nums) {

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
