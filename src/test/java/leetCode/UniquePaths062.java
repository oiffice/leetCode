package leetCode;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class UniquePaths062 {
    public int uniquePaths(int m, int n) {

        int l = Math.max(m, n);
        int w = Math.min(m, n);
        int[][] d = new int[l+1][w+1];
        d[1][1] = 1;

        for (int i = 1; i <= l; i++) {
            for (int j = 1; j <= w; j++) {
                if (i == 1 && j == 1) continue;
                d[i][j] = d[i - 1][j] + d[i][j - 1];
            }
        }

        return d[l][w];
    }

    public int uniquePathsII(int m, int n) {

        double num = 1, denom = 1;
        int small = m > n ? n : m;
        for (int i = 1; i <= small - 1; ++i) {
            num *= m + n - 1 - i;
            denom *= i;
        }
        return (int)(num / denom);
    }

    @Test
    public void test11() {
        assertEquals(193536720, uniquePaths(23, 12));
    }

    @Test
    public void test1() {
        assertEquals(20, uniquePaths(4, 4));
    }

    @Test
    public void test2() {
        assertEquals(28, uniquePaths(3, 7));
    }

    @Test
    public void test3() {
        assertEquals(56, uniquePaths(6, 4));
    }

    @Test
    public void test4(){
        assertEquals(28, uniquePaths(3, 7));
    }

    @Test
    public void test5() {
        assertEquals(1, uniquePaths(1, 10));
    }

    @Test
    public void test6() {
        assertEquals(20, uniquePaths(4, 4));
    }

    @Test
    public void test7() {
        assertEquals(70, uniquePaths(5, 5));
    }

    @Test
    public void test8() {
        assertEquals(252, uniquePaths(6, 6));
    }

    @Test
    public void test9() {
        assertEquals(48620, uniquePaths(10, 10));
    }

    @Test
    public void test10() {
        assertEquals(6435, uniquePaths(9, 8));
    }
}
