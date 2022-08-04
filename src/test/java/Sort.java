import org.junit.Test;

import java.util.Arrays;

public class Sort {

    @Test
    public void test1() {
        int[] ints = new int[]{6,4,89,3,1,10,9,2,6,4,32};
        quickSort(ints, 0, ints.length);
        for (int anInt : ints) {
            System.out.println(anInt);
        }
    }

    @Test
    public void test2() {
        int[] ints = new int[]{6};
        quickSort(ints, 0, ints.length);
        for (int anInt : ints) {
            System.out.println(anInt);
        }
    }

    public void quickSort(int[] nums, int left, int right) {

        if (right <= left) {
            return;
        }

        int pivot = nums[right - 1];
        int l = left;
        int r = right - 1;

        while (l < r) {
            while (nums[l] <= pivot && r > l) {
                l++;
            }
            while (nums[r] >= pivot && r > l) {
                r--;
            }

            int temp = nums[l];
            if (l < r) {
                nums[l] = nums[r];
                nums[r] = temp;
            } else {
                nums[l] = pivot;
                nums[right - 1] = temp;
            }
        }

        quickSort(nums, left, r);
        quickSort(nums, r + 1, right);


    }

    public void bubbleSort(int[] nums) {
        boolean swapCount;

        do {
            swapCount = false;
            for (int i = 1; i < nums.length; i++) {
                if (nums[i] < nums[i - 1]) {
                    int temp = nums[i];
                    nums[i] = nums[i - 1];
                    nums[i - 1] = temp;
                    swapCount = true;
                }
            }
        } while (swapCount);

    }

    public void mergeSort(int[] nums) {

        if (nums.length == 1) {
            return;
        }

        int mid = nums.length / 2;
        int[] left = Arrays.copyOfRange(nums, 0, mid);
        int[] right = Arrays.copyOfRange(nums, mid, nums.length);

        mergeSort(left);
        mergeSort(right);

        int l = 0;
        int r = 0;
        int i = 0;

        while (l < left.length && r < right.length) {
            if (left[l] > right[r]) {
                nums[i++] = right[r++];
            } else {
                nums[i++] = left[l++];
            }
        }

        while (l < left.length) {
            nums[i++] = left[l++];
        }

        while (r < right.length) {
            nums[i++] = right[r++];
        }

    }
}
