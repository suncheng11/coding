package from500.lc538;

public class Solution {
   public TreeNode convertBST(TreeNode root) {
       return convertBST(root,0);
   }

   public TreeNode convertBST(TreeNode root,int plus) {
       if(root == null){
           return null;
       }
       convertBST(root.right,plus);
       if(root.right == null){
           root.val += plus;
       }

       TreeNode rightMin = getMin(root.right);
       if(rightMin != null){
           root.val += rightMin.val;
       }

       convertBST(root.left,root.val);

       return root;
   }

   private TreeNode getMin(TreeNode node){
       if(node == null){
           return null;
       }
       TreeNode cur = node;
       while(cur.left != null){
           cur = cur.left;
       }
       return cur;
   }
}