package leetCode;

public class TreeNode {
    TreeNode left = null;
    TreeNode right = null;
    int val = 0;

    public TreeNode() {

    }

    public TreeNode(int value) {
        this.val = value;
    }

    public TreeNode(TreeNode left, TreeNode right, int value) {
        this.val = value;
        this.left = left;
        this.right = right;
    }
}
