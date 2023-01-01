package lc1081;

import java.util.HashSet;
import java.util.Stack;

class Solution {
    public String smallestSubsequence(String s) {
        Set<Character> set = new HashSet<>();
        Stack<Character> stack = new Stack<>();
        int[] last = new int[26];
        for(int i = 0; i < s.length();i++){
            last[s.charAt(i)-'a'] = i;
        }

        for(int i = 0 ;i < s.length(); i++){
            char ch = s.charAt(i);
            if(!set.add(ch)){
                continue;
            }

            while(!stack.isEmpty() && stack.peek() > ch && last[stack.peek()-'a'] > i){
                set.remove(stack.pop());
            }
            stack.push(ch);
        }

        StringBuilder builder = new StringBuilder();
        for(Character item : stack){
            builder.append(item);
        }

        return builder.toString();
    } 
}
