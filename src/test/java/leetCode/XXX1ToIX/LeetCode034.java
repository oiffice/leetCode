package leetCode.XXX1ToIX;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

/**
 * Created by oiffice on 2018/12/20.
 */
public class LeetCode034 {

    @Test
    public void test1() {

        int[] nums = new int[]{5,7,7,8,8,10};
        int target = 8;

        int[] result = this.searchRange(nums, target);

        assertEquals(3, result[0]);
        assertEquals(4, result[1]);

    }

    @Test
    public void test2() {

        int[] nums = new int[]{2,4,5,6,7,9};
        int target = 8;

        int[] result = this.searchRange(nums, target);

        assertEquals(-1, result[0]);
        assertEquals(-1, result[1]);

    }

    @Test
    public void test3() {

        int[] nums = new int[]{0,0,5,6,8,9};
        int target = 0;

        int[] result = this.searchRange(nums, target);

        assertEquals(0, result[0]);
        assertEquals(1, result[1]);

    }

    @Test
    public void test4() {

        int[] nums = new int[]{1};
        int target = 1;

        int[] result = this.searchRange(nums, target);

        assertEquals(0, result[0]);
        assertEquals(0, result[1]);
    }

    @Test
    public void test5() {

        int[] nums = new int[]{2,2};
        int target = 3;

        int[] result = this.searchRange(nums, target);

        assertEquals(-1, result[0]);
        assertEquals(-1, result[1]);
    }

    @Test
    public void test6() {

        int[] nums = new int[]{2,2,2};
        int target = 2;

        int[] result = this.searchRange(nums, target);

        assertEquals(0, result[0]);
        assertEquals(2, result[1]);
    }

    @Test
    public void test7() {

        int[] nums = new int[]{1,2,3};
        int target = 3;

        int[] result = this.searchRange(nums, target);

        assertEquals(2, result[0]);
        assertEquals(2, result[1]);
    }

    @Test
    public void test8() {

        int[] input = new int[]{1,1,1,1,1,1,2,3,4,4,5,5,5,6,7,8,8,8,8};
        int[] output = this.searchRange(input, 8);

        assertEquals(15, output[0]);
        assertEquals(18, output[1]);

    }

    @Test
    public void test9() {

        int[] input = new int[]{0,0,0,0,1,2,3,3,4,5,6,6,7,8,8,8,9,9,10,10,11,11};
        int[] output = this.searchRange(input, 0);

        Assert.assertEquals(0, output[0]);
        Assert.assertEquals(3, output[1]);

    }

    public int[] searchRange(int[] nums, int target) {

        int[] result = new int[]{-1, -1};

        if (nums.length == 0) {
            return result;
        }

        if (nums.length == 1 && nums[0] != target) {
            return result;
        }

        int leftIndex = 0;
        int rightIndex = nums.length - 1;
        int targetIndex = this.search(leftIndex, rightIndex, target, nums);

        if (targetIndex == -1) {
            return new int[] {-1, -1};
        }

        // search left
        int newRightIndex = targetIndex;
        int leftTargetIndex = targetIndex;

        while ((newRightIndex -1 ) >= 0 && nums[newRightIndex - 1] == target) {
            leftTargetIndex = newRightIndex - 1;
            newRightIndex--;
        }

        // search right
        int newLeftIndex = targetIndex;
        int rightTargetIndex = targetIndex;

        while ((newLeftIndex + 1) < nums.length && nums[newLeftIndex + 1] == target) {
            rightTargetIndex = newLeftIndex + 1;
            newLeftIndex++;
        }

        return new int[] {leftTargetIndex, rightTargetIndex};



    }

    private int search(int leftIndex, int rightIndex, int target, int nums[]) {

        while (leftIndex <= rightIndex) {

            int middle = (int) Math.floor((rightIndex + leftIndex) / 2);

            if (nums[middle] == target) {
                return middle;
            } else if (nums[middle] < target) {
                leftIndex = middle + 1;
            } else {
                rightIndex = middle - 1;
            }
        }

        return -1;
    }

}
