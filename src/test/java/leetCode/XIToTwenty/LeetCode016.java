package leetCode.XIToTwenty;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

/**
 * Created by oiffice on 2018/11/8.
 */
public class LeetCode016 {

    @Test
    public void testThreeSum() {

        int[] test1 = new int[]{-1, 2, 1, -4};

        Assert.assertEquals(2, threeSumClosest(test1, 1));
    }

    @Test
    public void testThreeSumII() {

        int[] test1 = new int[]{0, 1, 2};

        Assert.assertEquals(3, threeSumClosest(test1, 3));
    }

    @Test
    public void testThreeSumIII() {

        int[] test1 = new int[]{1,1,-1,-1,3};

        Assert.assertEquals(3, threeSumClosest(test1, 3));
    }

    public int threeSumClosest(int[] nums, int target) {
        // Assumptions: array is not null, array.length >= 3

        int min = Integer.MAX_VALUE;
        int result = 0;
        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 2; i++) {


            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            int left = i + 1;
            int right = nums.length - 1;

            while (left < right) {
                int tmp = nums[left] + nums[right];
                if (tmp + nums[i] == target) {

                    return target;

                } else {

                    int distance = Math.abs((tmp + nums[i]) - target);

                    if (min > distance) {

                        result = (tmp + nums[i]);
                        min = distance;
                    }

                    if (tmp + nums[i] < target) {
                        left++;
                    } else {
                        right--;
                    }
                }
            }
        }

        return result;
    }
}
