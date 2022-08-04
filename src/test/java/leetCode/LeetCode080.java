package leetCode;

import org.junit.Test;

public class LeetCode080 {
    @Test
    public void test1() {
        int[] nums = new int[]{0,0,1,1,1,1,2,3,3};
        System.out.println(removeDuplicates(nums));
        for (int num : nums) {
            System.out.println(num);
        }
    }
    @Test
    public void test2() {
        int[] nums = new int[]{0,0};
        System.out.println(removeDuplicates(nums));
        for (int num : nums) {
            System.out.println(num);
        }
    }
    @Test
    public void test3() {
        int[] nums = new int[]{0,0,0};
        System.out.println(removeDuplicates(nums));
        for (int num : nums) {
            System.out.println(num);
        }
    }
    public int removeDuplicates(int[] nums) {

        if (nums.length == 1) {
            return 1;
        }

        int i = 0;
        int duplicateCount = 1;
        int temp = nums[i];
        int finalLen = nums.length;

        while (i < finalLen && i + 1 < nums.length) {
            if (nums[i + 1] == temp) {
                if (duplicateCount + 1 > 2) {
                    finalLen--;
                    sort(i + 1, nums);
                    i--;
                } else {
                    duplicateCount++;
                }
            } else {
                duplicateCount = 1;
                temp = nums[i + 1];
            }

            i++;
        }

        return finalLen;
    }

    private void sort(int start, int[] nums) {
        nums[start] = nums[nums.length - 1];
        nums[nums.length - 1] = Integer.MAX_VALUE;
        for (int i = start; i < nums.length - 2; i++) {
            int temp = nums[i];
            nums[i] = nums[i+1];
            nums[i+1] = temp;
        }
    }
}
