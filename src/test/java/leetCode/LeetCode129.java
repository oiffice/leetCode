package leetCode;

import org.junit.Test;

import java.util.Iterator;
import java.util.Stack;

public class LeetCode129 {
    @Test
    public void test1() {
        TreeNode r1 = new TreeNode(4);
        TreeNode r2 = new TreeNode(null, r1, 3);
        TreeNode r3 = new TreeNode(null, r2, 2);
        TreeNode root = new TreeNode(null, r3, 1);
        System.out.println(sumNumbers(root));

    }
    @Test
    public void test2() {
        TreeNode l2a = new TreeNode(5);
        TreeNode l2b = new TreeNode(1);
        TreeNode l1a = new TreeNode(l2a, l2b, 9);
        TreeNode r1a = new TreeNode(0);
        TreeNode root = new TreeNode(l1a, r1a, 4);
        System.out.println(sumNumbers(root));

    }
    private int sum = 0;
    public int sumNumbers(TreeNode root) {

        preOrder(root, 0);
        return this.sum;
    }

    public int go(TreeNode node, Stack<Integer> stack) {
        int count = 0;

        stack.push(node.val);

        if (node.left == null && node.right == null) {
            int c = stack.size();
            for (Integer integer : stack) {
                count = count + integer * (int) Math.pow(10, c - 1);
                c--;
            }
        } else {
            if (node.left != null) {
                count += go(node.left, stack);
                stack.pop();
            }
            if (node.right != null) {
                count += go(node.right, stack);
                stack.pop();
            }
        }
        return count;
    }

    public void preOrder(TreeNode node, int currSum) {
        currSum = currSum * 10 + node.val;
        if (node.left != null) {
            preOrder(node.left, currSum);
        }
        if (node.right != null) {
            preOrder(node.right, currSum);
        }
        if (node.left == null && node.right == null) {
            sum += currSum;
        }
    }
}
