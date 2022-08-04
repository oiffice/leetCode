package leetCode;

import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

public class TrendMicro3 {
    @Test
    public void test1() {
        System.out.println(solution(2, "1A 2F 1C"));
    }
    @Test
    public void test2() {
        System.out.println(solution(1, ""));
    }
    @Test
    public void test3() {
        System.out.println(solution(3, "3B 2D 1H 3F 3K 2K 1B"));
    }
    @Test
    public void test4() {
        System.out.println(solution(3, "1D 1F 2A 2C 2K 3A 3C 4C 4H"));
    }
    @Test
    public void test5() {
        System.out.println(solution(3, "1C 1J 2D 2K 3B 3F 3K"));
    }
    public int solution(int N, String S) {
        if (S.length() == 0) {
            return N * 2;
        }
        String[] ary = S.split(" ");
        Arrays.sort(ary);
        Map<String, List<String>> map = new HashMap<>();

        for(String s: ary) {
            String key = String.valueOf(s.charAt(0));
            List<String> list;
            if (map.containsKey(key)) {
                list = map.get(key);
            } else {
                list = new ArrayList<>();
            }
            list.add(String.valueOf(s.charAt(1)));
            map.put(key, list);
        }

        int count = 0;

        for (Map.Entry<String, List<String>> entry : map.entrySet()) {
            List<String> l = entry.getValue().stream().sorted().collect(Collectors.toList());
            // left
            if (!l.contains("B") && !l.contains("C") && !l.contains("D") && !l.contains("E")) {
                count++;
            } else if (!l.contains("F") && !l.contains("G") && !l.contains("H") && !l.contains("J")) {
                count++;
            } else if (!l.contains("D") && !l.contains("E") && !l.contains("F") && !l.contains("G")) {
                count++;
            }
        }

        return count;
    }
}
