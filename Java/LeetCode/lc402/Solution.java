package lc402;

class Solution {
    public String removeKdigits(String num, int k) {
        Stack<Character> stack = new Stack<>();
        int cnt = k;

        for(int i = 0; i < num.length(); i++){
            char ch = num.charAt(i);
            while(!stack.isEmpty() && stack.peek() > ch && cnt>0){
                stack.pop();             
                cnt--;
            }
            stack.push(ch);
        }

        while(cnt-- > 0){
            stack.pop();
        }

        StringBuilder builder = new StringBuilder();
        boolean flag = false;
        for(Character item : stack){
            if(!flag && item == '0'){
                continue;
            }
            builder.append(item);
            flag = true;
        }
       
        return builder.length() == 0? "0" : builder.toString();
    }
}