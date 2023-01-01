package from100.lc145;

public class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> ret = new ArrayList<>();

        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        TreeNode last = null;
        
        while(!stack.isEmpty() || cur != null){
            while(cur != null){
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            if(cur.right == null || last == cur.right){
                ret.add(cur.val);
                last = cur;
                cur = null;
            }else{
                stack.push(cur);
                cur = cur.right;
            }
        }

        return ret;
    }
}
