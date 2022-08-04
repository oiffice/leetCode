package leetCode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
class CalendarNode {
    int s;
    int e;
    CalendarNode left;
    CalendarNode right;

    CalendarNode() {}

    CalendarNode(int s, int e) {
        this.s = s;
        this.e = e;
    }
}
class MyCalendar {

    CalendarNode root;

    public MyCalendar() {}

    public boolean book(int start, int end) {
        if (root == null) {
            root = new CalendarNode(start, end);
            return true;
        }
        return bst(start, end, root);
    }

    private boolean bst(int start, int end, CalendarNode node) {

        if (node.s >= end) {
            if (node.left == null) {
                node.left = new CalendarNode(start, end);
            } else {
                return bst(start, end, node.left);
            }
            return true;
        } else if (node.e <= start) {
            if (node.right == null) {
                node.right = new CalendarNode(start, end);
            } else {
                return bst(start, end, node.right);
            }
            return true;
        }
        return false;
    }
}

public class LeetCode729 {
    @Test
    public void test1() {
        List<Map<Integer, Integer>> l = new ArrayList<>();

        l.add(new HashMap<>(){{ put(47,50); }} );
        l.add(new HashMap<>(){{ put(33,41); }} );
        l.add(new HashMap<>(){{ put(39,45); }} );
        l.add(new HashMap<>(){{ put(33,42); }} );
        l.add(new HashMap<>(){{ put(25,32); }} );
        l.add(new HashMap<>(){{ put(26,35); }} );
        l.add(new HashMap<>(){{ put(19,25); }} );
        l.add(new HashMap<>(){{ put(3,8); }} );
        l.add(new HashMap<>(){{ put(8,13); }} );
        l.add(new HashMap<>(){{ put(18,27); }} );
        test(l);
    }

    @Test
    public void test2() {
        List<Map<Integer, Integer>> l = new ArrayList<>();

        l.add(new HashMap<>(){{ put(37,50); }} );
        l.add(new HashMap<>(){{ put(33,50); }} );
        l.add(new HashMap<>(){{ put(4,17); }} );
        l.add(new HashMap<>(){{ put(35,48); }} );
        l.add(new HashMap<>(){{ put(8,25); }} );
        test(l);
    }

    public void test(List<Map<Integer, Integer>> lists) {

        MyCalendar myCalendar = new MyCalendar();
        List<Boolean> result = new ArrayList<>();


        lists.forEach(l -> {
            l.forEach((key, value) -> result.add(myCalendar.book(key, value)));
        });

        result.forEach(System.out::println);
    }

}
