package lc102;

public class Solution {
   public List<List<Integer>> levelOrder(TreeNode root) {
       List<List<Integer>> ret = new ArrayList<>();
       return dfs(root,ret,0);
   }
   private List<List<Integer>> dfs(TreeNode root, List<List<Integer>> ret, int height){
       if(root == null){
           return ret;
       }
       if(height >= ret.size()){
           ret.add(new ArrayList<Integer>());
       }

       List<Integer> level = ret.get(height);
       level.add(root.val);
       dfs(root.left,ret,height+1);
       dfs(root.right,ret,height+1);
       return ret;
   }
}
