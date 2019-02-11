package leetCode.XXIToXXX;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by oiffice on 2018/12/3.
 */
public class LeetCode027 {

    @Test
    public void test1() {

        int[] input = new int[]{0,0,2,2,3,3,4,5,6,6};

        Assert.assertEquals(6, this.removeElement(input, 6));

    }

    @Test
    public void test2() {

        int[] input = new int[]{1};

        Assert.assertEquals(0, this.removeElement(input, 1));

    }

    @Test
    public void test3() {

        int[] input = new int[]{3,2,2,3};

        Assert.assertEquals(2, this.removeElement(input, 3));

    }

    public int removeElement(int[] nums, int val) {

        int diffCount = 0;


        for (int i = 0; i < nums.length; i++) {

            if (nums[i] != val) {
                nums[diffCount] = nums[i];
                diffCount++;
            }

        }


        return diffCount;
    }
}
