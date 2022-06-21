package leetCode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class LeetCode300 {
    @Test
    public void test1() {
        System.out.println(lengthOfLIS(new int[]{4, 10, 4, 3, 8, 9}));
    }
    @Test
    public void test2() {
        System.out.println(lengthOfLIS(new int[]{0,1,0,3,2,3}));
    }
    @Test
    public void test3() {
        System.out.println(lengthOfLIS(new int[]{1, 1, 1, 1, 1, 1}));
    }

    public int lengthOfLIS(int[] nums) {
        List<Integer> list = new ArrayList<>();

        for (int i : nums) {

            if (list.isEmpty()) {
                list.add(i);
            } else if (list.get(0) < i && i < list.get(list.size() - 1)) {
                int l = 0;
                int r = list.size();
                while (l < r) {
                    int m = l + (r - l) / 2;
                    if (list.get(m) < i) {
                        l = m + 1;
                    } else {
                        r = m;
                    }
                }
                list.set(r, i);
            } else if (i < list.get(0)) {
                list.set(0, i);
            } else if (list.get(list.size() - 1) < i) {
                list.add(list.size(), i);
            }
        }
        return list.size();
    }
}
