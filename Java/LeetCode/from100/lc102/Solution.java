package lc102;

public class Solution {
   public List<List<Integer>> levelOrder(TreeNode root) {
       List<List<Integer>> ret = new ArrayList<>();
       if(root == null){
           return ret;
       }

       Queue<TreeNode> q = new LinkedList<>();
       q.add(root);
       while(!q.isEmpty()){
           List<Integer> layer = new ArrayList<>();
           int size = q.size();
           for(int i = 0; i< size; i ++){
               TreeNode cur = q.poll();
               layer.add(cur.val);
               if(cur.left !=null){
                   q.add(cur.left);
               }
               if(cur.right !=null){
                   q.add(cur.right);
               }
           }
           ret.add(layer);
       }

       return ret;
   }
}
