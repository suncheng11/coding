package from100.lc104;

public class Solution {
   public int maxDepth(TreeNode root) {
       int level = 0;
       if(root == null){
           return level;
       }

       Queue<TreeNode> q = new LinkedList<>();
       q.add(root);
       while(!q.isEmpty()){
           level++;
           int size = q.size();
           for(int i = 0; i < size; i ++){
               TreeNode cur = q.poll();
               if(cur.left!=null){
                   q.offer(cur.left);
               }
               if(cur.right!=null){
                   q.offer(cur.right);
               }
           }
       }

       return level;
   }
}
