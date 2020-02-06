package leetCode;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LeetCode069 {

    public int mySqrt(int a) {
        long x = a;
        while (x * x > a) {
            x = (x + a / x) / 2;

        }
        return (int)x;
    }

    @Test
    public void test1() {
        assertEquals(2, mySqrt(4));
    }

    @Test
    public void test2() {
        assertEquals(3, mySqrt(9));
    }

    @Test
    public void test3() {
        assertEquals(2, mySqrt(8));
    }

    @Test
    public void test4() {
        assertEquals(9, mySqrt(98));
    }
}
