package leetCode;

import org.junit.Test;

public class LeetCode059 {
    public int[][] generateMatrix(int n) {

        if (n == 0) {
            return null;
        }

        int[][] columns = new int[n][n];
        int[] rows = new int[n];
        columns[0] = rows;
        int top = 0;
        int left;
        int right = n - 1;
        int lastValue = 0;
        int times = 0;

        while (n - times > 0) {

            // up
            for (left = times; left < n - times; left++) {
                int[] temp = columns[top];
                temp[left] = ++lastValue;
                columns[top] = temp;
            }

            top++;
            right = left - 1;

            // right
            for (; top < n - times; top++) {
                int[] temp = columns[top];
                temp[left - 1] = ++lastValue;
                columns[top] = temp;
            }

            // bottom
            for (right -= 1; right > times - 1; right--) {
                int[] temp = columns[top - 1];
                temp[right] = ++lastValue;
                columns[top - 1] = temp;
            }

            // left
            for (top -= 1; top > times + 1; top--) {
                int[] temp = columns[top - 1];
                temp[right + 1] = ++lastValue;
                columns[top - 1] = temp;
            }

            times++;
        }

        return columns;
    }

    @Test
    public void test1() {

        int n = 1;
        int[][] result = generateMatrix(n);

        for (int[] r: result) {
            for (int i: r) {
                System.out.print(i + " ");
            }

            System.out.println("");
        }
    }
}
