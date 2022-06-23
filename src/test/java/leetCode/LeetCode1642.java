package leetCode;

import org.junit.Test;

import java.util.Collections;
import java.util.PriorityQueue;

import static junit.framework.TestCase.assertEquals;

public class LeetCode1642 {
    @Test
    public void test1() {
        assertEquals(4, furthestBuilding(new int[]{4, 2, 7, 6, 9, 14, 12}, 5, 1));
    }
    @Test
    public void test2() {
        assertEquals(7, furthestBuilding(new int[]{4,12,2,7,3,18,20,3,19}, 10, 2));
    }
    @Test
    public void test3() {
        assertEquals(3, furthestBuilding(new int[]{14,3,19,3}, 17, 0));
    }
    @Test
    public void test4() {
        assertEquals(5, furthestBuilding(new int[]{1,5,1,2,3,4,10000}, 4, 1));
    }
    @Test
    public void test5() {
        assertEquals(7, furthestBuilding(new int[]{1,6,1,5,1,2,3,4}, 9, 1));
    }
    public int furthestBuilding(int[] heights, int bricks, int ladders) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());

        for(int i = 1; i < heights.length; i++) {
            if (heights[i] > heights[i - 1]) {
                int gap = Math.subtractExact(heights[i], heights[i-1]);
                bricks -= gap;
                queue.offer(gap);

                if (bricks < 0) {
                    bricks += queue.poll();
                    if (ladders > 0) ladders--;
                    else return i - 1;
                }
            }
        }

        return heights.length - 1;
//        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
//
//        for (int i=0; i<heights.length-1; i++) {
//            if (heights[i] >= heights[i+1]) continue;
//            bricks -= heights[i+1] - heights[i];
//            pq.add(heights[i+1] - heights[i]);
//
//            if (bricks < 0) {
//                bricks += pq.poll();
//                if (ladders > 0) ladders--;
//                else return i;
//            }
//        }
//
//        return heights.length - 1;
    }
}
