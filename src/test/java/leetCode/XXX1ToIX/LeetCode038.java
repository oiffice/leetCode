package leetCode.XXX1ToIX;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LeetCode038 {



    private String countAndSay(int times) {

       String result = "1";

       while (times > 1) {
           result = doCountAndSay(result);
           times--;
       }

        return result;

    }

    private String doCountAndSay(String s) {
        StringBuilder sb = new StringBuilder();
        int count = 1;
        char say = s.charAt(0);

        for (int i = 1; i < s.length(); i++) {

            if (s.charAt(i) == say) {
                count++;
            } else {
                sb.append(count).append(say);
                say = s.charAt(i);
                count = 1;
            }
        }

        sb.append(count).append(say);
        return sb.toString();
    }

    @Test
    public void test1() {
        String result = this.countAndSay(1);
        assertEquals("1", result);
    }

    @Test
    public void test2() {
        String result = this.countAndSay(2);
        assertEquals("11", result);
    }

    @Test
    public void test3() {
        String result = this.countAndSay(3);
        assertEquals("21", result);
    }

    @Test
    public void test4() {
        String result = this.countAndSay(4);
        assertEquals("1211", result);
    }

    @Test
    public void test5() {
        String result = this.countAndSay(5);
        assertEquals("111221", result);
    }

    @Test
    public void test6() {
        String result = this.countAndSay(6);
        assertEquals("312211", result);
    }
}
