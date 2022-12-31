package from100.lc144;

public class Solution {
   public List<Integer> preorderTraversal(TreeNode root) {
       List<Integer> ret = new ArrayList<>();
       Stack<TreeNode> stack = new Stack<>();
       TreeNode cur = root;
       while(!stack.isEmpty() || cur != null){
           while(cur != null){
               stack.push(cur);
               ret.add(cur.val);
               cur = cur.left;
           }
           
           cur = stack.pop().right;
       }

       return ret;
   }
}