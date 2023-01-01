package from200.lc236;

public class Solution2 {
   TreeNode ret;

   public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
       dfsHasPOrQ(root,p,q);
       return this.ret;
   }

   private boolean dfsHasPOrQ(TreeNode root, TreeNode p, TreeNode q){
       if(root == null){
           return false;
       }
       
       boolean target = root == p || root == q;

       boolean l = dfsHasPOrQ(root.left,p,q);
       boolean r = dfsHasPOrQ(root.right,p,q);


       if(l && r || target && (l || r)){
           ret = root;
       }

       // System.out.println("root:"+root.val + "ret:"+(l||r));

       return l||r || target;
   }
}
