package from200.lc297;

public /**
* Definition for a binary tree node.
* public class TreeNode {
*     int val;
*     TreeNode left;
*     TreeNode right;
*     TreeNode(int x) { val = x; }
* }
*/
public class Codec {

   private static final String SIGN = "%";

   // Encodes a tree to a single string.
   public String serialize(TreeNode root) {
       List<String> list = new ArrayList<>();
       serialize(root,"root",list);
       StringBuilder builder = new StringBuilder();
       for(String item : list){
           builder.append(item);
       }
       return builder.toString();
   }

   private void serialize(TreeNode root, String prefix, List<String> ret){
       
       if(root == null){
           return;
       }
       ret.add(prefix+SIGN+root.val+""+SIGN);

       if(root.left !=null){
           serialize(root.left,prefix+"l",ret);
       }
       if(root.right != null){
           serialize(root.right,prefix+"r",ret);
       }
   }

   // Decodes your encoded data to tree.
   public TreeNode deserialize(String data) {
       if(data == null || data.trim().length() == 0){
           return null;
       }
       String[] values = data.split(SIGN);
       if(values.length == 0){
           return null;
       }   

       Map<String,TreeNode> map = new HashMap<>();
       for(int i = 0; i < values.length; i++){
           String prefix = values[i++];
           String valueStr = values[i];
           map.put(prefix,new TreeNode(Integer.parseInt(valueStr)));
       }

       for(String prefix : map.keySet()){
           if("root".equals(prefix)){
               continue;
           }
           TreeNode cur = map.get(prefix);
           TreeNode parent = map.get(prefix.substring(0,prefix.length()-1));
           
           if(prefix.charAt(prefix.length()-1) == 'r'){
               parent.right = cur;
           }else{
               parent.left = cur;
           }
       }
       
       return map.get("root");
   }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));