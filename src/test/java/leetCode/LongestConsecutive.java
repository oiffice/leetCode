package leetCode;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class LongestConsecutive {

    @Test
    public void test() {
        System.out.println(longestConsecutive(new int[]{100, 4, 200, 3, 1, 2}));
    }

    public int longestConsecutive(int[] nums) {
        Map<Integer, Integer> mp = new HashMap<>();
        int max = 0;
        for (int num : nums) {
            int less = mp.getOrDefault(num - 1, 0);
            int greater = mp.getOrDefault(num + 1, 0);
            int count = less + greater + 1;
            mp.put(num, count);
            max = Math.max(count, max);
            mp.put(num - 1, count);
            mp.put(num + 1, count);
        }
        return max;
    }
}
