package leetCode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class TrendMicro {
    @Test
    public void test1() {
        System.out.println(solution(new int[]{4, 2, 5, 8, 7, 3, 7}));
    }
    @Test
    public void test2() {
        System.out.println(solution(new int[]{14,21,16,35,22}));
    }
    @Test
    public void test3() {
        System.out.println(solution(new int[]{5,5,5,5,5,5}));
    }

    public int solution(int[] A) {
        int count = 0;
        List<Integer> list = new ArrayList<>();
        int i = 1;
        for(; i < A.length; i++) {
            if ((A[i - 1] + A[i]) % 2 == 0 && (!list.contains(i) && !list.contains(i-1))) {
                count++;
                list.add(i-1);
                list.add(i);
                i++;
            }
        }

        if ((A[A.length - 1] + A[0])%2 == 0 && (!list.contains(A.length - 1) && !list.contains(0))) {
            count++;
        }

        return count;
    }
}
