package leetCode;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by oiffice on 2018/7/16.
 */
public class ZigZagConversionTest {

    @Test
    public void zigZag() {

        String originStr = "PAYPALISHIRING";

        Assert.assertEquals("PAHNAPLSIIGYIR", convert(originStr, 3));
    }

    public String convert(String s, int numRows) {

        int i = 0;
        int pivot = 0;
        int revers = 1;

        Map<Integer, List<Character>> integerListMap = new HashMap<>();

        while (i < s.length()) {
            List<Character> characters;
            int realPivot = pivot % numRows;

            if (!integerListMap.containsKey(realPivot)) {

                characters = new ArrayList<>();
                characters.add(s.charAt(i));
                integerListMap.put(realPivot, characters);

            } else {

                characters = integerListMap.get(realPivot);
                characters.add(s.charAt(i));

            }


            if (realPivot == (numRows - 1)) {
                revers = -1;
            } else if (realPivot == 0) {
                revers = 1;
            }

            pivot += revers;
            i++;
        }

        StringBuilder sb = new StringBuilder();

        integerListMap.entrySet().forEach(integerListEntry -> {

            List<Character> characters = integerListEntry.getValue();

            characters.forEach(c -> sb.append(c));

        });

        return sb.toString();

    }
}
