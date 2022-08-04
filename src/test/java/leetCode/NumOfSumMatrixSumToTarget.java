package leetCode;

import org.junit.Test;

public class NumOfSumMatrixSumToTarget {

    @Test
    public void test1() {
        int[][] matrix = new int[][] {
                new int[] {0, 1, 0},
                new int[] {1, 1, 1},
                new int[] {0, 1, 0},
        };

        System.out.println(numSubmatrixSumTarget(matrix, 0));
    }

    public int numSubmatrixSumTarget(int[][] matrix, int target) {
        return bfs(matrix, 0, 0, target, 0, 0);

    }

    public int bfs(int[][] matrix, int i, int j, int target, int tmpTarget, int count) {
        if (i < 0 || i == matrix.length || j < 0 || j == matrix[i].length) {
            return count;
        }
        int sum = matrix[i][j] + tmpTarget;
        if(sum == target) {
            count++;
        }

        count = bfs(matrix, i - 1, j, target, sum, count);
        count = bfs(matrix, i + 1, j, target, sum, count);
        count = bfs(matrix, i, j - 1, target, sum, count);
        count = bfs(matrix, i, j + 1, target, sum, count);
        return count;
    }
}
