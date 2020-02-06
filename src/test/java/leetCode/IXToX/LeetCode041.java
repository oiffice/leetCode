package leetCode;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

/**
 * Created by oiffice on 2018/12/26.
 */
public class LeetCode041 {


    @Test
    public void test1() {

        int[] nums = new int[]{0,1,2,4};

        Assert.assertEquals(3, this.firstMissingPositive(nums));

    }

    @Test
    public void test2() {

        int[] nums = new int[]{3,4,-1,1};

        Assert.assertEquals(2, this.firstMissingPositive(nums));

    }

    @Test
    public void test3() {

        int[] nums = new int[]{7,8,9,11,12};

        Assert.assertEquals(1, this.firstMissingPositive(nums));

    }

    @Test
    public void test4() {

        int[] nums = new int[]{1,2,0};

        Assert.assertEquals(3, this.firstMissingPositive(nums));

    }

    @Test
    public void test5() {

        int[] nums = new int[]{1,2};

        Assert.assertEquals(3, this.firstMissingPositive(nums));

    }

    @Test
    public void test6() {

        int[] nums = new int[]{0, -1, 4, 3};

        Assert.assertEquals(1, this.firstMissingPositive(nums));

    }

    @Test
    public void test7() {

        int[] nums = new int[]{0, 1, 1, 2, 2};

        Assert.assertEquals(3, this.firstMissingPositive(nums));

    }

    @Test
    public void test8() {

        int[] nums = new int[]{1,2,2,2,5,5};

        Assert.assertEquals(3, this.firstMissingPositive(nums));

    }


    private int firstMissingPositive(int[] nums) {

        int numLength = nums.length;

        if (numLength == 0) {
            return 1;
        }

        if (numLength == 1) {

            return (nums[0] == 1) ? 2 : 1;

        }

        Arrays.sort(nums);

        int endCondition = nums[numLength - 1];
        int valueToFind = 1;

        for (int i = 0; i < endCondition; i++) {

            if (!bs(nums, 0, numLength - 1, valueToFind)) {
                return valueToFind;
            }

            valueToFind++;

        }

        return valueToFind;
    }

    private boolean bs(int[] arr, int left, int right, int target) {

        int middle = (left + right) / 2;

        if (left > right) {
            return false;
        } else  if (arr[middle] == target) {
            return true;
        }

        if (arr[middle] < target) {

            left = middle + 1;

        } else {
            right = middle - 1;
        }


        return bs(arr, left, right, target);

    }
}
