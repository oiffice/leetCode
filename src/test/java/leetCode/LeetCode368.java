package leetCode;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class LeetCode368 {
    @Test
    public void test1() {
        System.out.println(kthSmallest(new int[][]{
                new int[]{1, 5, 9},
                new int[]{10, 11, 13},
                new int[]{10, 12, 15}
        }, 8));
    }

    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        int l = matrix[0][0];
        int u = matrix[n - 1][n - 1];
        Map<Integer, Integer> map = new HashMap<>();


        while (l < u) {
            int mid = (l + u) / 2;
            int count = 0;
            for(int[] ary: matrix) {
                int i;
                for(i = 0; i < ary.length; i++) {
                    if (ary[i] > mid) break;
                }
                count += i;
                if (i == 0 || count >= k) {
                    break;
                }
            }

            if (count >= k) {
                u = mid;
            } else {
                l = mid + 1;
            }
        }

        return l;
    }
}
