package lc84;

class Solution2 {
    public int largestRectangleArea(int[] heights) {
        Stack<int[]> stack = new Stack<>();
        int ret = 0;
        for(int i = 0; i <= heights.length; i++){
            int h = 0;
            if(i < heights.length){
                h = heights[i];
            }
            int w = 0;
            while(!stack.isEmpty() && stack.peek()[0] > h){
                int[] pre = stack.pop();
                w += pre[1];
                ret = Math.max(pre[0]*w,ret);
            }
            stack.push(new int[]{h,w+1});
        }

        return ret;
    }
}