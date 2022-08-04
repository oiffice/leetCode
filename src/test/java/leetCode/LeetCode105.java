package leetCode;

import org.junit.Test;

import java.util.Arrays;

public class LeetCode105 {
    @Test
    public void test1() {
        int[] preorder = new int[]{3,9,20,17,13,15,7};
        int[] inorder = new int[]{17,20,9,13,3,15,7};
        TreeNode node = buildTree(preorder, inorder);
        System.out.println(node.left);
    }
    public TreeNode buildTree(int[] preorder, int[] inorder) {

        int n = inorder.length;

        if (n == 0) {
            return null;
        } else if (n == 1) {
            return new TreeNode(preorder[0]);
        } else {
            int pos = 0;
            for(int i =0; i<inorder.length; i++) {
                if (inorder[i] == preorder[0]) {
                    pos = i;
                    break;
                }
            }

            TreeNode root = new TreeNode(preorder[0]);
            root.left = buildTree(Arrays.copyOfRange(preorder, 1, pos+1), Arrays.copyOfRange(inorder, 0, pos));
            root.right = buildTree(Arrays.copyOfRange(preorder, pos+1, n), Arrays.copyOfRange(inorder, pos+1, inorder.length));
            return root;
        }
    }
}
