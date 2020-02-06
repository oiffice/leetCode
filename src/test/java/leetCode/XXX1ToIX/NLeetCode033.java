package leetCode.XXX1ToIX;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by oiffice on 2018/12/25.
 */
public class NLeetCode033 {

    @Test
    public void test1() {

        int[] nums = new int[]{4,5,6,7,0,1,2};
        int index = this.search(nums, 0);

        Assert.assertEquals(4, index);

    }

    @Test
    public void test2() {

        int[] nums = new int[]{9, 10, 11, 12, 13, 0, 2, 4, 5};
        int index = this.search(nums, 0);

        Assert.assertEquals(5, index);

    }

    @Test
    public void test3() {

        int[] nums = new int[]{9, 10, 11, 12, 13, 0, 2, 4, 5};
        int index = this.search(nums, 12);

        Assert.assertEquals(3, index);

    }

    @Test
    public void test4() {

        int[] nums = new int[]{9, 10, 11, 12, 13, 0, 2, 4, 5};
        int index = this.search(nums, 8);

        Assert.assertEquals(-1, index);

    }

    @Test
    public void test5() {
        int[] nums = new int[]{7,8,1,2,3,4,5,6};
        int index = this.search(nums, 1);

        Assert.assertEquals(2, index);
    }

    @Test
    public void tes6() {
        int[] nums = new int[]{7,8,1,2,3,4,5,6};
        int index = this.search(nums, 5);

        Assert.assertEquals(6, index);
    }

    @Test
    public void test7() {

        int[] nums = new int[]{9,1,2,3,4,5,6,7,8};
        int index = this.search(nums, 9);
        Assert.assertEquals(0, index);
    }

    public int search(int[] nums, int target) {

        int numLength = nums.length;

        if (numLength == 0) {
            return -1;
        }

        if (numLength == 1) {
            return (nums[0] == target) ? 0 : -1;
        }

        int left = 0;
        int right= nums.length-1;

        while(left<=right){
            int mid = left + (right-left)/2;
            if(target==nums[mid])
                return mid;

            if(nums[left]<=nums[mid]){
                if(nums[left]<=target&& target<nums[mid]){
                    right=mid-1;
                }else{
                    left=mid+1;
                }
            }else{
                if(nums[mid]<target&& target<=nums[right]){
                    left=mid+1;
                }else{
                    right=mid-1;
                }
            }
        }

        return -1;
    }

}
