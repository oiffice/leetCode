package leetCode.XIToTwenty;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by oiffice on 2018/11/15.
 */
public class LeetCode018 {

    @Test
    public void test1() {

        int[] nums = new int[]{1, 0, -1, 0, -2, 2};

        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> solution1 = new ArrayList<Integer>(){{ add(-1); add(0); add(0); add(1);}};
        List<Integer> solution2 = new ArrayList<Integer>(){{ add(-2); add(-1); add(1); add(2);}};
        List<Integer> solution3 = new ArrayList<Integer>(){{ add(-2); add(0); add(0); add(2);}};

        ans.add(solution1);
        ans.add(solution2);
        ans.add(solution3);

        this.fourSum(nums, 0).forEach(ansList -> {

            Assert.assertTrue(ans.contains(ansList));
        });

    }

    @Test
    public void test2() {

        int[] nums = new int[]{1, 0, -1, 0, -2, 2};

        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> solution1 = new ArrayList<Integer>(){{ add(-2); add(0); add(1); add(2);}};
        List<Integer> solution2 = new ArrayList<Integer>(){{ add(-1); add(0); add(0); add(2);}};

        ans.add(solution1);
        ans.add(solution2);

        this.fourSum(nums, 1).forEach(ansList -> {

            Assert.assertTrue(ans.contains(ansList));
        });

    }

    @Test
    public void test3() {

        int[] nums = new int[]{5,5,3,5,1,-5,1,-2};

        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> solution1 = new ArrayList<Integer>(){{ add(-5); add(1); add(3); add(5);}};

        ans.add(solution1);
        Assert.assertEquals(ans, this.fourSum(nums, 4));

    }

    public List<List<Integer>> fourSum(int[] nums, int target) {

        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {

            if (i > 0 && nums[i] == nums[i-1]) {
                continue;
            }
            int[] subNum = Arrays.copyOfRange(nums, i+1, nums.length);
            result.addAll(this.threeSum(subNum, nums[i], target));

        }

        result = result.stream().distinct().collect(Collectors.toList());

        return result;
    }

    private List<List<Integer>> threeSum(int[] nums, int target, int staticTarget) {


        if (nums.length == 0) {
            return Collections.EMPTY_LIST;
        }

        List<List<Integer>> result = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {

            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            int left = i + 1;
            int right = nums.length - 1;
            int pivot = nums[i];

            while (left < right) {

                int total = target + pivot + nums[left] + nums[right];
                if (total == staticTarget) {

                    result.add(Arrays.asList(target, pivot, nums[left], nums[right]));

                }

                if (total < staticTarget) {
                    left++;
                } else {
                    right--;
                }

            }

        }

        return result;

    }
}
