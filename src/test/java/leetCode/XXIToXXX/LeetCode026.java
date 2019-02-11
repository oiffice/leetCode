package leetCode.XXIToXXX;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by oiffice on 2018/12/3.
 */
public class LeetCode026 {

    @Test
    public void test1() {

        int[] input = new int[]{0,0,2,2,3,3,4,5,6,6};

        Assert.assertEquals(6, this.removeDuplicates(input));

    }

    @Test
    public void test2() {

        int[] input = new int[]{0,0,1,1,1,2,2,3,3,4};

        Assert.assertEquals(5, this.removeDuplicates(input));

    }

    @Test
    public void test3() {

        int[] input = new int[]{1,1,2};

        Assert.assertEquals(2, this.removeDuplicates(input));

    }

    public int removeDuplicates(int[] nums) {

        int diffCount = 0;

        if (nums.length == 0) {
            return 0;
        } else if (nums.length == 1) {
            return 1;
        } else {

            for (int i = 1; i < nums.length; i++) {

                if (nums[i] != nums[diffCount]) {
                    nums[++diffCount] = nums[i];
                }

            }
        }


        return diffCount;
    }
}
