package leetCode;

import org.junit.Test;

import java.util.Arrays;

public class LeetCode238 {
    @Test
    public void test1() {
        int[] ints = productExceptSelf(new int[]{1,2,3,4});
        for (int i: ints) {
            System.out.println(i);
        }
    }
    @Test
    public void test2() {
        int[] ints = productExceptSelf(new int[]{-1,1,0,3,-3});
        for (int i: ints) {
            System.out.println(i);
        }
    }
    @Test
    public void test3() {
        int[] ints = productExceptSelf(new int[]{});
        for (int i: ints) {
            System.out.println(i);
        }
    }
    public int[] productExceptSelf(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        for(int i = 1; i < nums.length; i++) {
            dp[0] *= nums[i];
        }

        for (int i = 1; i < nums.length; i++) {
            int num = 1;
            if (nums[i] == 0) {
                for(int j = 0; j < nums.length; j++) {
                    if (i == j) {
                        continue;
                    }
                    num *= nums[j];
                }
                dp[i] = num;
            } else {
                dp[i] = nums[i - 1] * dp[i - 1] / nums[i];
            }
        }

        return dp;

    }
}
