package leetCode;

import org.junit.Test;

public class LeetCode114 {
    @Test
    public void test1() {
        TreeNode node6 = new TreeNode(null, new TreeNode(7), 6);
        TreeNode node3 = new TreeNode(new TreeNode(5), null, 3);
        TreeNode node2 = new TreeNode(node3, new TreeNode(4), 2);
        TreeNode root = new TreeNode(node2, node6, 1);
        flatten(root);
        System.out.println("asfd");
    }
    @Test
    public void test2() {
        TreeNode node4 = new TreeNode(null, new TreeNode(6), 4);
        TreeNode node2 = new TreeNode(new TreeNode(3), null, 2);
        TreeNode root = new TreeNode(node2, node4, 1);
        flatten(root);
        System.out.println("asfd");
    }
    @Test
    public void test3() {
        TreeNode node2 = new TreeNode(new TreeNode(3), null, 2);
        TreeNode root = new TreeNode(null, node2, 1);
        flatten(root);
        System.out.println("asfd");
    }
    public void flatten(TreeNode root) {
        if (root == null) {return ;}
        if (root.left == null && root.right == null) { return ; }

        if (root.left != null) {
            flatten(root.left);
            TreeNode tR = root.right;
            root.right = root.left;
            root.left = null;

            TreeNode t = root.right;

            while (t.right != null) {
                t = t.right;
            }
            t.right = tR;
        }

        flatten(root.right);
    }
}
