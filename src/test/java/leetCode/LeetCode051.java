package leetCode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class LeetCode051 {

    private void print(List<int[]> integers) {

        List<List<String>> booleanMetric = new ArrayList<>();
        for (int i = 0; i < integers.size(); i++) {
            StringBuilder stringBuilder = new StringBuilder();
            List<String> a = new ArrayList<>();
            int[] temp = integers.get(i);

            for (int j = 0; j < temp.length; j++) {

                if (i == temp[0] && j == temp[1]) {
                    stringBuilder.append("Q");
                } else {
                    stringBuilder.append(".");
                }
            }


            a.add(stringBuilder.toString());
            booleanMetric.add(a);
        }

        System.out.println(booleanMetric);
    }

    public List<List<String>> solveNQueens(int n) {

        int rows = n;
        int originalStartY = 0;
        int startY = 0;
        int errorCount = 0;
        List<int[]> integers;

        for (; originalStartY < rows; originalStartY++) {

            startY = ++originalStartY;
            integers = new LinkedList<>();

            for (int i = 0; i < rows; i++) {

                if (startY >= rows) {
                    startY = startY % rows;
                }
                integers.add(i, new int[]{i, startY});

                if (i != 0) {

                    boolean condition1 = false;
                    boolean condition2 = false;
                    boolean condition3 = false;
                    boolean condition4 = false;

                    for (int j = 0; j < integers.size() - 1; j++) {

                        int gap = integers.size() - 1 - j;

                        condition1 = (i == integers.get(j)[0]);
                        condition2 = (startY == integers.get(j)[1]);
                        condition3 = (i == (integers.get(j)[0] + gap) && startY == (integers.get(j)[1] + gap));
                        condition4 = (i == (integers.get(j)[0] + gap) && startY == (integers.get(j)[1] - gap));

                        if (condition1 || condition2 || condition3 || condition4) {

                            integers.remove(i);

                            if (errorCount == rows) {
                                startY = ++originalStartY;
                                integers = new LinkedList<>();
                                i = -1;
                            } else {
                                i -= 1;
                                startY++;
                                errorCount++;
                            }
                            break;
                        }
                    }

                    if ( (startY + 1 != rows) && !(condition1 || condition2 || condition3 || condition4)) {
                        startY += 2;
                        errorCount = 0;
                    }

                } else {
                    startY += 2;
                    errorCount = 0;
                }
            }

            print(integers);
        }

        List<List<String>> booleanMetric = null;


        return booleanMetric;
    }
}
