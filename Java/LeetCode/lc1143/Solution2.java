package lc1143;

import java.util.Arrays;

public class Solution2 {
    public static void main(String[] args) {
        Solution2 solution = new Solution2();

        int ret = solution.longestCommonSubsequence("abcddddssde", "abdde");
        System.out.println(ret);
        System.out.println(solution.longestCommonSubsequence("abced","ace"));
    }
    public int longestCommonSubsequence(String s1, String s2) {
        int[][] memory = new int[s1.length()][s2.length()];
        lcs(s1, s2, memory);
        return memory[s1.length()-1][s2.length()-1];
    }

    private int lcs(String s1,  String s2, int[][] memory){

        for(int row = 0; row < s1.length(); row++){
            if(s1.charAt(row) == s2.charAt(0)){
                for(int i = row; i < s1.length(); i++){
                    memory[i][0]=1;
                }
                break;
            }
        }

        for(int col = 0; col < s2.length(); col++){
            if(s2.charAt(col) == s1.charAt(0)){
                for(int i = col; i < s2.length(); i++){
                    memory[0][i]=1;
                }
                break;
            }
        }


        for(int i = 1; i < s1.length(); i ++){
            for(int j = 1; j < s2.length(); j++ ){
                if(s1.charAt(i) == s2.charAt(j)){
                    memory[i][j] =1+memory[i-1][j-1];
                }else {
                    memory[i][j] =
                            Math.max(memory[i - 1][j], memory[i][j - 1]);
                }
            }
        }
        return memory[s1.length() - 1][s2.length() - 1];
    }
}
