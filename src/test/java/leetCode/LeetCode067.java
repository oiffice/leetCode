package leetCode;

import org.junit.Assert;
import org.junit.Test;

public class LeetCode067 {

    @Test
    public void test1() {

        String a = "01";
        String b = "111";

        Assert.assertEquals("1000", this.addBinary(a, b));

    }

    @Test
    public void test2() {

        String a = "10100000100100110110010000010101111011011001101110111111111101000000101111001110001111100001101";
        String b = "110101001011101110001111100110001010100001101011101010000011011011001011101111001100000011011110011";

        Assert.assertEquals("1010", this.addBinary(a, b));

    }

    @Test
    public void test3() {

        String a = "11";
        String b = "1";

        Assert.assertEquals("100", this.addBinary(a, b));

    }

    @Test
    public void test4() {

        String a = "0";
        String b = "0";

        Assert.assertEquals("0", this.addBinary(a, b));

    }

    public String addBinary(String a, String b) {

        int aLen = a.length() - 1;
        int bLen = b.length() - 1;
        int sum = 0;
        StringBuilder stringBuilder = new StringBuilder();


        while (aLen >= 0 || bLen >= 0) {

            if (aLen >= 0) {
                sum += a.charAt(aLen) - '0';
                aLen--;
            }

            if (bLen >= 0) {
                sum += b.charAt(bLen) - '0';
                bLen--;
            }

            stringBuilder.append(sum % 2);
            sum = sum / 2;
        }

        if (sum == 0) {
            return stringBuilder.reverse().toString();
        }

        return stringBuilder.append(sum).reverse().toString();

    }

}
