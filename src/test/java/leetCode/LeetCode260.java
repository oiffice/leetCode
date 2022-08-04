package leetCode;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class LeetCode260 {
    @Test
    public void test1() {
        int[] result = singleNumber(new int[]{1,2,1,2,3,5});
        for (int i : result) {
            System.out.println(i);
        }
    }
    @Test
    public void test2() {
        int[] result = singleNumber(new int[]{});
        for (int i : result) {
            System.out.println(i);
        }
    }
    public int[] singleNumber2(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : nums) {
            if (map.containsKey(i)) {
                map.remove(i);
            } else {
                map.put(i,i);
            }
        }
        return map.keySet().stream().mapToInt(Integer::intValue).toArray();
    }
    public int[] singleNumber(int[] nums) {
        int sum=0;
        for (int j : nums) {
            sum = sum ^ j;
        }
        int onBit = sum & (-sum);
        int[] result = new int[2];

        for (int num : nums) {
            if ((onBit & num) == 0) {
                result[0] = result[0] ^ num;
            } else {
                result[1] = result[1] ^ num;
            }
        }
        return result;
    }
}
