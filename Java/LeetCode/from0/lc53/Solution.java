package lc53;

public class Solution {
    public int maxSubArray(int[] nums) {
        if(nums.length == 1){
            return nums[0];
        }
        int[] preSum = new int[nums.length+1];
        int preMinSum = 0;
        int ret = Integer.MIN_VALUE;
        
        for(int i = 0; i < nums.length; i++){
            preSum[i+1] = nums[i] + preSum[i];
            ret = Math.max(ret,preSum[i+1] - preMinSum);
            preMinSum = Math.min(preMinSum,preSum[i+1]);
        }

        return ret;
    }
}