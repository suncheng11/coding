package from300.lc316;

class Solution {
    public String removeDuplicateLetters(String s) {
        int[] last = new int[26];
        for(int i = 0; i < s.length(); i++){
            last[s.charAt(i)-'a']=i;
        }

        Stack<Character> stack = new Stack<>();
        Set<Character> set = new HashSet<>();

        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            if(!set.add(ch)){
                continue;
            }

            while(!stack.isEmpty() 
                    && ch < stack.peek() 
                    && i<last[stack.peek()-'a']){
                set.remove(stack.pop());
            }
            
            stack.push(ch);
        }
        String ret = "";

        while(!stack.isEmpty()){
            ret = stack.pop()+ret;
        }
        return ret;
    }
}