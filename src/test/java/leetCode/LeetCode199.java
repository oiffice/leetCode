package leetCode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class LeetCode199 {
    @Test
    public void test1() {
        TreeNode root = new TreeNode(new TreeNode(new TreeNode(5), null, 2), null, 1);
        List<Integer> list = rightSideView(root);
        System.out.println(list);
    }
    @Test
    public void test2() {
        TreeNode root = new TreeNode(new TreeNode(new TreeNode(4), null, 2), new TreeNode(3), 1);
        List<Integer> list = rightSideView(root);
        System.out.println(list);
    }
    @Test
    public void test3() {
        TreeNode root = new TreeNode();
        List<Integer> list = rightSideView(root);
        System.out.println(list);
    }
    @Test
    public void test4() {
        TreeNode root = new TreeNode(1);
        List<Integer> list = rightSideView(root);
        System.out.println(list);
    }
    @Test
    public void test5() {
        TreeNode l4 = new TreeNode(8);
        TreeNode l3a = new TreeNode(l4, null, 7);
        TreeNode l3b = new TreeNode(4);
        TreeNode r3a = new TreeNode(11);
        TreeNode r3b = new TreeNode(9);
        TreeNode l2a = new TreeNode(l3a, l3b, 2);
        TreeNode l2b = new TreeNode(r3a, r3b, 3);
        TreeNode root = new TreeNode(l2a, l2b, 1);


        List<Integer> list = rightSideView(root);
        System.out.println(list);
    }

    public List<Integer> rightSideView(TreeNode root) {
        if (root == null) return new ArrayList<>();
        List<Integer> left = new ArrayList<>();
        List<Integer> right = new ArrayList<>();
        List<Integer> result = new ArrayList<>();

        if (root.left !=  null){
            left.addAll(rightSideView(root.left));
        }

        if (root.right != null) {
            right.addAll(rightSideView(root.right));
        }
        int i = 0;
        for (; i < right.size(); i++) {
            result.add(i, right.get(i));
        }
        for (int j = i; j < left.size(); j++) {
            result.add(j, left.get(j));
        }

        result.add(0, root.val);
        return result;
    }
}
