package leetCode;

import org.junit.Test;

public class LeetCode295 {

    @Test
    public void test1() {
        MedianFinder medianFinder = new MedianFinder();
        medianFinder.addNum(1);
        medianFinder.addNum(2);
        System.out.println(medianFinder.findMedian());
        medianFinder.addNum(3);
        System.out.println(medianFinder.findMedian());
    }

    @Test
    public void test2() {
        MedianFinder medianFinder = new MedianFinder();
        medianFinder.addNum(1);
        medianFinder.addNum(3);
        medianFinder.addNum(5);
        System.out.println(medianFinder.findMedian());
        medianFinder.addNum(4);
        System.out.println(medianFinder.findMedian());
        medianFinder.addNum(2);
        System.out.println(medianFinder.findMedian());
    }

    @Test
    public void test3() {
        MedianFinder medianFinder = new MedianFinder();
        medianFinder.addNum(12); System.out.println(12);
        System.out.println(medianFinder.findMedian());
        medianFinder.addNum(10); System.out.println(10);
        System.out.println(medianFinder.findMedian());
        medianFinder.addNum(13); System.out.println(13);
        System.out.println(medianFinder.findMedian());
        medianFinder.addNum(11);
        System.out.println(medianFinder.findMedian());
        medianFinder.addNum(5);
        System.out.println(medianFinder.findMedian());
        medianFinder.addNum(15);
        System.out.println(medianFinder.findMedian());
        medianFinder.addNum(1);
        System.out.println(medianFinder.findMedian());
        medianFinder.addNum(11);
        System.out.println(medianFinder.findMedian());
        medianFinder.addNum(6);
        System.out.println(medianFinder.findMedian());
        medianFinder.addNum(17);
        System.out.println(medianFinder.findMedian());
        medianFinder.addNum(14);
        System.out.println(medianFinder.findMedian());
        medianFinder.addNum(8);
        System.out.println(medianFinder.findMedian());
        medianFinder.addNum(17);
        System.out.println(medianFinder.findMedian());
        medianFinder.addNum(6);
        System.out.println(medianFinder.findMedian());
        medianFinder.addNum(4);
        System.out.println(medianFinder.findMedian());
        medianFinder.addNum(16);
        System.out.println(medianFinder.findMedian());
        medianFinder.addNum(8);
        System.out.println(medianFinder.findMedian());
        medianFinder.addNum(10);
        System.out.println(medianFinder.findMedian());
        medianFinder.addNum(2);
        System.out.println(medianFinder.findMedian());
        medianFinder.addNum(12);
        System.out.println(medianFinder.findMedian());
        medianFinder.addNum(0);
        System.out.println(medianFinder.findMedian());
    }

}
