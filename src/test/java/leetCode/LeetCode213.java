package leetCode;

import org.junit.Test;

import java.util.Arrays;

import static junit.framework.TestCase.assertEquals;

public class LeetCode213 {
    @Test
    public void test3() {
        assertEquals(12, rob(new int[]{5, 2, 1, 3, 6, 4}));
    }

    public int rob(int[] nums) {

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
