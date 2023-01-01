package from200.lc236;

public class Solution {
   public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
       List<List<TreeNode>> list = new ArrayList<>();
       dfs(root,p,q,new ArrayList<>(),list);
       if(list == null || list.size()!=2){
           return null;
       }
       List<TreeNode> t1 = list.get(0);
       List<TreeNode> t2 = list.get(1);
       TreeNode cur = root;
       for(int i = 0; i < t1.size(); i ++){
           if(t2.get(i) == t1.get(i)){
               cur = t1.get(i);
           }else{
               break;
           }
       }
       return cur;
   }
   private void dfs(TreeNode root, TreeNode p,TreeNode q,List<TreeNode> tmp, List<List<TreeNode>> list){
       if(root == null){
           return;
       }
       tmp.add(root);
       if(root == p || root == q){
           list.add(new ArrayList<>(tmp));
       }

       dfs(root.left,p,q,tmp,list);
       dfs(root.right,p,q,tmp,list);
       tmp.remove(tmp.size()-1);
   }
}