package leetCode;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class LeetCode695 {
    @Test
    public void test1() {
        int[] one = new int[]{0,0,1,0,0,0,0,1,0,0,0,0,0};
        int[] two = new int[]{0,0,0,0,0,0,0,1,1,1,0,0,0};
        int[] three = new int[]{0,1,1,0,1,0,0,0,0,0,0,0,0};
        int[] four = new int[]{0,1,0,0,1,1,0,0,1,0,1,0,0};
        int[] five = new int[]{0,1,0,0,1,1,0,0,1,1,1,0,0};
        int[] six = new int[]{0,0,0,0,0,0,0,0,0,0,1,0,0};
        int[] seven = new int[]{0,0,0,0,0,0,0,1,1,1,0,0,0};
        int[] eight = new int[]{0,0,0,0,0,0,0,1,1,0,0,0,0};
        int[][] grid = new int[][]{one, two, three, four, five, six, seven, eight};
        assertEquals(6, maxAreaOfIsland(grid));

    }

    @Test
    public void test2() {

        int[] one = new int[]{1,1,0,0,0};
        int[] two = new int[]{1,1,0,0,0};
        int[] three = new int[]{0,0,0,1,1};
        int[] four = new int[]{0,0,0,1,1};
        int[][] grid = new int[][]{one, two, three, four};
        assertEquals(4, maxAreaOfIsland(grid));
    }

    @Test
    public void test3() {
        int[][] grid = new int[][]{new int[]{1}};
        assertEquals(1, maxAreaOfIsland(grid));
    }

    @Test
    public void test4() {
        int[][] grid = new int[][]{};
        assertEquals(0, maxAreaOfIsland(grid));
    }
    public int maxAreaOfIsland(int[][] grid) {
        int result = 0;

        for(int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                int count = 0;
                if (grid[i][j] == 1) {
                    count += dfs(grid, i, j);
                    result = Math.max(count, result);
                    grid[i][j] = -1;
                }
            }
        }
        return result;
    }

    private int dfs(int[][] grid, int i, int j) {
        int count = 0;

        if (i < 0 || i > grid.length - 1 || j < 0 || j > grid[i].length - 1) {
            return count;
        }

        if (grid[i][j] == 1) {
            grid[i][j] = -1;
            count++;
            count += dfs(grid, i - 1, j);
            count += dfs(grid, i + 1, j);
            count += dfs(grid, i, j - 1);
            count += dfs(grid, i, j + 1);
        }
        return count;
    }
}
