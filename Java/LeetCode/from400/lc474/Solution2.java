package from400.lc474;

public class Solution2 {
    public int findMaxForm(String[] strs, int m, int n) {
        int len = strs.length;
        int[][] dp = new int[m+1][n+1];
        for(String cur : strs){
            int cnt0 = 0, cnt1 =0;
            for(char ch : cur.toCharArray()){
                if(ch == '0'){
                    cnt0++;
                }else{
                    cnt1++;
                }
            }
           
            for(int j = m; j>=cnt0; j--){
                for(int k = n; k >=cnt1;k--){
                    dp[j][k] = Math.max(
                        dp[j][k],
                        dp[j-cnt0][k-cnt1]+1
                    );
                }
            }
        }
        return dp[m][n];
    }
}
