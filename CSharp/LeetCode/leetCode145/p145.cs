/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left;
 *     public TreeNode right;
 *     public TreeNode(int val=0, TreeNode left=null, TreeNode right=null) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
public class Solution {
    public IList<int> PostorderTraversal(TreeNode root) {
        IList<int> ret = new List<int>();
        if(root == null){
            return ret;
        }

        TreeNode cur = root;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode pre = null;
        while(cur != null || stack.Count > 0){
            while(cur != null){
                stack.Push(cur);
                cur = cur.left;
            }
            cur = stack.Pop();
            if(cur.right == null || cur.right == pre){
                ret.Add(cur.val);
                pre = cur;
                cur = null;
            }else{
                stack.Push(cur);
                cur = cur.right;
            }
        }

        return ret;
    }
}