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

    public IList<IList<int>> FindLeaves(TreeNode root) {
        IList<IList<int>> ret = new List<IList<int>>();

        IList<TreeNode> list1 = new List<TreeNode> ();
        PostOrder(root, list1);


        while(list1.Count>0){
            IList<TreeNode> list2 = new List<TreeNode> ();

            IList<int> row = new List<int>();
            for(int i = 0; i < list1.Count; i++){
                TreeNode cur = list1[i];
                if(isLeaf(cur)){
                    row.Add(cur.val);
                }else{
                    list2.Add(cur);
                }
            }
            ret.Add(row);

            for(int i = list2.Count-1; i >= 0; i--){
                TreeNode cur = list2[i];
                if(isLeaf(cur.left) && isLeaf(cur.right)){
                        cur.left = null;
                        cur.right = null;
                }
            }

            list1 = list2;
        }

        return ret;
    }

    private bool isLeaf(TreeNode node){
        if(node == null){
            return true;
        }
        return node.left == null && node.right == null;
    }

    public void PostOrder(TreeNode root, IList<TreeNode> list){
        if(root == null){
            return;
        }

        PostOrder(root.left, list);
        PostOrder(root.right, list);
        list.Add(root); 
    }
}

/**
高度相同的节点放到一起
**/
public class Solution {
    public IList<IList<int>> FindLeaves(TreeNode root) {
        IList<IList<int>> ret = new List<IList<int>>();
        GetHeight(root,ret);
        return ret;
    }

    public int GetHeight(TreeNode node,IList<IList<int>> list){
        if(node == null){
            return -1;
        }

        int height =  1+Math.Max(GetHeight(node.left,list),GetHeight(node.right,list));

        if(height == list.Count){
            list.Add(new List<int>());
        }
        list[height].Add(node.val);

        return height;
    }
}