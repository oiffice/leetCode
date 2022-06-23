package leetCode;

import org.junit.Test;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class LeetCode187 {
    @Test
    public void test1() {
        String s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT";
        System.out.println(findRepeatedDnaSequences(s));
    }
    public List<String> findRepeatedDnaSequences(String s) {
        //find 10 letter sub string, add to set
        //if adding fails, add that sub to list
        //sub(n, n + 10), if (n + 10 <= s.length())

        List<String> res = new LinkedList<>();
        HashSet<String> st = new HashSet<String>();
        HashSet<String> res2 = new HashSet<String>();

        for(int i = 0; i < s.length(); i++) {
            if(i + 10 <= s.length()) {
                String sub = s.substring(i, i + 10);
                if(!st.add(sub)) {
                    res2.add(sub);
                }
            } else break;
        }
        res = new LinkedList<>(res2);
        return res;
    }
}
