/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left;
 *     public TreeNode right;
 *     public TreeNode(int val=0, TreeNode left=null, TreeNode right=null) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
public class Solution {
    public TreeNode UpsideDownBinaryTree(TreeNode root) {
        if(root == null || root.left == null ){
            return root;
        }

        TreeNode left = UpsideDownBinaryTree(root.left);
        TreeNode right =UpsideDownBinaryTree(root.right);

        root.left = null;
        root.right = null;

        TreeNode cur = left;
        while(cur.right!=null){
            cur = cur.right;
        }

        cur.left = root;
        cur.right = right;
        

        cur.left = right;
        cur.right =root;
        
        return left;
    }
}