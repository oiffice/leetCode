package leetCode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class LeetCode144 {
    @Test
    public void test1() {
        TreeNode node3 = new TreeNode(3);
        TreeNode node2 = new TreeNode(node3, null, 2);
        TreeNode root = new TreeNode(null, node2, 1);
        System.out.println(preorderTraversal(root));
    }
    public List<Integer> preorderTraversal(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<Integer> list = new ArrayList<>();
        preorderTraverse(root, list);
        return list;
    }

    public void preorderTraverse(TreeNode node, List<Integer> list) {
        list.add(node.val);
        if (node.left != null) {
            preorderTraverse(node.left, list);
        }

        if(node.right != null) {
            preorderTraverse(node.right, list);
        }
    }
}
