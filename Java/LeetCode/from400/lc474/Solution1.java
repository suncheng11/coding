package from400.lc474;

/**
 * 3D的方式，重点在于体会思路
 * Solution2中做了降维处理
 */
public class Solution2 {
    public int findMaxForm(String[] strs, int m, int n) {
        int len = strs.length;
        int[][][] dp = new int[len+1][m+1][n+1];
        for(int i=1; i<=len;i++){
            String cur = strs[i-1];
            int cnt0 = 0, cnt1 =0;
            for(char ch : cur.toCharArray()){
                if(ch == '0'){
                    cnt0++;
                }else{
                    cnt1++;
                }
            }
           
            // System.out.println("cur:"+cur+" 0:"+cnt0+" 1:"+cnt1);
            for(int j = 0; j<=m; j++){
                for(int k = 0; k<=n;k++){
                    if(j>=cnt0 && k>=cnt1){
                        dp[i][j][k] = Math.max(
                            dp[i-1][j][k],
                            dp[i-1][j-cnt0][k-cnt1]+1
                        );
                    }else{
                        dp[i][j][k] = dp[i-1][j][k];
                    }
                }
            }
        }

        // for(int[][] table : dp){
        //     printTable(table);
        // }

        return dp[len][m][n];
    }

    private void printTable(int[][] dp){
        for(int[] item: dp){
            System.out.println(Arrays.toString(item));
        }
        System.out.println("--------------------------");
    }
}
