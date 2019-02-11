package leetCode;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class LeetCode217 {

    @Test
    public void test() {
        Assert.assertTrue(this.containsDuplicate(new int[]{1,2,3,1}));
    }

    @Test
    public void test2() {
        Assert.assertFalse(this.containsDuplicate(new int[]{1,2,35,5}));
    }

    public boolean containsDuplicate(int[] nums) {

        if (nums.length == 1) {
            return false;
        }

        Arrays.sort(nums);

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i-1]) {
                return true;
            }
        }

        return false;
    }

    public boolean containsDuplicate2(int[] nums) {
        Set<Integer> integers = new HashSet<>();

        for (int i : nums) {
            integers.add(i);
        }

        return ( integers.size() != nums.length);
    }
}
