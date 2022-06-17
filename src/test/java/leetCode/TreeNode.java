package leetCode;

public class TreeNode {
    TreeNode left = null;
    TreeNode right = null;
    int value = 0;

    public TreeNode() {

    }

    public TreeNode(int value) {
        this.value = value;
    }

    public TreeNode(TreeNode left, TreeNode right, int value) {
        this.value = value;
        this.left = left;
        this.right = right;
    }
}
