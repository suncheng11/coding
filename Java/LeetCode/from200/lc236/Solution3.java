package from200.lc236;

public class Solution3 {
   public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
       if(root == null){
           return null;
       }
       Map<TreeNode,TreeNode> parent = new HashMap<>();
       Queue<TreeNode> queue = new LinkedList<>();

       queue.offer(root);
       while(!queue.isEmpty()){
           TreeNode cur = queue.poll();
           if(cur.left!=null){
               parent.put(cur.left,cur);
               queue.offer(cur.left);
           }
           if(cur.right != null){
               parent.put(cur.right,cur);
               queue.offer(cur.right);
           }
       }

       TreeNode p1 = p;
       Set<TreeNode> set = new HashSet<>();
       set.add(p1);
       while(parent.containsKey(p1)){
           p1 = parent.get(p1);
           set.add(p1);
       }

       TreeNode q1 = q;
       while(q1!=null){
           if(set.contains(q1)){
               return q1;
           }
           q1 = parent.getOrDefault(q1,null);
       }

       return null;
   }
}
