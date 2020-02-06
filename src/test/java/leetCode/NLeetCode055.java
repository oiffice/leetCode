package leetCode;

import org.junit.Test;

import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertTrue;

public class NLeetCode055 {

    public boolean canJump(int[] nums) {
        int max = 0;
        for(int i = 0; i <= max; i++)
        {
            if(i == nums.length-1) return true;
            max = max < i + nums[i] ? i + nums[i] : max;
        }
        return false;
    }

    @Test
    public void test1() {
        int[] candidates = new int[]{2, 3, 1, 1, 4};
        assertTrue(canJump(candidates));
    }

    @Test
    public void test2() {
        int[] candidates = new int[]{3, 2, 1, 0, 4};
        assertFalse(canJump(candidates));
    }

    @Test
    public void test3() {
        int[] candidates = new int[]{5, 2, 1, 5, 0, 3};
        assertTrue(canJump(candidates));
    }

    @Test
    public void test4() {
        int[] candidates = new int[]{3, 2, 1, 5, 0, 3};
        assertTrue(canJump(candidates));
    }

    @Test
    public void test5() {
        int[] candidates = new int[]{0};
        assertTrue(canJump(candidates));
    }

    @Test
    public void test6() {
        int[] candidates = new int[]{2};
        assertTrue(canJump(candidates));
    }

    @Test
    public void test7() {
        int[] candidates = new int[]{2, 0};
        assertTrue(canJump(candidates));
    }

    @Test
    public void test8() {
        int[] candidates = new int[]{0, 2};
        assertFalse(canJump(candidates));
    }

    @Test
    public void test9() {
        int[] candidates = new int[]{2, 0 , 0};
        assertTrue(canJump(candidates));
    }

    @Test
    public void test10() {
        int[] candidates = new int[]{2, 5, 0 , 0};
        assertTrue(canJump(candidates));
    }

    @Test
    public void test11() {
        int[] candidates = new int[]{1, 1, 0, 1};
        assertFalse(canJump(candidates));
    }

    @Test
    public void test12() {
        int[] candidates = new int[]{3, 0 , 8 , 2, 0 , 0, 1};
        assertTrue(canJump(candidates));
    }

    @Test
    public void test13() {
        int[] candidates = new int[]{2,4,4,2,0,3,1,4,1,3,2,0,1,1,2,1,0,1,4};
        assertFalse(canJump(candidates));
    }

    @Test
    public void test14() {
        int[] candidates = new int[]{2,0,6,9,8,4,5,0,8,9,1,2,9,6,8,8,0,6,3,1,2,2,1,2,6,5,3,1,2,2,6,4,2,4,3,0,0,0,3,8,2,4,0,1,2,0,1,4,6,5,8,0,7,9,3,4,6,6,5,8,9,3,4,3,7,0,4,9,0,9,8,4,3,0,7,7,1,9,1,9,4,9,0,1,9,5,7,7,1,5,8,2,8,2,6,8,2,2,7,5,1,7,9,6};
        assertFalse(canJump(candidates));
    }
}
