/*
// Definition for a Node.
public class Node {
    public int val;
    public IList<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, IList<Node> _children) {
        val = _val;
        children = _children;
    }
}
*/

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left;
 *     public TreeNode right;
 *     public TreeNode(int x) { val = x; }
 * }
 */

public class Codec {
    // Encodes an n-ary tree to a binary tree.
    // 右子树全是兄弟，左子树全是孩子
    public TreeNode encode(Node node) {
        if(node == null){
            return null;
        }
        TreeNode ret = new TreeNode(node.val);
        if(node.children.Count()<1){
            return ret;
        }

        ret.left = encode(node.children[0]);

        TreeNode cur = ret.left;
        for(int i = 1; i < node.children.Count(); i++){
            cur.right = encode(node.children[i]);
            cur = cur.right;
        }


        return ret;
    }

    // Decodes your binary tree to an n-ary tree.
    public Node decode(TreeNode node) {
        if(node == null){
            return null;
        }

        Node ret = new Node(node.val,new List<Node>());
        if(node.left != null){
            ret.children.Add(decode(node.left));
            TreeNode cur = node.left;
            while(cur.right !=null){
                cur = cur.right;
                ret.children.Add(decode(cur));
            }
        }

        return ret;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(root));