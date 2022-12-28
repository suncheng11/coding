package lc111;

public class Solution {


    public int minDepth2(TreeNode root) {
        if(root == null){
            return 0;
        }
    
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.add(root);
        int depth = 1;
        while(!q.isEmpty()){
            int size = q.size();
            for(int i = 0; i < size; i++){
                TreeNode cur = q.poll();
                if(cur.left == null && cur.right == null){
                    return depth;
                }
                if(cur.left != null){
                    q.add(cur.left);
                }
                if(cur.right !=null){
                    q.add(cur.right);
                }
            }
            depth++;
        }
        return depth;
    }

   public int minDepth(TreeNode root) {
       if(root == null){
           return 0;
       }
   
       Queue<TreeNode>[] qs = new Queue[2];
       qs[0] = new LinkedList<>();
       qs[1] = new LinkedList<>();

       Queue<TreeNode> q = qs[0];
       qs[1].add(root);

       int cnt = 0;
       while(!qs[0].isEmpty() || !qs[1].isEmpty()){
           if(q.isEmpty()){
               cnt++;
           }
           q = qs[cnt%2];
           
           Queue<TreeNode> next = qs[(cnt+1)%2];
           while(!q.isEmpty()){
               TreeNode cur = q.poll();
               if(cur.left == null && cur.right == null){
                   return cnt;
               }
               if(cur.left != null){
                   next.add((cur.left));
               }
               if(cur.right != null){
                   next.add(cur.right);
               }
           }
       }
       return cnt;
   }
}