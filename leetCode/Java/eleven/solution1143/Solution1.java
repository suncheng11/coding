package eleven.solution1143;

import java.util.Arrays;

public class Solution1 {
    public static void main(String[] args) {
        Solution1 solution = new Solution1();
        int ret = solution.longestCommonSubsequence("abcddddssde", "abdde");
        System.out.println(ret);
    }
    public int longestCommonSubsequence(String s1, String s2) {
        int[][] memory = new int[s1.length()][s2.length()];
        _initMemory(memory);
        int ret = lcs(s1,s1.length()-1,s2,s2.length()-1,memory);
        for (int[] row : memory) {
            System.out.println(Arrays.toString(row));
        }
        return ret;
    }

    private void _initMemory(int[][] memory){
        for(int i = 0; i < memory.length; i++){
            for(int j = 0; j< memory[i].length; j++){
                memory[i][j] = -1;
            }
        }
    }

    private int lcs(String s1, int n1, String s2, int n2, int[][] memory){
        if(n1 <0 || n2 < 0){
            return 0;
        }
        if(memory[n1][n2] != -1){
            return memory[n1][n2];
        }
        int max;
        if(s1.charAt(n1) == s2.charAt(n2)){
            max = 1+lcs(s1,n1-1,s2,n2-1,memory);

        }else{
            max = Math.max(
                    lcs(s1,n1-1,s2,n2,memory),
                    lcs(s1,n1,s2,n2-1,memory)
            );
        }
        memory[n1][n2] = max;
        return max;
    }
}
