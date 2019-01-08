package leetCode.OneToTen;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by oiffice on 2018/9/6.
 */
public class LeetCode010 {

    @Test
    public void testing() {

        String s1 = "aa";
//        Assert.assertFalse(this.isMatch(s1, "a"));
        Assert.assertTrue(this.isMatch(s1, "a*"));

    }

    @Test
    public void testing2() {
        String s2 = "abcde";
        Assert.assertTrue(this.isMatch(s2, ".*"));

    }

    @Test
    public void testing3() {

        String s3 = "aab";
        Assert.assertTrue(this.isMatch(s3, "c*a*b"));

    }

    @Test
    public void testing4() {

        String s4 = "xaabyc";
        Assert.assertTrue(this.isMatch(s4, "xa*b.c"));

    }

    @Test
    public void testing5() {

        String s5 = "a";
        Assert.assertFalse(this.isMatch(s5, ""));

    }

    @Test
    public void testing6() {

        String s6 = "mississippi";
        Assert.assertFalse(this.isMatch(s6, "mis*is*p*."));

    }

    public boolean isMatch(String s, String p) {

        if (p.isEmpty() || s.isEmpty()) {
            return false;
        }

        List<List<Boolean>> resultList = new ArrayList<>();
        List<Boolean> patterToString = new ArrayList<>();
        boolean isMatches;

        patterToString.add(0, Boolean.TRUE);

        for (int i = 1; i < p.length() + 1; i++) {

            patterToString.add(i, Boolean.FALSE);

        }

        resultList.add(0, patterToString);

        for (int j = 1; j < s.length()+1; j++) {

            List<Boolean> temp = new ArrayList<>();
            temp.add(Boolean.FALSE);
            resultList.add(j, temp);
        }

        int strToP = 0;
        int pattToStr = 1;

        for (int stringIdx = 0; stringIdx < s.length(); stringIdx++) {

            char sc = s.charAt(stringIdx);
            if (stringIdx == 3) {

                System.out.println("Asdf");
            }

            strToP = (strToP + 1) > s.length() ? strToP : ++strToP;
            pattToStr = 1;

            for (int pattenIdx = 0; pattenIdx < p.length(); pattenIdx++) {

                char pc = p.charAt(pattenIdx);
                if (s.charAt(stringIdx) == p.charAt(pattenIdx) || p.charAt(pattenIdx) == '.') {

                    isMatches = resultList.get(strToP - 1).get(pattToStr - 1);

                } else if (p.charAt(pattenIdx) == '*') {

                    isMatches = resultList.get(strToP).get(pattToStr - 2);

                    if (isMatches || ((s.charAt(stringIdx) == p.charAt(pattenIdx - 1)) || p.charAt(pattenIdx - 1) == '.')) {
                        isMatches = resultList.get(strToP - 1).get(pattToStr);
                    }

                } else {

                    isMatches = false;
                }

                resultList.get(strToP).add(pattToStr, isMatches);

                pattToStr = (pattToStr + 1) > p.length() ? pattToStr : ++pattToStr;

            }

        }

        return resultList.get(strToP).get(pattToStr);
    }
}
