package leetCode.XXIToXXX;

import org.junit.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * Created by oiffice on 2018/12/3.
 */
public class LeetCode029 {

    @Test
    public void test() {

        int dividend = -2147483648;
        int divisor = -1;

        System.out.println(this.divide(dividend, divisor));
    }

    public int divide(int dividend, int divisor) {

        if (divisor == 0) {
            return -1;
        }

        RoundingMode roundingMode;

        if (dividend < 0 ^ divisor < 0 ) {
            roundingMode = RoundingMode.CEILING;
        } else {
            roundingMode = RoundingMode.FLOOR;
        }

        BigDecimal result = BigDecimal.valueOf(dividend).divide(BigDecimal.valueOf(divisor), roundingMode);

        System.out.println(result);
        if (result.compareTo(BigDecimal.valueOf(Integer.MAX_VALUE)) == 1) {
            return Integer.MAX_VALUE;
        } else if (result.compareTo(BigDecimal.valueOf(Integer.MIN_VALUE)) == -1) {
            return Integer.MIN_VALUE;
        } else {
            return result.intValue();
        }
    }
}
