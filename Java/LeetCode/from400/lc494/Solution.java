package from400.lc494;

public class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int sum = Arrays.stream(nums).sum();
        if(target > sum || (target+sum)%2 == 1){
            return 0;
        }

        target = (target+sum)/2;
        if(target < 0){
            return 0;
        }

        int n =nums.length;
        int[][] dp = new int[n+1][target+1];
        dp[0][0] = 1;
        for(int i = 1; i <= n; i++){
            int num = nums[i-1];
            for(int j= 0; j<=target; j++){               
                dp[i][j] = dp[i-1][j];
                if(j-num>=0){
                    dp[i][j] += dp[i-1][j-num];
                }
            }
        }
        return dp[n][target];
    }
}
