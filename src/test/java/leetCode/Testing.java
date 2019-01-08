package leetCode;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by oiffice on 2018/11/28.
 */
public class Testing {

    @Test
    public void test1() {
        int[] ranks = new int[]{0,1,3,3,4,4};
        Assert.assertEquals(3, this.solution1(ranks));

        int[] ranks2 = new int[]{4,2,0};
        Assert.assertEquals(0, this.solution1(ranks2));

        int[] ranks3 = new int[]{3,4,3,0,2,2,3,0,0};
        Assert.assertEquals(5, this.solution1(ranks3));

    }

    @Test
    public void test2() {

        System.out.println(this.solution2(5, 3));
        System.out.println(this.solution2(3, 3));
        System.out.println(this.solution2(1, 4));
    }

    @Test
    public void test3_1() {
        int[] date1 = new int[]{1,2,4,5,7,29,30};
        Assert.assertEquals(11, this.solution3(date1));
    }

    @Test
    public void test3_2() {

        int[] date2 = new int[]{1,2,3,4,5,7,8,13,14,15,16,17,18,19,20,21};
        Assert.assertEquals(20, this.solution3(date2));

    }

    @Test
    public void test3_3() {

        int[] date3 = new int[]{1,3,9,13,21,30,31};
        Assert.assertEquals(14, this.solution3(date3));
    }

    @Test
    public void test3_4() {

        int[] date4 = new int[]{1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31};
        Assert.assertEquals(27, this.solution3(date4));
    }

    // solution 1
    public int solution1(int[] ranks) {
        // write your code in Java SE 8

        Arrays.sort(ranks);
        int count = 0;

        for (int i = 0; i < ranks.length; i++) {

            if (bs(ranks, ranks.length/2, ranks[i] + 1) > -1) {
                count++;
            }
        }

        return count;
    }

    private int bs(int[] arr, int middle, int target) {

        if ( arr[middle] == target) {
            return middle;
        } else if (middle == 0  && arr[middle] != target || (middle+1) == arr.length) {
            return -1;
        }

        if (arr[middle] < target) {

            arr = Arrays.copyOfRange(arr, middle+1, arr.length);


        } else {
            arr = Arrays.copyOfRange(arr, 0, middle);
        }


        return bs(arr, arr.length / 2, target);

    }

    // solution 2
    public String solution2(int A, int B) {

        if (Math.abs(A - B) > 3) {
            return "";
        }

        List<String> mainList = new ArrayList<>();
        List<String> secondList = new ArrayList<>();

        if (A > B) {

            for (int i = 0; i < A; i++) {
                mainList.add("a");
            }
            for (int i = 0; i < B; i++) {
                secondList.add("b");
            }

        } else {

            for (int i = 0; i < B; i++) {
                mainList.add("b");
            }
            for (int i = 0; i < A; i++) {
                secondList.add("a");
            }

        }

        String result = "";

        for (int i = 0, j = 0; i < (A+B); i++) {

            if (i % 2 == 0 && i < mainList.size()) {

                result += mainList.get(i);

                if (i+1 < mainList.size()) {
                    result += mainList.get(i+1);
                    i++;
                }
            }

            if (j < secondList.size()) {
                result += secondList.get(j);
                j++;
            }

        }

        return result;
    }

    // solution 3
    public int solution3(int[] A) {
        // write your code in Java SE 8

        int startDate = A[0];
        int sevenBounceDate = startDate + 6;
        int thirtyBounceDate = startDate + 29;
        int total = 0;
        int twoTotal = 0;
        int sevenTotal = 7;
        int thirtyTotal = 25;

        for (int i = 0; i < A.length; i++) {

            total += 2;

            if (A[i] == sevenBounceDate) {

                if (total > sevenTotal) {
                    total = sevenTotal;
                } else if (total < sevenTotal) {
                    sevenTotal = total;
                }


            } else if (A[i] > sevenBounceDate) {
                sevenTotal += 7;
                sevenBounceDate += 7;
            }

            if (A[i] == thirtyBounceDate) {

                if (total > thirtyTotal) {
                    total = thirtyTotal;
                } else if (total < thirtyTotal) {
                    thirtyTotal = total;
                }


            } else if (A[i] > thirtyBounceDate) {
                thirtyTotal += 29;
                thirtyBounceDate += 29;
            }

        }

        total += twoTotal;

        return  total;

    }
}
