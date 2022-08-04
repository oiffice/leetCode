package leetCode;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PermutationSequence060 {

    public String getPermutation(int n, int k) {

        if (n == 1) {
            return String.valueOf(1);
        }

        char[] chars = new char[n];
        for (int i = 1; i <= n; i++) {
            chars[i - 1] = (char)(i + 48);
        }

        if (k == 1) {
            return String.valueOf(chars);
        }

        return doit(String.valueOf(chars), n, k);
    }

    private String doit(String startString, int n, int k) {

        if (n == 2) {

            if (k == 1) {
                return startString;
            }

            return String.valueOf(startString.charAt(1)).concat(String.valueOf(startString.charAt(0)));
        }

        // init string and p

        int p = 1, i;
        char[] chars = new char[n];

        for (i = 1; i <= n; i++) {
            p *= i;
            chars[i - 1] = startString.charAt(i - 1);
        }

        p /= n;

        // grouping
        int group = (k - 1) / p;

        // swap
        for (int j = 0; j < group; j++) {
            char temp = chars[j];
            chars[j] = chars[group];
            chars[group] = temp;
        }

        // new string and new k
        String nextStr = String.valueOf(chars, 1, chars.length - 1);
        int mod = k % p;

        if (mod == 0) {
            mod = p;
        }

        return String.valueOf(chars[0]).concat(doit(nextStr, nextStr.length(), mod));

    }

    @Test
    public void test1() {
        int n = 3;
        int k = 3;

        assertEquals("213", getPermutation(n, k));
    }

    @Test
    public void test2() {
        int n = 3;
        int k = 2;

        assertEquals("132", getPermutation(n, k));
    }

    @Test
    public void test3() {
        int n = 3;
        int k = 6;

        assertEquals("321", getPermutation(n, k));
    }

    @Test
    public void test4() {
        int n = 4;
        int k = 9;

        assertEquals("2314", getPermutation(n, k));
    }

    @Test
    public void test5() {
        int n = 4;
        int k = 5;

        assertEquals("1423", getPermutation(n, k));
    }

    @Test
    public void test6() {
        int n = 4;
        int k = 6;

        assertEquals("1432", getPermutation(n, k));
    }

    @Test
    public void test7() {
        int n = 2;
        int k = 2;

        assertEquals("21", getPermutation(n, k));
    }
}
