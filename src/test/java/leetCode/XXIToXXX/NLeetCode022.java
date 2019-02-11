package leetCode.XXIToXXX;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created by oiffice on 2018/11/19.
 */
public class NLeetCode022 {

    @Test
    public void aaA() {

    }

    @Test
    public void test1() {
        System.out.println(this.generateParenthesis(1));
    }

    public List<String> generateParenthesis(int n) {

        List<String> result = new ArrayList<>();

        this.dfs(result, "", n, n);
        return result;
    }

    private void dfs(List<String> result, String s, int left, int right){
        if(left > right)
            return;

        if(left==0&&right==0){
            result.add(s);
            return;
        }

        if(left>0){
            dfs(result, s+"(", left-1, right);
        }

        if(right>0){
            dfs(result, s+")", left, right-1);
        }
    }


}

