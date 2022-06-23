package leetCode;

import org.junit.Test;

import java.util.Arrays;

public class LeetCode215 {
    @Test
    public void test1() {
        int[] ints = new int[]{3, 3, 2, 1, 2, 4, 5, 5, 6};
        System.out.println(findKthLargest(ints, 4));
    }
    public int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length - k];
    }
}

