package leetCode;

import org.junit.Test;

import java.util.Objects;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingDeque;

public class LeetCode297 {
    @Test
    public void test1() {
        TreeNode root = new TreeNode(1);
        TreeNode left = new TreeNode(2);
        TreeNode right = new TreeNode(3);
        TreeNode rightL = new TreeNode(4);
        TreeNode rightR = new TreeNode(5);
        right.left = rightL;
        right.right = rightR;
        root.left = left;
        root.right = right;



    }

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) return "#";

        StringBuilder sb = new StringBuilder();
        sb.append(root.val)
                .append(",")
                .append(serialize(root.left))
                .append(",")
                .append(serialize(root.right));
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        int depth = (int) Math.ceil(Math.log(data.length()) / Math.log(2));
        Queue<String> queue = new LinkedBlockingDeque<>();
        char[] ary = data.toCharArray();

        for(char c : ary) {
            queue.add(String.valueOf(c));
        }

        return this.deserializeString(queue, depth, 1);
    }

    private TreeNode deserializeString(Queue<String> data, int totalDepth, int currentDepth) {

        if (data.isEmpty() || Objects.equals(data.peek(), "#")) {
            return null;
        }

        TreeNode result = new TreeNode(Integer.parseInt(data.poll()));

        if (totalDepth > currentDepth) {
            result.left = deserializeString(data, totalDepth, currentDepth + 1);
            result.right = deserializeString(data, totalDepth, currentDepth + 1);
        }
        return result;
    }

}
