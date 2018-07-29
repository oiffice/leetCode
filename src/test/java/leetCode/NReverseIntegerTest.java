package leetCode;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by oiffice on 2018/7/18.
 */
public class NReverseIntegerTest {

    @Test
    public void testing() {
//
        int test1 = 123;
        Assert.assertEquals(321, reverse(test1));

        int test2 = -123;
        Assert.assertEquals(-321, reverse(test2));

        int test3 = 120;
        Assert.assertEquals(21, reverse(test3));

        int test4 = 0;
        Assert.assertEquals(0, reverse(test4));

        int test5 = 1534236469;
        Assert.assertEquals(0, reverse(test5));

    }

    public int reverse(int num) {

        long times = 1;

        List<Integer> integers = new ArrayList<>();

        while (num != 0) {

            integers.add(num % 10);
            num = num / 10;
            times = times * 10;

        }

        long result = 0;

        for (int integer : integers) {

            times = times / 10;
            result += integer * times;

        }

        if (result > Integer.MAX_VALUE) {
            return 0;
        } else if (result < Integer.MIN_VALUE) {
            return 0;
        } else {
            return Long.valueOf(result).intValue();
        }

    }
}
