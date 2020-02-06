package leetCode.XXX1ToIX;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NLeetCode040 {

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> curr = new ArrayList<Integer>();
        Arrays.sort(candidates);
        helper(result, curr, 0, target, candidates);
        return result;
    }

    public void helper(List<List<Integer>> result, List<Integer> curr, int start, int target, int[] candidates){
        if(target==0){
            result.add(new ArrayList<Integer>(curr));
            return;
        }
        if(target<0){
            return;
        }

        int prev=-1;
        for(int i=start; i<candidates.length; i++){
            if(prev!=candidates[i]){ // each time start from different element
                curr.add(candidates[i]);
                helper(result, curr, i+1, target-candidates[i], candidates); // and use next element only
                curr.remove(curr.size()-1);
                prev=candidates[i];
            }
        }
    }

    @Test
    public void test1() {
        int[] candidates = new int[]{10, 1, 2, 7, 6, 1, 5};

        List<List<Integer>> result = combinationSum2(candidates, 8);
        System.out.println(result);

    }

    @Test
    public void test2() {
        int[] candidates = new int[]{2, 5, 2, 1, 2};

        List<List<Integer>> result = combinationSum2(candidates, 5);
        System.out.println(result);

    }

    @Test
    public void test3() {
        int[] candidates = new int[]{2, 4, 1, 5, 6, 2, 2, 1};

        List<List<Integer>> result = combinationSum2(candidates, 9);
        System.out.println(result);

    }

    @Test
    public void test4() {
        int[] candidates = new int[]{2};

        List<List<Integer>> result = combinationSum2(candidates, 1);
        System.out.println(result);

    }

    @Test
    public void test5() {
        int[] candidates = new int[]{1, 1};

        List<List<Integer>> result = combinationSum2(candidates, 2);
        System.out.println(result);

    }

    @Test
    public void test6() {
        int[] candidates = new int[]{3, 1, 3, 5, 1, 1};

        List<List<Integer>> result = combinationSum2(candidates, 8);
        System.out.println(result);

    }

    @Test
    public void test7() {
        int[] candidates = new int[]{4,4,2,1,4,2,2,1,3};

        List<List<Integer>> result = combinationSum2(candidates, 6);
        System.out.println(result);

    }

    @Test
    public void test8() {
        int[] candidates = new int[]{2, 3};

        List<List<Integer>> result = combinationSum2(candidates, 5);
        System.out.println(result);

    }

    @Test
    public void test9() {
        int[] candidates = new int[]{4,1,1,4,4,4,4,2,3,5};

        List<List<Integer>> result = combinationSum2(candidates, 10);
        System.out.println(result);

    }
}
