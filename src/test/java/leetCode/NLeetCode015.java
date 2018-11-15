package leetCode;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by oiffice on 2018/8/2.
 */
public class NLeetCode015 {

    @Test
    public void testThreeSum() {

        int[] test1 = new int[]{3,-2,1,0};
        List<List<Integer>> solutionA = new ArrayList<List<Integer>>();
        Assert.assertEquals(solutionA, threeSum(test1));
    }

    @Test
    public void testThreeSumII() {

        int[] test1 = new int[]{-1, 0, 1, 2, -1, -4 };
        List<Integer> solution1 = new ArrayList<Integer>(){{ add(-1); add(0); add(1);}};
        List<Integer> solution2 = new ArrayList<Integer>(){{ add(-1); add(-1); add(2);}};
        List<List<Integer>> solutionA = new ArrayList<List<Integer>>();
        solutionA.add(solution1);
        solutionA.add(solution2);
        List<List<Integer>> result = threeSum(test1);

        result.forEach(list -> {

            Assert.assertTrue(solutionA.contains(list));

        });
    }

    @Test
    public void testThreeSumIV() {

        int[] test1 = new int[]{0};

        List<List<Integer>> solutionA = new ArrayList<List<Integer>>();

        Assert.assertEquals(solutionA, threeSum(test1));
    }

    public List<List<Integer>> threeSum(int[] nums) {
        // Assumptions: array is not null, array.length >= 3

        List<List<Integer>> result = new ArrayList<List<Integer>>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {

            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            int left = i + 1;
            int right = nums.length - 1;

            while (left < right) {
                int tmp = nums[left] + nums[right];
                if (tmp + nums[i] == 0) {
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    left++;
                    while (left < right && nums[left] == nums[left - 1]) {
                        left++;
                    }
                } else if (tmp + nums[i] < 0) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        return result;
    }

}

