package leetCode;

import org.junit.Test;

import java.util.Queue;
import java.util.concurrent.LinkedBlockingDeque;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.format;

public class SerializeDeserializeBT_String {

    @Test
    public void test1() {
        TreeNode l3a = new TreeNode("l");
        TreeNode l3b = new TreeNode("o");
        TreeNode l3c = new TreeNode("w");
        TreeNode l3d = new TreeNode("o");
        TreeNode r3a = new TreeNode("d");
        TreeNode l2a = new TreeNode("l");
        l2a.left = l3a;
        l2a.right = l3b;
        TreeNode l2b = new TreeNode(" ");
        l2b.left = l3c;
        l2b.right = l3d;
        TreeNode r2a = new TreeNode("l");
        r2a.left = r3a;
        TreeNode l1a = new TreeNode("e");
        l1a.left = l2a;
        l1a.right = l2b;
        TreeNode r1a = new TreeNode("r");
        r1a.left = r2a;
        TreeNode root = new TreeNode("h");
        root.left = l1a;
        root.right = r1a;

        assertEquals("hello world", serialize(root));
    }

    @Test
    public void test2() {
        TreeNode result = this.deserialize("hello world");
        assertEquals("hello world", serialize(result));
    }

        // Encodes a tree to a single string.
    public String serialize(TreeNode root) {

        if (root == null) return null;

        StringBuilder sb = new StringBuilder();
        sb.append(root.value);

        if (root.left != null) {
            sb.append(serialize(root.left));
        }

        if (root.right != null) {
            sb.append(serialize(root.right));
        }
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

        if (data.isEmpty()) return null;

        TreeNode result = new TreeNode(data.poll());

        if (totalDepth > currentDepth) {
            result.left = deserializeString(data, totalDepth, currentDepth + 1);
            result.right = deserializeString(data, totalDepth, currentDepth + 1);
        }
        return result;
    }

    public class TreeNode {
        TreeNode left = null;
        TreeNode right = null;
        String value = "";

        public TreeNode() {

        }

        public TreeNode(String value) {
            this.value = value;
        }

        public TreeNode(TreeNode left, TreeNode right, String value) {
            this.value = value;
            this.left = left;
            this.right = right;
        }
    }
}




