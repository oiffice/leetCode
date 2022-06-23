package leetCode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class LeetCode113 {
    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        result = new ArrayList<>();

        hasPathSum(root, targetSum, new ArrayList<>());
        return result;
    }

    public  void hasPathSum(TreeNode node, int targetSum, List<Integer> list) {
        List<Integer> left;
        List<Integer> right;
        if (node.left != null) {
            left = new ArrayList<>(list);
            left.add(node.val);
            hasPathSum(node.left, targetSum - node.val, left);
        }

        if (node.right != null) {
            right = new ArrayList<>(list);
            right.add(node.val);
            hasPathSum(node.right, targetSum - node.val, right);
        }

        if (node.left == null && node.right == null && node.val == targetSum) {
            list.add(node.val);
            result.add(list);
        }
    }

    @Test
    public void  test1() {
        TreeNode d4 = new TreeNode(1);
        TreeNode c4 = new TreeNode(5);
        TreeNode b3 = new TreeNode(13);
        TreeNode c3 = new TreeNode(4);
        c3.right = d4;
        c3.left = c4;
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

        List<List<Integer>> result = pathSum(root, 22);
        for (List<Integer> l : result) {
            for(int i: l) {
                System.out.print(i + ",");
            }
            System.out.println("");
        }
    }

    @Test
    public void test2() {
        TreeNode root = new TreeNode(new TreeNode(2), new TreeNode(3), 1);
        pathSum(root, 1);
        System.out.println(result);
    }
    @Test
    public void test3() {
        TreeNode root = new TreeNode(new TreeNode(2), null, 0);
        pathSum(root, 1);
        System.out.println(result);
    }
}
