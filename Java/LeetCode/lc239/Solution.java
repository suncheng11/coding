package lc239;

class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        Deque<Integer> queue = new ArrayDeque<>();
        int[] ret = new int[n-k+1];
        for(int i = 0; i < nums.length;i++){
            int windowStartIndex = i-k+1;
            while(!queue.isEmpty() && i-queue.peekFirst() >=k){
                queue.pollFirst();
            }
            while(!queue.isEmpty() && nums[queue.peekLast()] < nums[i]){
                queue.pollLast();
            }
            queue.offerLast(i);
            if(windowStartIndex>=0){
                ret[windowStartIndex] = nums[queue.peekFirst()];
            }
        }
        return ret;
    }
}