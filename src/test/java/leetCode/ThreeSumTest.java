package leetCode;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * Created by oiffice on 2018/7/27.
 */
public class ThreeSumTest {

    @Test
    public void test() {

//        int[] test1 = new int[]{-1, 0, 1, 2, -1, -4 };
        int[] test1 = new int[]{3,-2,1,0 };
//        List<Integer> solution1 = new ArrayList<Integer>(){{ add(-1); add(0); add(1);}};
//        List<Integer> solution2 = new ArrayList<Integer>(){{ add(-1); add(-1); add(2);}};
        List<List<Integer>> solutionA = new ArrayList<List<Integer>>();
        Assert.assertEquals(solutionA, threeSum(test1));
    }

    public List<List<Integer>> threeSum(int[] nums) {

        List<List<Integer>> result = new ArrayList<>();

        int numLength = nums.length;
        int[] originalNums = nums;

        for (int i = 0; i < numLength; i++) {

            nums = originalNums;
            int target = 0 - nums[i];
            nums = Arrays.copyOfRange(nums, 1, numLength);
            Arrays.sort(nums);

            int[] sol = this.twoSum(nums, target);

            if (Objects.nonNull(sol) ) {

                List<Integer> tempSol = new ArrayList<>();

                for (int j : sol) {

                    tempSol.add(j);

                }

                tempSol.add(originalNums[i]);
                tempSol = tempSol.stream().sorted().collect(Collectors.toList());
                if (!result.contains(tempSol)) {
                    result.add(tempSol);

                }
            }

            int start = originalNums[0];
            System.arraycopy(originalNums, 1, originalNums, 0, numLength - 1);
            originalNums[numLength - 1] = start;

        }

        return result;

    }

    public int[] twoSum(int[] nums, int target) {

        if (Objects.isNull(nums) || nums.length == 0) {

            return null;
        }

        Map<Integer, Integer> result = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {

            int key = (target - nums[i]);

            if (result.containsKey(nums[i])) {
                return new int[]{key, nums[i]};
            }

            result.put(key, i);
        }

        return null;
    }

}
