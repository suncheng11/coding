package lc84;
class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<int[]> stack = new Stack<>();
        int ret = 0;
        for(int i = 0; i < heights.length; i++){
            int w = 0;
            while(!stack.isEmpty() && stack.peek()[0] > heights[i]){
                int[] pre = stack.pop();
                w += pre[1];
                ret = Math.max(pre[0]*w,ret);
            }
            stack.push(new int[]{heights[i],w+1});
            // System.out.println(Arrays.toString(stack.peek()));
        }
        int w = 0;
        for(int[] item : stack){
            w+= item[1];
        }

        for(int[] item :stack){
            ret = Math.max(ret,item[0]*w);
            w-=item[1];
        }

        return ret;
    }
}
