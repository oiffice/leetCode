package leetCode;

import org.junit.Test;

import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertTrue;

public class LeetCode110 {
    @Test
    public void test1() {
        TreeNode a2 = new TreeNode(4);
        TreeNode b2 = new TreeNode(3);
        TreeNode a3 = new TreeNode(1);
        TreeNode b3 = new TreeNode(13);
        TreeNode root = new TreeNode(39);
        b2.left = a3;
        b2.right = b3;
        root.left = a2;
        root.right = b2;
        assertTrue(isBalanced(root));
    }
    @Test
    public void test2() {
        TreeNode root = new TreeNode(39);
        assertTrue(isBalanced(root));
    }
    @Test
    public void test3() {
        TreeNode a4 = new TreeNode(4);
        TreeNode b4 = new TreeNode(4);
        TreeNode a3 = new TreeNode(3);
        TreeNode b3 = new TreeNode(3);
        TreeNode a2 = new TreeNode(2);
        TreeNode b2 = new TreeNode(2);
        TreeNode root = new TreeNode(1);
        a3.left = a4;
        a3.right = b4;
        a2.left = a3;
        a2.right = b3;
        root.left = a2;
        root.right = b2;

        assertFalse(isBalanced(root));
    }
    @Test
    public void test4() {
        TreeNode a4 = new TreeNode(4);
        TreeNode b4 = new TreeNode(4);
        TreeNode a3 = new TreeNode(3);
        TreeNode b3 = new TreeNode(3);
        TreeNode a2 = new TreeNode(2);
        TreeNode b2 = new TreeNode(2);
        TreeNode root = new TreeNode(1);

        a3.left = a4;
        b3.right = b4;
        a2.left = a3;
        b2.right = b3;
        root.left = a2;
        root.right = b2;

        assertFalse(isBalanced(root));
    }

    public boolean isBalanced(TreeNode root) {

        if (root == null) return true;
        int depth = depth(root);
        return depth >= 0;

    }

    private int depth(TreeNode node) {
        int left = 0;
        int right = 0;

        if (node.left != null) {
            left = depth(node.left);
            if (left < 0) {
                return -1;
            }
        }

        if (node.right != null) {
            right = depth(node.right);
            if (right < 0) {
                return -1;
            }
        }

        if (Math.abs(left - right) > 1) {
            return -1;
        } else {
            return Math.max(left, right) + 1;
        }
    }
}
