package lc503;

class Solution {
    public int[] nextGreaterElements(int[] nums) {
        if(nums == null || nums.length == 0){
            return new int[]{};
        }
        int n = nums.length;
        Stack<Integer> stack = new Stack<>();
        int[] ret = new int[n];
        for(int i = n*2-1; i>=0; i--){
            while(!stack.isEmpty() && stack.peek() <= nums[i%n]){
                stack.pop();
            }
            if(i<n){
                ret[i%n] = stack.isEmpty()?-1:stack.peek();
            }
            stack.push(nums[i%n]);
        }
        
        return ret;
    }
}