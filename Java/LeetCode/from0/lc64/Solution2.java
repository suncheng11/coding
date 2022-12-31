package lc64;

class Solution2 {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int[] dp = new int[n+1];

        for(int i = 1; i <= n; i ++){
            dp[i] = dp[i-1]+grid[0][i-1];
        }

        dp[0] = Integer.MAX_VALUE;
        for(int row = 1; row < m; row ++){
            for(int col = 1; col <= n; col++){
                dp[col] = Math.min(dp[col-1],dp[col])+grid[row][col-1];  
            }
        }

        return dp[n];
    }
}