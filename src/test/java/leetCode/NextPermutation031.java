package leetCode;

import org.junit.Test;

public class NextPermutation031 {
    @Test
    public void test1() {
        int[] nums = new int[]{1,5,2,4,3};
        nextPermutation(nums);
        for (int i : nums) {
            System.out.println(i);
        }
    }
    @Test
    public void test2() {
        int[] nums = new int[]{5,4,3,2,1};
        nextPermutation(nums);
        for (int i : nums) {
            System.out.println(i);
        }
    }
    private void swap(int[] nums, int a, int b) {
        int t = nums[a];
        nums[a] = nums[b];
        nums[b] = t;
    }
    public void nextPermutation(int[] nums) {
       int p;
        int i = nums.length - 1;
       for (; i > 0; i--) {
           if (nums[i - 1] < nums[i]) {
               p = nums[i - 1];

               for (int j = nums.length - 1; j >= i; j--) {
                   if (nums[j] > p) {
                       swap(nums, i - 1, j);
                       break;
                   }
               }
               break;
           }
       }
        for (int k = i, h = nums.length - 1; k < h; k++, h--) {
            swap(nums, k, h);
        }
    }

}
