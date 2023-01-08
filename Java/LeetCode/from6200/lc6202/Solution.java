package from6200.lc6202;

public class Solution {
    public String robotWithString(String s) {
        //记录对于位置i，其右边存在的最小的字符
        int[] minRight = new int[s.length()];
        minRight[s.length()-1] = s.charAt(s.length()-1);
        for(int i = s.length()-2;i>=0;i--){
            char cur = s.charAt(i+1);
            minRight[i] = Math.min(cur, minRight[i+1]);
        }

        Stack<Character> stack = new Stack<>();
        StringBuilder builder = new StringBuilder();
        for(int i = 0; i < s.length(); i++){
            char cur = s.charAt(i);
            stack.push(cur);
            while(!stack.isEmpty() && stack.peek()<=minRight[i]){
                builder.append(stack.pop());
            }
        }
        while(!stack.isEmpty()){
            builder.append(stack.pop());
        }

        return builder.toString();
    }
}
