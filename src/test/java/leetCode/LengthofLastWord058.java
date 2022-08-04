package leetCode;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LengthofLastWord058 {

    public int lengthOfLastWord(String s) {

        String[] splitString = s.split(" ");

        if (splitString.length == 0) {
            return 0;
        }

        return splitString[splitString.length - 1].length();
    }

    @Test
    public void test1() {
        String str = "Hello World";

        assertEquals(5, lengthOfLastWord(str));
    }

    @Test
    public void test2() {
        String str = "";

        assertEquals(0, lengthOfLastWord(str));
    }

    @Test
    public void test3() {
        String str = "Hello";

        assertEquals(5, lengthOfLastWord(str));
    }

}
