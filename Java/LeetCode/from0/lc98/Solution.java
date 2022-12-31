package lc98;

public /**
* Definition for a binary tree node.
* public class TreeNode {
*     int val;
*     TreeNode left;
*     TreeNode right;
*     TreeNode() {}
*     TreeNode(int val) { this.val = val; }
*     TreeNode(int val, TreeNode left, TreeNode right) {
*         this.val = val;
*         this.left = left;
*         this.right = right;
*     }
* }
*/
class Solution {
   public boolean isValidBST(TreeNode root) {
       return isValidBST(root,null,null);
   }

   public boolean isValidBST(TreeNode root, Integer left, Integer right){
       if(root == null){
           return true;
       }
       if(right!=null && root.val >= right){
           return false;
       }
       if(left!=null && root.val <= left){
           return false;
       }
       if(root.left != null && root.left.val >= root.val){
           return false;
       }
       if(root.right != null && root.right.val <= root.val){
           return false;
       }
       boolean ret = isValidBST(root.left,left,root.val) && isValidBST(root.right,root.val,right);
       return ret;
   }
}
