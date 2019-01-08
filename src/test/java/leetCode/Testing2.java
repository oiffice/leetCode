package leetCode;

import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by oiffice on 2018/11/30.
 */
public class Testing2 {

    @Test
    public void test1() {
        int[] test = new int[]{7,4,80,91,13,27,35,23};
        System.out.println(this.solution1(test));

        System.out.println(Integer.MAX_VALUE);
    }

    @Test
    public void test3() {

//        String[] T = new String[]{"codility1", "codility2", "codility3", "codility4b", "codility4a"};
//        String[] R = new String[]{"Wrong answer", "OK", "OK", "Runtime error", "OK"};

        String[] T = new String[]{"test1a", "test2b", "test1b", "test1c", "test3"};
        String[] R = new String[]{"Wrong answer", "OK", "Runtime error", "OK", "Time limit exceeded"};

        System.out.println(this.solution3(T, R));
    }

    @Test
    public void test2() {

        String schedule = "Sun 10:00-20:00\n" +
                "Fri 05:00-10:00\n" +
                "Fri 16:30-23:50\n" +
                "Sat 10:00-24:00\n" +
                "Sun 01:00-04:00\n" +
                "Sat 02:00-06:00\n" +
                "Tue 03:30-18:15\n" +
                "Tue 19:00-20:00\n" +
                "Wed 04:25-15:14\n" +
                "Wed 15:14-22:40\n" +
                "Thu 00:00-23:59\n" +
                "Mon 05:00-13:00\n" +
                "Mon 15:00-21:00";

        this.solution2(schedule);
    }

    public int solution1(int[] T) {

        if (T.length < 2 || T.length % 2 != 0 || T.length > 100000) {
            return 0;
        }

        int size = T.length;
        HashSet<Integer> result = new HashSet<>();

        for (int i = 0; i < size; i++) {

            if (result.size() != (size/2) && T[i] != 0) {
                result.add(T[i]);

            }

        }

        return result.size();
    }

    public int solution3(String[] T, String[] R) {

        if (T.length != R.length) {
            return 0;
        } else if (T.length > 300) {
            return 0;
        }


        String regex = "\\D+[1-9]\\D*";

        Map<String, Boolean> groupStatus = new HashMap<>();
        HashSet<String> groups = new HashSet<>();

        for (int i = 0; i < T.length; i++) {

            if (T[i].length() <= 300 && T[i].matches(regex) && this.validator(R[i])) {

                Pattern pattern = Pattern.compile(regex);
                Matcher matcher = pattern.matcher(T[i]);

                if (matcher.find()) {

                    String matchStr = matcher.group();

                    String groupOnlyOne = "\\D+[1-9]+";
                    String groupMoreThanOne = "\\D+[1-9]+\\D+";
                    String groupKey = "";

                    if (matchStr.matches(groupOnlyOne)) {
                        groupKey = matchStr;
                    } else if (matchStr.matches(groupMoreThanOne)) {
                        groupKey = matchStr.substring(0, matchStr.length() - 1);
                    }

                    groups.add(groupKey);

                    if (!groupStatus.containsKey(groupKey)) {
                        groupStatus.put(groupKey, R[i].equals("OK"));
                    } else {

                        if (R[i].equals("OK") && groupStatus.get(groupKey)) {
                            System.out.println("As");
                        }
                    }
                }
            }
        }

        int total = 0;

        for (Map.Entry<String, Boolean> entry: groupStatus.entrySet()) {

            if (entry.getValue()) {
                total += 100;
            }
        }

        return total / groups.size();
    }

    private boolean validator(String status) {

        List<String> statuses = new ArrayList<>();
        statuses.add("Wrong answer");
        statuses.add("OK");
        statuses.add("Runtime error");
        statuses.add("Time limit exceeded");

        return statuses.contains(status);
    }

    public int solution2(String scheduleStr) {

        List<String> weekDay = new ArrayList<>();
        weekDay.add("Mon");
        weekDay.add("Tue");
        weekDay.add("Wed");
        weekDay.add("Thu");
        weekDay.add("Fri");
        weekDay.add("Sat");
        weekDay.add("Sun");

        String[] schedules = scheduleStr.split("\n");
        int i = 0, day;
        int h1 = 0, m1 = 0, t1 = 0;
        int h2 = 0, m2 = 0, t2 = 0;

        List<int[]> workRanges = new ArrayList<>();

        for (i = 0; i < schedules.length; i++) {

            String schedule = schedules[i];

            day = weekDay.indexOf(schedule.substring(0, 3));
            h1 = Integer.valueOf(schedule.substring(4, 6));
            m1 = Integer.valueOf(schedule.substring(7, 9));
            h2 = Integer.valueOf(schedule.substring(10, 12));
            m2 = Integer.valueOf(schedule.substring(13, 15));

            t1 = day * 1440 + h1 * 60 + m1;
            t2 = day * 1440 + h2 * 60 + m2;

            workRanges.add(new int[]{t1,t2});

        }

        Collections.sort(workRanges, new Comparator<int[]>() {

            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });

        int sleepTimeMax = -1;
        int sleepTime = workRanges.get(0)[0];


        for (int j = 1; j < workRanges.size(); j++) {

            sleepTime = workRanges.get(j)[0] - workRanges.get(j-1)[1];

            if (sleepTime > sleepTimeMax) {
                sleepTimeMax = sleepTime;
            }

        }


        sleepTime = (1440 * 7) - workRanges.get(workRanges.size() - 1)[1];
        if (sleepTime > sleepTimeMax) { sleepTimeMax = sleepTime; }


        return sleepTimeMax;
    }
}
