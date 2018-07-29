package leetCode;

import org.junit.Test;

/**
 * Created by oiffice on 2018/7/19.
 */
public class NContainerWithMostWaterTest {

    @Test
    public void testing() {
        int a[] = {1, 5, 4, 3};
        int b[] = {3, 1, 2, 4, 5};

        System.out.println(maxArea(a));
        System.out.println(maxArea(b));
    }

    public int maxArea(int[] height) {

        int left = 0;
        int right = height.length - 1;
        int area = 0;

        while (left < right && left < height.length) {

            area = Math.max(area, Math.min(height[left], height[right]) * (right - left));

            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }

        }

        return area;
    }
}
