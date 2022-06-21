package leetCode;

import org.junit.Test;

import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertTrue;

public class LeetCode112 {
    @Test
    public void  test1() {
        TreeNode c4 = new TreeNode(1);
        TreeNode b3 = new TreeNode(13);
        TreeNode c3 = new TreeNode(4);
        c3.right = c4;
        TreeNode a4 = new TreeNode(7);
        TreeNode b4 = new TreeNode(2);
        TreeNode a3 = new TreeNode(11);
        a3.left = a4;
        a3.right = b4;
        TreeNode a2 = new TreeNode(4);
        TreeNode b2 = new TreeNode(8);
        b2.left = b3;
        b2.right = c3;
        a2.left = a3;
        TreeNode root = new TreeNode(5);
        root.left = a2;
        root.right = b2;

        assertTrue(hasPathSum(root, 22));
    }
    @Test
    public void test2() {
        TreeNode root = new TreeNode(new TreeNode(-2),new TreeNode(3), 1);
        assertFalse(hasPathSum(root, 1));
    }
    @Test
    public void  test3() {
        TreeNode root = new TreeNode(1);
        assertTrue(hasPathSum(root, 1));
    }
    @Test
    public void  test4() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        assertFalse(hasPathSum(root, 1));
    }

    public boolean hasPathSum(TreeNode root, int targetSum) {

        if (root == null) {
            return false;
        }

        if (root.left == null && root.right == null && root.val == targetSum) return true;

        return hasPathSum(root.left, targetSum - root.val) ||
                hasPathSum(root.right, targetSum - root.val);
    }
}