package from300.lc329;

public class Solution {
    static int max = 0;
    static int[][] moves = new int[][]{
        {1,0},{-1,0},{0,1},{0,-1}
    };

    public int longestIncreasingPath(int[][] matrix) {
        max = 0;
        int[][] record = new int[matrix.length][matrix[0].length];
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[0].length; j++){
                dfs(matrix,i,j,1,record);
            }
        }
        return max;
    }

    private int dfs(int[][] matrix, int row, int col,int cnt, int[][] record){
        int maxNextStep = 0;
        for(int[] move : moves){
            int nextRow = row + move[0];
            int nextCol = col + move[1];
            if(isValid(nextRow,nextCol,matrix) && matrix[nextRow][nextCol] > matrix[row][col]){
                int tmp = 1;
                if(record[nextRow][nextCol] > 0){
                    tmp += record[nextRow][nextCol];
                }else{
                    tmp += dfs(matrix,nextRow,nextCol,cnt+1,record);
                }
                maxNextStep = Math.max(tmp,maxNextStep);
            }
        }
        record[row][col] = maxNextStep;
        max = Math.max(max,cnt+maxNextStep);
        return maxNextStep;
    }

    private boolean isValid(int row, int col, int[][] matrix){
        if(row < 0 || row >= matrix.length || col < 0 || col >= matrix[0].length){
            return false;
        }
        return true;
    }
}