package from400.lc416;

public class Solution {
    public boolean canPartition(int[] nums) {
        if(nums.length == 1){
            return false;
        }

        int sum = Arrays.stream(nums).sum();
        if(sum%2 == 1){
            return false;
        }
        
        boolean[][] dp = new boolean[nums.length+1][sum/2+1];
        for(boolean[] item : dp){
            item[0] = true;
        }

        for(int i = 1; i<= nums.length; i++){          
            for(int j = 1; j<=sum/2; j++){
                dp[i][j] = dp[i-1][j];
                if(j >= nums[i-1]){
                    dp[i][j] = dp[i][j] || dp[i-1][j-nums[i-1]];
                }
            }
        }

        return dp[nums.length][sum/2];
    }
}