package lc413;

class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        if(nums == null || nums.length < 3){
            return 0;
        }
        int n = nums.length;
        int[] dp = new int[n];
        // Arrays.fill(dp,0);

        for(int i = 2; i < n; i ++){
            if(nums[i]-nums[i-1] == nums[i-1]-nums[i-2]){
                dp[i] = dp[i-1]+1;
            }
        }

        int ret = 0;
        for(Integer i : dp){
            ret += i;
        }
        return ret;
    }
}