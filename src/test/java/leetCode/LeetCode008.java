package leetCode;

import org.junit.Assert;
import org.junit.Test;

import java.math.BigInteger;

/**
 * Created by oiffice on 2018/7/18.
 */
public class LeetCode008 {

    @Test
    public void testing() {

        String test1 = "42";
        Assert.assertEquals(42, myAtoi(test1));

        String test2 = "   -42";
        Assert.assertEquals(-42, myAtoi(test2));

        String test3 = "4193 with words";
        Assert.assertEquals(4193, myAtoi(test3));

        String test4 = "words and 987";
        Assert.assertEquals(0, myAtoi(test4));

        String test5 = "-91283472332";
        Assert.assertEquals(Integer.MIN_VALUE, myAtoi(test5));

        String test6 = "-";
        Assert.assertEquals(0, myAtoi(test6));

        String test7 = "adb";
        Assert.assertEquals(0, myAtoi(test7));

        String test8 = "";
        Assert.assertEquals(0, myAtoi(test8));

        String test9 = "20000000000000000000";
        Assert.assertEquals(Integer.MAX_VALUE, myAtoi(test9));

        String test10 = "+3.2413";
        Assert.assertEquals(3, myAtoi(test10));

    }

    public int myAtoi(String str) {

        str = str.trim();

        if (str.isEmpty()) {
            return 0;
        }

        int revers = 1;

        if (str.charAt(0) == '-') {
            revers = -1;
            str = str.substring(1);
        } else if (str.charAt(0) == '+') {
            revers = 1;
            str = str.substring(1);
        }

        if (str.isEmpty() || !Character.isDigit(str.charAt(0))) {
            return 0;
        }

        long result = 0;

        int i = 0;
        while (i < str.length() && str.charAt(i) >= '0' && str.charAt(i) <= '9') {

            result = result * 10 + Character.getNumericValue(str.charAt(i));

            if ( (result * revers) > Integer.MAX_VALUE ) {
                return Integer.MAX_VALUE;
            } else if ((result * revers) < Integer.MIN_VALUE) {
                return Integer.MIN_VALUE;
            }

            i++;

        }

        return Long.valueOf(result).intValue() * revers;
    }
}
