package leetCode.XIToTwenty;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by oiffice on 2018/11/8.
 */
public class NLeetCode012 {

    @Test
    public void assertIII() {

        Assert.assertEquals("III", this.intToRoman(3));
    }

    @Test
    public void assertIV() {

        Assert.assertEquals("IV", this.intToRoman(4));
    }

    @Test
    public void assertIX() {

        Assert.assertEquals("IX", this.intToRoman(9));
    }

    @Test
    public void assertLVIII() {

        Assert.assertEquals("LVIII", this.intToRoman(58));
    }

    @Test
    public void assertMCMXCIV() {

        Assert.assertEquals("MCMXCIV", this.intToRoman(1994));
    }

    @Test
    public void assertLXXXVII() {

        Assert.assertEquals("LXXXVII", this.intToRoman(87));
    }

    @Test
    public void assertX() {

        Assert.assertEquals("X", this.intToRoman(10));
    }

    private String intToRoman(int num) {
        String[] m = {"", "M", "MM", "MMM"};
        String[] c = {"", "C", "CC", "CCC", "DC", "D", "DC", "DCC", "DCCC", "CM"};
        String[] x = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
        String[] i = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};

        String result = "";

        result = m[num/1000];

        num = num % 1000;
        result += c[num/100];

        num = num % 100;
        result += x[num/10];

        num = num % 10;
        result += i[num];

        return result.toUpperCase();
    }
}
