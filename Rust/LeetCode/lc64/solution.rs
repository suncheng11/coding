impl Solution {
    pub fn min_path_sum(grid: Vec<Vec<i32>>) -> i32 {
        let mut dp = vec![0; grid[0].len()+1];

        for i in 1..dp.len(){
            dp[i] = dp[i-1]+grid[0][i-1];
        }

        dp[0] = i32::MAX;
        for row in 1..grid.len(){
            for col in 1..=grid[0].len(){
                dp[col] = dp[col].min(dp[col-1])+grid[row][col-1];    
            }
        }

        dp[grid[0].len()]
    }
}