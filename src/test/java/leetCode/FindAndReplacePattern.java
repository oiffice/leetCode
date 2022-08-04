package leetCode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindAndReplacePattern {
    @Test
    public void test1() {
        String[] strings = new String[]{"abc", "def", "qqq", "qoo", "coo", "coc"};
        for (String s: findAndReplacePattern(strings, "abb")) {
            System.out.println(s);
        }
    }
    @Test
    public void test2() {
        String[] strings = new String[]{"a", "d", "q", "o", "c"};
        for (String s: findAndReplacePattern(strings, "h")) {
            System.out.println(s);
        }
    }
    @Test
    public void test3() {
        String[] strings = new String[]{"abc","cba","xyx","yxx","yyx"};
        for (String s: findAndReplacePattern(strings, "abc")) {
            System.out.println(s);
        }
    }

    public List<String> findAndReplacePattern(String[] words, String pattern) {
        List<String> result = new ArrayList<>();
        for (String word: words) {
            if (match(pattern, word)) {
                result.add(word);
            }
        }
        return result;
    }

    public boolean match(String pattern, String word) {
        Map<Character, Character> m1 = new HashMap();
        Map<Character, Character> m2 = new HashMap();

        for (int i = 0; i < word.length(); ++i) {
            char w = word.charAt(i);
            char p = pattern.charAt(i);

            if (!m1.containsKey(w)) {
                m1.put(w, p);
            }
            if (!m2.containsKey(p)) {
                m2.put(p, w);
            }

            if (m1.get(w) != p || m2.get(p) != w) {
                return false;
            }
        }
        return true;
    }
}
