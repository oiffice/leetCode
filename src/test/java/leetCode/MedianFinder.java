package leetCode;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class MedianFinder {
    Queue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b-a);
    Queue<Integer> minHeap = new PriorityQueue<>();
    int size = 0;

    public MedianFinder() {

    }

    public void addNum(int num) {
        size++;
        if(maxHeap.isEmpty() || num<= maxHeap.peek()){
            maxHeap.add(num);
        }else{
            minHeap.add(num);
        }

        if(minHeap.size() +1 < maxHeap.size()){
            Integer element = maxHeap.poll();
            minHeap.add(element);
        }else if ( maxHeap.size() < minHeap.size()){
            Integer element = minHeap.poll();
            maxHeap.add(element);
        }
    }

    public double findMedian() {

        if ( size % 2 !=0) return (double) maxHeap.peek();

        return (maxHeap.peek() + minHeap.peek()) / 2.0;
    }
}
