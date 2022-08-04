package leetCode;

import org.junit.Test;

public class nthUglyNumber264 {
    @Test
    public void test1() {
        System.out.println(nthUglyNumber(10));
    }
    public int nthUglyNumber(int n) {
        if (n==1) {
            return 1;
        }
        int[] nums = new int[n];
        nums[0] = 1;

        int f2 = 0, f3 = 0, f5 = 0;
        for (int i = 1; i < n; i++) {
            int min = Math.min(Math.min(nums[f2] * 2, nums[f3] * 3), nums[f5] * 5);
            if (min == nums[f2] * 2) {
                f2++;
            } if (min == nums[f3] * 3) {
                f3++;
            } if (min == nums[f5] * 5) {
                f5++;
            }
            nums[i] = min;
        }

        return nums[n - 1];
    }
}
