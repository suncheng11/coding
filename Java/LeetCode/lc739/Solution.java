package lc739;

class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        if(temperatures ==  null || temperatures.length == 0){
            return new int[]{};
        }

        Stack<Integer> stack = new Stack<>();
        int[] ret = new int[temperatures.length];

        for(int i = temperatures.length-1; i>=0; i--){
            while(!stack.isEmpty() && temperatures[stack.peek()] <= temperatures[i]){
                stack.pop();
            }
            ret[i] = stack.isEmpty()?0:stack.peek()-i;
            stack.push(i);
        }
        return ret;
    }
}