package leetCode;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class LeetCode124 {

    int max = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        findPathMax(root);
        return max;
    }

    private int findPathMax(TreeNode node) {
        int left = 0;
        int right = 0;

        if (node == null) return 0;

        if (node.left != null) {
            left = findPathMax(node.left);
        }
        if (node.right != null) {
            right = findPathMax(node.right);
        }

        int returnValue = Math.max(node.val, Math.max(left, right) + node.val);
        max = Math.max(max, Math.max(returnValue, left + right + node.val));

        return returnValue;
    }

    @Test
    public void test1() {
        TreeNode b3 = new TreeNode(new TreeNode(10), new TreeNode(30), 7);
        TreeNode a3 = new TreeNode(15);
        TreeNode a2 = new TreeNode(a3, b3, 20);
        TreeNode b2 = new TreeNode(new TreeNode(3), new TreeNode(2), 9);
        TreeNode root = new TreeNode(a2, b2, -1);
        assertEquals(72, maxPathSum(root));
    }

    @Test
    public void test2() {
        TreeNode root = new TreeNode(new TreeNode(2), new TreeNode(3), 1);
        assertEquals(6, maxPathSum(root));
    }

    @Test
    public void test3() {
        TreeNode a2 = new TreeNode(9);
        TreeNode b2 = new TreeNode(new TreeNode(15), new TreeNode(7), 20);
        TreeNode root = new TreeNode(a2, b2, -10);
        assertEquals(42, maxPathSum(root));
    }


    @Test
    public void test4() {
        TreeNode root = new TreeNode(0);
        assertEquals(0, maxPathSum(root));
    }

    @Test
    public void test5() {
        TreeNode root = new TreeNode(new TreeNode(-2), new TreeNode(-1), 2);
        assertEquals(2, maxPathSum(root));
    }
}
