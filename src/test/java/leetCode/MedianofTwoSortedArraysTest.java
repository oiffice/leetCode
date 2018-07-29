package leetCode;

import org.junit.Test;

/**
 * Created by oiffice on 2018/7/16.
 */
public class MedianofTwoSortedArraysTest {

    @Test
    public void test() {

        int[] ary1 = new int[]{1,3,5};
        int[] ary2 = new int[]{2,4};

        System.out.println(findMedianSortedArrays(ary1, ary2));
    }



    public double findMedianSortedArrays(int[] nums1, int[] nums2) {


        int[] result = sort(nums1, nums2);
        int middle = result.length / 2;

        if (result.length % 2 == 0) {


            double f = (Double.valueOf(result[middle-1]) + result[middle]) / 2;

            return f;

        } else {


            return Double.valueOf(result[middle]);
        }

    }

    public int[] sort(int[] ary1, int[] ary2) {

        int i = 0;
        int j = 0;
        int k = 0;
        int[] result = new int[ary1.length + ary2.length];

        while (i < ary1.length && j < ary2.length) {

            if (ary1[i] < ary2[j]) {

                result[k++] = ary1[i];
                i++;
            } else {
                result[k++] = ary2[j];
                j++;
            }


        }

        while (i < ary1.length) {
            result[k++] = ary1[i++];
        }

        while (j < ary2.length) {
            result[k++] = ary2[j++];
        }


        return result;
    }
}
