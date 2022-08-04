package leetCode;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class LeetCode1423 {
    @Test
    public void test1() {
        assertEquals(12, maxScore(new int[]{3,6,1,5,6,5,1}, 3));

    }
    @Test
    public void test2() {
        assertEquals(4, maxScore(new int[]{2,2,2,2,2}, 2));
    }
    @Test
    public void test3() {
        assertEquals(55, maxScore(new int[]{9,7,7,9,7,7,9}, 7));
    }
    @Test
    public void test4() {
        assertEquals(248, maxScore(new int[]{100,40,17,9,73,75}, 3));
    }
    public int maxScore(int[] cardPoints, int k) {
        int temp = 0;
        for(int i = 0; i < k; i++) {
            temp += cardPoints[i];
        }
        int max = temp;
        int rTemp = 0;
        for(int i = k - 1, j = cardPoints.length - 1; i >= 0; i--, j--) {
            temp -= cardPoints[i];
            rTemp += cardPoints[j];
            max = Math.max(max, temp + rTemp);
        }
        return max;
    }
}
