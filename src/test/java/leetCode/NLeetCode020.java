package leetCode;

import org.junit.Assert;
import org.junit.Test;

import java.util.Objects;
import java.util.Stack;

/**
 * Created by oiffice on 2018/7/3.
 */
public class NLeetCode020 {

    @Test
    public void test() {

        Assert.assertTrue(isValid("[]"));
        Assert.assertTrue(isValid("[](){}"));
        Assert.assertTrue(isValid("{}[()]"));
        Assert.assertFalse(isValid("{(}[)]"));
        Assert.assertFalse(isValid("{(}[)]"));
        Assert.assertFalse(isValid("{"));
        Assert.assertFalse(isValid("]"));
        Assert.assertTrue(isValid(""));


    }

    public boolean isValid(String s) {

        if (Objects.isNull(s) || s.isEmpty()) {
            return true;
        }
        char[] chars = s.toCharArray();

        Stack<Character> stack = new Stack<>();

        for(char c: chars) {

            if (c == '(') {
                stack.push(')');
            } else if (c == '[') {
                stack.push(']');
            } else if (c == '{') {
                stack.push('}');
            } else if (stack.empty() || !stack.pop().equals(c)) {
                return false;
            }
        }

        return stack.isEmpty();

    }
}
