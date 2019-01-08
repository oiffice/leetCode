package leetCode.XIToTwenty;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class LeetCode012 {
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

    public String intToRoman(int num) {
        int digitals = String.valueOf(num).length();

        Map<Integer, String> numberToRoma = new HashMap<>();
        numberToRoma.put(1000, "M");
        numberToRoma.put(500, "D");
        numberToRoma.put(100, "C");
        numberToRoma.put(50, "L");
        numberToRoma.put(10, "X");
        numberToRoma.put(5, "V");
        numberToRoma.put(1, "I");

        String result = "";

        for (int i = digitals - 1; i >= 0; i--) {

            int divider = (int) Math.pow(10, i);
            int divide = num / divider;
            num = num % divider;

            if (divide % 5 == 4) { // deal with 9, 4

                result = result.concat(numberToRoma.get(divider) + numberToRoma.get(divider * (divide + 1)));

            } else if (divide > 5) { // deal with 6~8

                result = result.concat(numberToRoma.get(divider * 5));

                for (int j = 0; j < (divide - 5); j++) {
                    result = result.concat(numberToRoma.get(divider));
                }


            } else if (divide > 0 && divide % 5 == 0 ) {
                result = result.concat(numberToRoma.get(divider * divide));

            } else {

                for (int j = 0; j < divide; j++) {
                    result = result.concat(numberToRoma.get(divider));
                }

            }

        }

        return result.toUpperCase();
    }
}