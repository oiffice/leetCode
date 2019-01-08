package leetCode.OneToTen;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by oiffice on 2018/9/6.
 */
public class NLeetCode005 {

    @Test
    public void testing() {

        String s1 = "cbadab";

        String result = this.longestPalindrome(s1);

        Assert.assertEquals("aba", result);

    }

    public String longestPalindrome(String s) {

        if (s.isEmpty()) {
            return null;
        }

        if (s.length() == 1) {
            return s;
        }

        String longest = s.substring(0, 1);
        for (int i = 0; i < s.length(); i++) {

            String tmp = helper(s, i, i);
            if (tmp.length() > longest.length()) {
                longest = tmp;
            }

            tmp = helper(s, i, i+1);
            if (tmp.length() > longest.length()) {
                longest = tmp;
            }

        }

        return longest;
    }

    // Given a center, either one letter or two letter,
    // Find longest palindrome
    private String helper(String s, int begin, int end) {
        while (begin >= 0 && end <= s.length() - 1 && s.charAt(begin) == s.charAt(end)) {
            begin--;
            end++;
        }
        return s.substring(begin + 1, end);
    }
}
