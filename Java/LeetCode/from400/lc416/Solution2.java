package from400.lc416;

public class Solution2 {
    public boolean canPartition(int[] nums) {
        if(nums.length == 1){
            return false;
        }

        int sum = Arrays.stream(nums).sum();
        if(sum%2 == 1){
            return false;
        }
        sum = sum/2;
        
        boolean[]dp = new boolean[sum+1];
        dp[0] = true;

        for(int i = 1; i<= nums.length; i++){          
            for(int j = sum; j>0; j--){
                if(j >= nums[i-1]){
                    dp[j] = dp[j] ||dp[j-nums[i-1]];
                }
            }
        }

        return dp[sum];
    }
} 