package from400.lc494;

public class Solution2 {
    public int findTargetSumWays(int[] nums, int target) {
        int sum = Arrays.stream(nums).sum();
        if(target > sum || (target+sum)%2 == 1 || target+sum < 0){
            return 0;
        }

        return targetSum01(nums,(target+sum)/2);
    }

    private int targetSum01(int[] nums, int target){
        int n =nums.length;
        int[] dp = new int[target+1];
        dp[0] = 1;
        for(int i = 1; i <= n; i++){
            int num = nums[i-1];
            for(int j = target; j>=0; j--){               
                if(j-num>=0){
                    dp[j] += dp[j-num];
                }
            }
        }
        return dp[target];
    }
}
