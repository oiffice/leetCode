package leetCode;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class Testing3 {

    private List<Integer> list = new ArrayList<>();

    @Before
    public void setUp() {
        for (int i = 0; i < 10238; i++) {
            list.add(i, i*2);
        }
    }

    @Test
    public void testing() {
        List<String> list = new ArrayList<>();
        list.add("6");
        list.add("a");
        list.add("b");
        list.add("ba");
        list.add("bca");
        list.add("bda");
        list.add("bdca");

        System.out.println(("ABC".substring(0, 0)));
        System.out.println(("ABC".substring(1)));
        System.out.println(("ABC".substring(0, 0) + "ABC".substring(1)));
        System.out.println(longestChain(list));


    }

    @Test
    public void testing2() {

        List<String> list = new ArrayList<>();
        list.add("6");
        list.add("a");
        list.add("zxb");
        list.add("ba");
        list.add("bca");
        list.add("bda");
        list.add("zxbe");
        list.add("azxbe");
        list.add("azxpbe");


        System.out.println(longestChain(list));

    }

    public static int longestChain(List<String> words) {
        // Write your code here
        int max = Integer.MIN_VALUE;

        if (Objects.isNull(words) || words.size() < 1) {
            return 0;
        }

        Map<String, Integer> stringIntegerMap = new HashMap<>();


        for (int i = 0; i < words.size(); i++) {

            int chainLength = find(words, words.get(i), stringIntegerMap) + 1;
            stringIntegerMap.put(words.get(i), chainLength);
            max = Math.max(max, chainLength);
        }

        return max;
    }

    private static int find(List<String> originalWords, String string, Map<String, Integer> stringIntegerMap) {

        int wordCount = 0;

        for (int i = 0; i < string.length(); i++) {

            String subString = string.substring(0, i) + string.substring(i + 1);

            if (originalWords.contains(subString)) {
                if (stringIntegerMap.containsKey(subString)) {
                    wordCount = Math.max(wordCount, stringIntegerMap.get(subString));
                } else {
                    int nextWordChainLen = find(originalWords, subString, stringIntegerMap);
                    wordCount = Math.max(wordCount, nextWordChainLen + 1);
                }
            }
        }
        return wordCount;
    }

}
