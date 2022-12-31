package lc42;
class Solution {
    public int trap(int[] height) {
        Stack<Integer> stack = new Stack<>();
        int ret = 0;
        for(int i = 0; i < height.length; i++){
            int curHeight = height[i];
            while(!stack.isEmpty() && curHeight > height[stack.peek()]){
                int pre = stack.pop();
                if(stack.isEmpty()){
                    continue;
                }
                int h = Math.min(curHeight, height[stack.peek()])-height[pre];
                ret += h*(i-stack.peek()-1);
            }
            stack.push(i);
        }
        return ret;
    }
}
