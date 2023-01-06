package from400.lc450;

public class Solution {
   public TreeNode deleteNode(TreeNode root, int key) {
       if(root == null){
           return null;
       }
       if(key < root.val){
           root.left = deleteNode(root.left,key);
           return root;
       }
       if(key > root.val){
           root.right = deleteNode(root.right,key);
           return root;
       }

       if(root.left == null){
           TreeNode rightNode = root.right;
           root.right = null;
           return rightNode;
       }

       if(root.right == null){
           TreeNode leftNode = root.left;
           root.left = null;
           return leftNode;
       }

       TreeNode successor = minimum(root.right);
       successor.right = removeMin(root.right);
       successor.left = root.left;

       root.left = root.right = null;

       return successor;
   }

   private TreeNode maximum(TreeNode node){
       if(node.right == null)
           return node;

       return maximum(node.right);
   }

   private TreeNode minimum(TreeNode node){
       if(node.left == null)
           return node;
       return minimum(node.left);
   }

   private TreeNode removeMax(TreeNode node){
       if(node.right == null){
           TreeNode leftNode = node.left;
           node.left = null;
           return leftNode;
       }
       node.right = removeMax(node.right);
       return node;
   }

   private TreeNode removeMin(TreeNode node){
       if(node.left == null){
           TreeNode rightNode = node.right;
           node.right = null;
           return rightNode;
       }
       node.left = removeMin(node.left);
       return node;
   }
}