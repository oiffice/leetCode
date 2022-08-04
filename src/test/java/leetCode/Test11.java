package leetCode;

import org.junit.Test;

import java.util.Arrays;

public class Test11 {
    @Test
    public void test1() {
        print(productExceptSelf(new int[]{1,2,3,4}));
    }

    @Test
    public void test2() {
        print(productExceptSelf(new int[]{-1, 1, 0, -3, 3}));
    }
    private void print(int[] nums) {
        for (int n : nums) {
            System.out.println(n);
        }
    }
    public int[] productExceptSelf(int[] nums) {
        int total = 1;
        int zeroIdx = -1;
        int countZero = 0;
        boolean containsZero = false;
        for (int i = 0; i < nums.length;i++) {
            if (nums[i] == 0) {
                containsZero = true;
                zeroIdx = i;
                countZero++;
            } else {
                total *= nums[i];
            }
        }

        int[] answers = new int[nums.length];

        if (containsZero) {
            Arrays.fill(answers, 0);
            if (countZero == 1) {
                answers[zeroIdx] = total;
            }
            return answers;
        }

        for (int i = 0; i < nums.length; i++) {
            answers[i] = total / nums[i];
        }
        return answers;
    }
}
