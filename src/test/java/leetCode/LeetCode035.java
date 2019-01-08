package leetCode;

import org.junit.Assert;
import org.junit.Test;

import java.util.Objects;

public class LeetCode035 {

    @Test
    public void test1() {

        int[] nums = new int[]{1,3,5,6};
        int target = 5;

        Assert.assertEquals(2, this.searchInsert(nums, target));
    }

    @Test
    public void test2() {

        int[] nums = new int[]{1,3,5,6};
        int target = 2;

        Assert.assertEquals(1, this.searchInsert(nums, target));
    }

    @Test
    public void test3() {

        int[] nums = new int[]{1,3,5,6};
        int target = 7;

        Assert.assertEquals(4, this.searchInsert(nums, target));
    }

    @Test
    public void test4() {

        int[] nums = new int[]{1,3,5,6};
        int target = 0;

        Assert.assertEquals(0, this.searchInsert(nums, target));
    }

    @Test
    public void test5() {

        int[] nums = new int[]{1,3,5,6};
        int target = 4;

        Assert.assertEquals(2, this.searchInsert(nums, target));
    }

    @Test
    public void test6() {

        int[] nums = new int[]{1};
        int target = 4;

        Assert.assertEquals(1, this.searchInsert(nums, target));
    }

    @Test
    public void test7() {

        int[] nums = new int[]{1};
        int target = 0;

        Assert.assertEquals(0, this.searchInsert(nums, target));
    }

    @Test
    public void test8() {

        int[] nums = new int[]{1,3};
        int target = 2;

        Assert.assertEquals(1, this.searchInsert(nums, target));
    }

    public int searchInsert(int[] nums, int target) {

        if (Objects.isNull(nums) || nums.length == 0) {
            return 0;
        }

        int left = 0;
        int right = nums.length;


        while (left < right) {

            int middle = (left + right) / 2;

            if (nums[middle] == target) {
                return middle;
            } else if (nums[middle] < target) {
                left = middle + 1;
            } else {
                right = middle - 1;
            }
        }

        if (right == nums.length) {
            return nums.length;
        } else {
            return (nums[left] < target) ? (left + 1) : left;
        }

    }

}
