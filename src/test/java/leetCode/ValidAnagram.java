package leetCode;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ValidAnagram {
    @Test
    public void test1() {
        System.out.println(isAnagram("asdfaf", "fdsafa"));
    }
    @Test
    public void test2() {
        System.out.println(isAnagram("aaa", "aab"));
    }
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        char[] sArr = s.toCharArray();
        char[] tArr = t.toCharArray();

        Arrays.sort(sArr);
        Arrays.sort(tArr);

        for (int i = 0; i < sArr.length; i++) {
            if (sArr[i] != tArr[i]) {
                return false;
            }
        }

        return true;
    }
}
