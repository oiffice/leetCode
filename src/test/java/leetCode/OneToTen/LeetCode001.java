package leetCode.OneToTen;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * Created by oiffice on 2018/7/3.
 */
public class LeetCode001 {

    @Test
    public void testTwoSum() {

        int[] ints = new int[]{2, 7, 11, 15};
        int[] result = twoSum(ints, 9);

        Assert.assertEquals(0, result[0]);
        Assert.assertEquals(1, result[1]);
    }

    @Test
    public void testTwoSum2() {

        int[] ints = new int[]{2, 7, 11, 15};
        int[] result = twoSum(ints, 22);

        Assert.assertEquals(1, result[0]);
        Assert.assertEquals(3, result[1]);
    }

    public int[] twoSum(int[] nums, int target) {

        if (Objects.isNull(nums) || nums.length == 0) {

            return null;
        }

        Map<Integer, Integer> result = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {

            int key = (target - nums[i]);

            if (result.containsKey(nums[i])) {
                return new int[]{result.get(nums[i]), i};
            }

            result.put(key, i);
        }

        return null;
    }
}
