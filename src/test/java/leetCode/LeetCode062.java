package leetCode;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LeetCode062 {

    public int uniquePaths(int m, int n) {

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
        assertEquals(3, uniquePaths(3, 2));
    }

    @Test
    public void test2() {
        assertEquals(28, uniquePaths(7, 3));
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
