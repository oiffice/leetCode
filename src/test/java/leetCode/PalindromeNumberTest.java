package leetCode;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by oiffice on 2018/7/18.
 */
public class PalindromeNumberTest {

    @Test
    public void testing() {

        int test1 = 121;
        Assert.assertTrue(isPalindrome(test1));

        int test2 = -121;
        Assert.assertFalse(isPalindrome(test2));

        int test3 = 21;
        Assert.assertFalse(isPalindrome(test3));

        int test4 = 0;
        Assert.assertTrue(isPalindrome(test4));

        int test5 = 1001;
        Assert.assertTrue(isPalindrome(test5));
    }

    public boolean isPalindrome(int x) {

        String number = String.valueOf(x);

        for (int i = 0, j = number.length() - 1; i < number.length() / 2; i++, j--) {

            if (number.charAt(i) != number.charAt(j)) {
                return false;
            }

        }

        return true;

    }
}
