package leetCode;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by oiffice on 2018/11/13.
 */
public class LeetCode017 {


    @Before
    public void init() {

    }

    @Test
    public void test1(){

        List<String> results = new ArrayList<>();
        results.add("ad");
        results.add("ae");
        results.add("af");
        results.add("bd");
        results.add("be");
        results.add("bf");
        results.add("cd");
        results.add("ce");
        results.add("cf");

        List<String> returnValue = this.letterCombinations("23");

        returnValue.forEach(value -> {

            Assert.assertTrue(results.contains(value));

        });
    }

    @Test
    public void test2(){

        List<String> results = new ArrayList<>();
        results.add("adw");
        results.add("aew");
        results.add("afw");
        results.add("adx");
        results.add("aex");
        results.add("afx");
        results.add("ady");
        results.add("aey");
        results.add("afy");
        results.add("adz");
        results.add("aez");
        results.add("afz");
        results.add("bdw");
        results.add("bew");
        results.add("bfw");
        results.add("bdx");
        results.add("bex");
        results.add("bfx");
        results.add("bdy");
        results.add("bey");
        results.add("bfy");
        results.add("bdz");
        results.add("bez");
        results.add("bfz");
        results.add("cdw");
        results.add("cew");
        results.add("cfw");
        results.add("cdx");
        results.add("cex");
        results.add("cfx");
        results.add("cdy");
        results.add("cey");
        results.add("cfy");
        results.add("cdz");
        results.add("cez");
        results.add("cfz");

        List<String> returnValue = this.letterCombinations("239");

        returnValue.forEach(value -> {

            Assert.assertTrue(results.contains(value));

        });
    }


    public List<String> letterCombinations(String digits) {

        Map<Character, List<String>> numberMapChar = new HashMap<>();
        numberMapChar.put('2', Arrays.asList("a", "b", "c"));
        numberMapChar.put('3', Arrays.asList("d", "e", "f"));
        numberMapChar.put('4', Arrays.asList("g", "h", "i"));
        numberMapChar.put('5', Arrays.asList("j", "k", "l"));
        numberMapChar.put('6', Arrays.asList("m", "n", "o"));
        numberMapChar.put('7', Arrays.asList("p", "q", "r", "s"));
        numberMapChar.put('8', Arrays.asList("t", "u", "v"));
        numberMapChar.put('9', Arrays.asList("w", "x", "y", "z"));

        if (digits.isEmpty()) {
            return Collections.EMPTY_LIST;
        }

        if (digits.length() == 1) {
            return numberMapChar.get(digits.charAt(0));
        }

        return traverse(digits, numberMapChar);

    }

    private List<String> traverse(String digits, Map<Character, List<String>> numberMapChar) {

        char c = digits.charAt(digits.length() - 1);
        List<String> firstString = numberMapChar.get(c);

        digits = digits.substring(0, digits.length() - 1);

        List<String> secondString = this.letterCombinations(digits);
        List<String> result = new ArrayList<>();

        for (int i = 0; i < firstString.size(); i++) {
            for (int j = 0; j < secondString.size(); j++) {
                result.add(new StringBuilder().append(secondString.get(j)).append(firstString.get(i)).toString());
            }
        }

        return result;
    }
}
