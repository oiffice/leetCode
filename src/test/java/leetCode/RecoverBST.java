package leetCode;

import org.junit.Test;

public class RecoverBST {
    @Test
    public void test1() {
        TreeNode node13 = new TreeNode(new TreeNode(9), new TreeNode(11), 13);
        TreeNode node5 = new TreeNode(null, node13, 5);
        TreeNode node14 = new TreeNode(null, new TreeNode(17), 14);
        TreeNode root = new TreeNode(node5, node14, 12);
        recoverTree(root);
        System.out.println(root.val);
    }
    TreeNode first;
    TreeNode second;
    TreeNode pre;
    public void recoverTree(TreeNode root) {
        if (root == null) return;
        inorder(root);
        if(second!=null && first !=null){
            int val = second.val;
            second.val = first.val;
            first.val = val;
        }
    }

    public void inorder(TreeNode root){
        if(root==null)
            return;

        inorder(root.left);

        if(pre==null){
            pre=root;
        }else{
            if(root.val<pre.val){
                System.out.println("root less: " + root.val + " pre: " + pre.val);
                if(first==null){
                    first=pre;
                }
                System.out.println(root.val);
                second=root;
            }
            pre=root;
        }

        inorder(root.right);
    }
}
