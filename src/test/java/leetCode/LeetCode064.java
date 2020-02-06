package leetCode;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LeetCode064 {

    public int minPathSum(int[][] grid) {

        if (grid == null || grid.length < 1 || grid[0].length < 1) {
            return 0;
        }

        int[][] result = new int[grid.length][grid[0].length];
        result[0][0] = 0;

        for (int i = 1; i < grid[0].length; i++) {
            result[0][i] = result[0][i - 1] + grid[0][i];
        }

        for (int j = 1; j < grid.length; j++) {
            result[j][0] = result[j - 1][0] + grid[j][0];
        }

        for (int i = 1; i < grid.length; i++) {
            for (int j = 1; j < grid[0].length; j++) {
                result[i][j] = Math.min(result[i - 1][j], result[i][j - 1]) + grid[i][j];
            }
        }

        return grid[0][0] + result[grid.length - 1][grid[0].length - 1];
    }


    @Test
    public void test1() {

        int[] t1 = new int[]{1, 3, 1};
        int[] t2 = new int[]{1, 5, 1};
        int[] t3 = new int[]{4, 2, 1};

        int[][] grid = new int[][]{t1, t2, t3};

        assertEquals(7, minPathSum(grid));
    }


    @Test
    public void test2() {

        int[] t1 = new int[]{1, 3, 1, 2};
        int[] t2 = new int[]{1, 5, 1, 1};
        int[] t3 = new int[]{4, 2, 2, 3};

        int[][] grid = new int[][]{t1, t2, t3};

        assertEquals(10, minPathSum(grid));
    }
}
