package leetCode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class LeetCode090 {
    @Test
    public void test1() {
        System.out.println(subsetsWithDup(new int[]{1, 2, 2}));
    }
    @Test
    public void test2() {
        System.out.println(subsetsWithDup(new int[]{}));
    }
    @Test
    public void test3() {
        System.out.println(subsetsWithDup(new int[]{1,1,1}));
    }

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>());
        for (int num : nums) {
            doit(result, num);
        }
        return result.stream().distinct().collect(Collectors.toList());
    }

    private void doit(List<List<Integer>> list, int num) {
        int size = list.size();
        for(int i = 0; i < size; i++) {
            List<Integer> l = new ArrayList<>(list.get(i));
            if (!l.contains(num)) {
                l.add(num);
                list.add(l);
            }
        }
    }
}
