package leetCode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;
import java.util.stream.Collectors;

public class Testing31 {

    @Test
    public void tetsting() {

        List<Integer> time = new ArrayList<>();
        time.add(0);
        time.add(0);
        time.add(1);
        time.add(5);

        List<Integer> direction = new ArrayList<>();
        direction.add(0);
        direction.add(1);
        direction.add(1);
        direction.add(0);

        System.out.println(getTimes(time, direction));

    }

    @Test
    public void tetsting2() {

        List<Integer> time = new ArrayList<>();
        time.add(0);
        time.add(1);
        time.add(1);
        time.add(3);
        time.add(3);

        List<Integer> direction = new ArrayList<>();
        direction.add(0);
        direction.add(1);
        direction.add(0);
        direction.add(0);
        direction.add(1);

        System.out.println(getTimes(time, direction));

    }


    public static List<Integer> getTimes(List<Integer> time, List<Integer> direction) {
        // Write your code here

        if (time.size() != direction.size()) {
            return null;
        }

        time = time.stream().sorted().collect(Collectors.toList());

        int[] timeArray = time.stream().mapToInt(Integer::intValue).toArray();
        int[] directionArray = direction.stream().mapToInt(Integer::intValue).toArray();

        // <second, index>
        Map<Integer, Integer> exitSecondMapIndex = new HashMap<>();
        Map<Integer, Integer> entrySecondMapIndex = new HashMap<>();

        for (int i = 0; i < directionArray.length; i++) {

            if (directionArray[i] == 1) {
                exitSecondMapIndex.put(timeArray[i], i);
            } else if (directionArray[i] == 0) {
                entrySecondMapIndex.put(timeArray[i], i);
            }
        }

        int[] result = new int[direction.size()];
        int lastDirection = -1;

        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < timeArray.length; i++) {

            int eventTime = timeArray[i];

            if (i == 0) {
                if (exitSecondMapIndex.containsKey(eventTime)) {
                    stack.push(exitSecondMapIndex.get(eventTime));
                    lastDirection = 1;

                    if (entrySecondMapIndex.containsKey(eventTime)) {
                        stack.push(entrySecondMapIndex.get(eventTime));
                    }
                } else if (entrySecondMapIndex.containsKey(eventTime)) {
                    stack.push(entrySecondMapIndex.get(eventTime));
                    lastDirection = 0;
                }

            } else if (eventTime != timeArray[i - 1]) {

                if (lastDirection == 1 ) {
                    int peekIndex = stack.peek();

                    if (eventTime - 1 == timeArray[i-1] && entrySecondMapIndex.containsKey(peekIndex)) {

                        peekIndex = stack.pop();
                        stack.push(exitSecondMapIndex.get(eventTime));
                        stack.push(peekIndex);

                    } else if (exitSecondMapIndex.containsKey(eventTime)){
                        stack.push(exitSecondMapIndex.get(eventTime));
                    }

                    if (entrySecondMapIndex.containsKey(eventTime)) {
                        stack.push(entrySecondMapIndex.get(eventTime));
                        lastDirection = 0;
                    }

                } else if (lastDirection == 0) {

                    if (entrySecondMapIndex.containsKey(eventTime)) {
                        stack.push(entrySecondMapIndex.get(eventTime));
                        lastDirection = 0;

                        if (exitSecondMapIndex.containsKey(eventTime)) {
                            stack.push(exitSecondMapIndex.get(eventTime));
                            lastDirection = 1;
                        }
                    } else if (exitSecondMapIndex.containsKey(eventTime)) {

                        stack.push(exitSecondMapIndex.get(eventTime));
                        lastDirection = 1;
                    }
                }

            }

        }

        Stack<Integer> newStack = new Stack<>();

        while (!stack.isEmpty()) {
            newStack.push(stack.pop());
        }

        int lastSecond = -1;

        while (!newStack.isEmpty()){

            int index = newStack.pop();
            int second = timeArray[index];

            result[index] = second;

            if (second <= lastSecond) {
                result[index] = lastSecond + 1;
            }

            lastSecond = second;

        }

        List<Integer> resultList = new ArrayList<>();


        for (int i = 0; i < result.length; i++) {
            resultList.add(result[i]);
        }

        return resultList;
    }

}
