package leetCode;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LeetCode0740 {
    @Test
    public void test1() {
        System.out.println(deleteAndEarn(new int[]{2, 3, 3, 3, 4}));
    }
    @Test
    public void test2() {
        System.out.println(deleteAndEarn(new int[]{2,3,3,3,3,5,7}));
    }
    @Test
    public void test3() {
        System.out.println(deleteAndEarn(new int[]{3,4,2}));
    }

    public int deleteAndEarn(int[] nums) {
        Arrays.sort(nums);
        int[] d = new int[nums.length];
        d[0] = nums[0];
        Map<Integer, Integer> map = new HashMap<>();
        int preNum = nums[0];

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == preNum) {
                map.put(nums[i],map.get(nums[i]) + nums[i]);
                preNum = nums[i];
                d[i] = map.get(nums[i]) + nums[i];
            } else if (nums[i] - 1 != preNum) {
                map.put(nums[i], nums[i]);
                d[i] = nums[i];
                preNum = nums[i];
            } else {
                int max = Integer.MIN_VALUE;
                for (Map.Entry<Integer, Integer> entry: map.entrySet()) {
                    if (entry.getKey() < nums[i] - 1 && max < entry.getValue()) {
                        max = entry.getValue();
                    }
                }
                map.put(nums[i], nums[i] + max);
                d[i] = nums[i] + max;
            }
        }
        int max = Integer.MIN_VALUE;
        for (int i : d) {
            if (max < i) {
                max = i;
            }
        }

        return max;
    }
}
