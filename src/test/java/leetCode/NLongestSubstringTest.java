package leetCode;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by oiffice on 2018/7/16.
 */
public class NLongestSubstringTest {

    @Test
    public void longestSubstringTest() {
        String test1 = "abcabcbb";
        Assert.assertEquals(3, lengthOfLongestSubstring(test1));

        String test2 = "bbbbbbbb";
        Assert.assertEquals(1, lengthOfLongestSubstring(test2));

        String test3 = "pwwkew";
        Assert.assertEquals(3, lengthOfLongestSubstring(test3));
    }


    public int lengthOfLongestSubstring(String s) {

        int n = s.length();
        Set<Character> set = new HashSet<>();
        int ans = 0, i = 0, j = 0;
        while (i < n && j < n) {
            // try to extend the range [i, j]
            if (!set.contains(s.charAt(j))){
                set.add(s.charAt(j++));
                ans = Math.max(ans, j - i);
            }
            else {
                set.remove(s.charAt(i++));
            }
        }
        return ans;


    }
}
