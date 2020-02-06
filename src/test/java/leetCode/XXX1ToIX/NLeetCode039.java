package leetCode;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/**
 * Created by oiffice on 2018/12/26.
 */
public class NLeetCode039 {

    @Test
    public void test1() {

        int[] candidates = new int[]{2,3,6,7};
        int target = 7;

        List<Integer> integers1 = new ArrayList<Integer>(){{ add(7); }};
        List<Integer> integers2 = new ArrayList<Integer>(){{ add(2); add(2); add(3); }};
        List<List<Integer>> expectList = new ArrayList<List<Integer>>(){{ add(integers1); add(integers2); }};

        List<List<Integer>> result = this.combinationSum(candidates, target);

        Assert.assertTrue(result.size() > 0);

        result.forEach(r -> System.out.println(r));

    }

    @Test
    public void test2() {

        int[] candidates = new int[]{2,3,5};
        int target = 8;

        List<List<Integer>> result = this.combinationSum(candidates, target);

        Assert.assertTrue(result.size() > 0);

        result.forEach(r -> System.out.println(r));
    }

    @Test
    public void test3() {

        int[] candidates = new int[0];
        int target = 8;

        List<List<Integer>> result = this.combinationSum(candidates, target);

        Assert.assertTrue(result.size() == 0);

        result.forEach(r -> System.out.println(r));
    }

    @Test
    public void test4() {

        int[] candidates = new int[]{1};
        int target = 8;

        List<List<Integer>> result = this.combinationSum(candidates, target);

        Assert.assertTrue(result.size() == 1);

        result.forEach(r -> System.out.println(r));
    }

    @Test
    public void test5() {

        int[] candidates = new int[]{1, 2};
        int target = 8;

        List<List<Integer>> result = this.combinationSum(candidates, target);

//        Assert.assertTrue(result.size() == 1);

        result.forEach(r -> System.out.println(r));
    }

    @Test
    public void test6() {
        int[] candidates = new int[]{8,7,4,3};
        int target = 11;

        List<List<Integer>> result = this.combinationSum(candidates, target);

        Assert.assertTrue(result.size() == 3);

        result.forEach(r -> System.out.println(r));
    }

    @Test
    public void test7() {
        int[] candidates = new int[]{1,1,2,5,6,7,10};
        int target = 8;

        List<List<Integer>> result = this.combinationSum(candidates, target);

        Assert.assertTrue(result.size() == 3);

        result.forEach(r -> System.out.println(r));
    }


    public List<List<Integer>> combinationSum(int[] candidates, int target) {

        List<List<Integer>> result = new ArrayList<>();

        if (Objects.isNull(candidates) || candidates.length == 0) {
            return result;
        }

        if (candidates.length == 1 && candidates[0] == target) {
            result.add(Arrays.asList(target));
            return result;
        }

        Arrays.sort(candidates);
        backtracking(result, candidates, target, new int[target/candidates[0] + 1], 0, 0);
        return result;

    }

    private void backtracking(List<List<Integer>> result, int[] candidates, int target, int[] temp, int k, int start) {
        for (int idx = start; idx < candidates.length; idx++) {
            temp[k] = candidates[idx];
            int sum = 0;
            for (int i = 0; i <= k; i++)
                sum += temp[i];

            if (sum == target) {
                List<Integer> list = new ArrayList<>();
                for (int i = 0; i <= k; i++)
                    list.add(temp[i]);
                result.add(list);
            } else if (sum < target) {
                backtracking(result, candidates, target, temp, k + 1, idx);
            } else {
                break;
            }
        }
    }


}
