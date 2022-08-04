package leetCode;

import org.junit.Assert;
import org.junit.Test;

public class MaximumSubarray053 {

    @Test
    public void test1() {
        int[] input = new int[]{-2, 1, -3, 4, -1, 2, 1, -5, -4};
        Assert.assertEquals(6, this.maxSubArray(input));
    }

    @Test
    public void test2() {
        int[] input = new int[]{10, -15, 20, -25, 30, -35, 40, -45, 50, -55};
        Assert.assertEquals(-5, this.maxSubArray(input));
    }

    public int maxSubArray(int[] nums) {

        int max = Integer.MIN_VALUE;
        int sum = 0;

        for (int i = 0; i < nums.length; i++) {

            if (sum <= 0) {
                sum = nums[i];
            } else {
                sum += nums[i];
            }

            if (max < sum) {
                max = sum;
            }
        }

        return sum;
    }
}
