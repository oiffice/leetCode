package leetCode;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by oiffice on 2018/7/27.
 */
public class LeetCode014 {

    @Test
    public void test() {

//        String[] test1 = new String[]{"flower", "flow", "flight"};
//        Assert.assertEquals("fl", longestCommonPrefix(test1));
//
//        String[] test2 = new String[]{"dog","racecar","car"};
//        Assert.assertEquals("", longestCommonPrefix(test2));

        String[] test3 = new String[]{"acbb","a"};
        Assert.assertEquals("a", longestCommonPrefix(test3));
    }

    public String longestCommonPrefix(String[] strs) {

        if (strs.length == 0) {
            return "";
        }

        String firstStr = strs[0];
        int firstStrLen = firstStr.length();

        for(int i = 1; i < strs.length; i++) {

            if (strs[i].equals("")) {
                return "";
            }

            if (firstStrLen > strs[i].length()) {

                firstStr = firstStr.substring(0, firstStrLen - 1);
                firstStrLen = firstStr.length();
                i--;

            } else if (!strs[i].substring(0, firstStrLen).equals(firstStr)) {
                firstStr = firstStr.substring(0, firstStrLen - 1);
                firstStrLen = firstStr.length();
                i--;
            }
        }

        return firstStr;
    }
}
