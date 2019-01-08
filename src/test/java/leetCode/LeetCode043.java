package leetCode;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LeetCode043 {

    @Test
    public void test() {

        String first = "2";
        String second = "3";

        Assert.assertEquals("6", this.multiply(first, second));
    }

    @Test
    public void test2() {

        String first = "123";
        String second = "456";

        Assert.assertEquals("56088", this.multiply(first, second));
    }

    @Test
    public void test3() {

        String first = "0";
        String second = "456";

        Assert.assertEquals("0", this.multiply(first, second));
    }

    @Test
    public void test4() {

        String first = "123456789";
        String second = "987654321";

        Assert.assertEquals("121932631112635269", this.multiply(first, second));
    }


    public String multiply(String num1, String num2) {

        Map<Character, Integer> stringIntegerMap = new HashMap<>();

        stringIntegerMap.put('0', 0);
        stringIntegerMap.put('1', 1);
        stringIntegerMap.put('2', 2);
        stringIntegerMap.put('3', 3);
        stringIntegerMap.put('4', 4);
        stringIntegerMap.put('5', 5);
        stringIntegerMap.put('6', 6);
        stringIntegerMap.put('7', 7);
        stringIntegerMap.put('8', 8);
        stringIntegerMap.put('9', 9);

        Map<Integer, String> integerStringMap = new HashMap<>();

        integerStringMap.put(0, "0");
        integerStringMap.put(1, "1");
        integerStringMap.put(2, "2");
        integerStringMap.put(3, "3");
        integerStringMap.put(4, "4");
        integerStringMap.put(5, "5");
        integerStringMap.put(6, "6");
        integerStringMap.put(7, "7");
        integerStringMap.put(8, "8");
        integerStringMap.put(9, "9");


        String first = (num1.length() > num2.length()) ? num2 : num1;
        String second = (num1.length() < num2.length()) ? num1 : num2;

        int shift = 1;
        List<String> layers = new ArrayList<>();

        for (int i = 0; i < first.length(); i++) {

            int multipleInt = Integer.valueOf(String.valueOf(first.charAt(i)));
            StringBuilder builder = new StringBuilder();
            int overflow = 0;

            for (int j = 0; j < second.length(); j++) {

                int

            }


        }

    }
}
