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
    public IList<int> PreorderTraversal(TreeNode root) {
        IList<int> ret = new List<int>();

        if(root == null){
            return ret;
        }


        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.Push(root);
        while(stack.Count>0){
            TreeNode tmp = stack.Pop();
            ret.Add(tmp.val);
            if(tmp.right != null){
                stack.Push(tmp.right);
            }
            if(tmp.left != null){
                stack.Push(tmp.left);
            }
        }

        return ret;
    }


    // 解法2
    public IList<int> PreorderTraversal2(TreeNode root) {
        IList<int> ret = new List<int>();

        if(root == null){
            return ret;
        }


        Stack<TreeNode> stack = new Stack<TreeNode>();
        
        TreeNode cur = root;
        while(stack.Count > 0 || cur != null){
            while(cur != null){
                stack.Push(cur);
                ret.Add(cur.val);
                cur = cur.left;
            }
            cur = stack.Pop();
            cur = cur.right;
        }

        return ret;
    }
}