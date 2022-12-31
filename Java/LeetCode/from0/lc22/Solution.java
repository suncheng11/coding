package from0.lc22;

public class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> ret = new ArrayList<>();
        backtrack(0,0,n,new StringBuilder(),ret);
        return ret;
    }

    private void backtrack(int left, int right, int n, StringBuilder builder, List<String> ret){
        if(left == n && right == n){
            ret.add(builder.toString());
            return;
        }

        if(left<n){
            builder.append("(");
            backtrack(left+1,right,n,builder,ret);
            builder.deleteCharAt(builder.length()-1);
        }

        if(right<left){
            builder.append(")");
            backtrack(left,right+1,n,builder,ret);
            builder.deleteCharAt(builder.length()-1);
        }
    }
}