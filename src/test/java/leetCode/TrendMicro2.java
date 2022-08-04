package leetCode;

import org.junit.Test;

import java.util.Collections;
import java.util.PriorityQueue;

public class TrendMicro2 {
    @Test
    public void test1() {
        System.out.println(solution("...xxx..x....xxx.", 7));
    }
    @Test
    public void test2() {
        System.out.println(solution(".XXXXX", 4));
    }
    @Test
    public void test3() {
        System.out.println(solution("......", 4));
    }
    @Test
    public void test4() {
        System.out.println(solution("..XX..XX.XX", 100));
    }
    public int solution(String S, int B) {
        PriorityQueue<Integer> q = new PriorityQueue<>(Collections.reverseOrder());
        int count = 0;

        for (int i = 0; i < S.length(); i++) {
            if (S.charAt(i) == 'X') {
                count++;
            } else if (count != 0){
                q.add(count);
                count = 0;
            }
        }
        if (count != 0) {
            q.add(count);
        }

        int number = 0;
        while (!q.isEmpty()) {
            int n = q.poll();
            B -= (n+1);

            if (B >=0) {
                number += n;
            } else {
                number += n + B;
                return number;
            }
        }

        return number;
    }
}
