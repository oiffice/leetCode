package leetCode;

import org.junit.Assert;
import org.junit.Test;

/**
 * Reference by
 * @link https://blog.csdn.net/mine_song/article/details/70482898
 */
public class LeetCode043 {

    @Test
    public void test() {
        Assert.assertEquals("390", this.multiply("15", "26"));
    }

    @Test
    public void test2() {
        Assert.assertEquals("121932631112635269", this.multiply("123456789", "987654321"));
    }

    @Test
    public void test3() {
        Assert.assertEquals("67143675422804947379429215144664313370120390398055713625298709447", this.multiply("401716832807512840963", "167141802233061013023557397451289113296441069"));
    }

    public String multiply(String num1, String num2) {

        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }

        String main = num1;
        String second = num2;
        int[] result = new int[num1.length() + num2.length()];

        if (num1.length() > num2.length()) {
            main = num2;
            second = num1;
        }

        for (int i = main.length() - 1; i >= 0; i--) {

            int stable = (main.charAt(i) - '0');

            for (int j = second.length() - 1; j >= 0; j--) {

                int tempResult = stable * (second.charAt(j) - '0');
                int p1 = i+j, p2 = i+j+1;
                int sum = tempResult + result[p2];

                result[p1] += sum / 10;
                result[p2] = sum % 10;

                if (result[p1] >= 10) {
                    result[p1-1] += result[p1] / 10;
                    result[p1] %= 10;
                }
            }
        }

        StringBuilder stringBuilder = new StringBuilder();

        for (int i = result.length - 1; i >= 0; i--) {

            if (i > 0 || result[i] != 0) {
                stringBuilder.append(result[i]);
            }
        }

        return stringBuilder.reverse().toString();
    }
}
