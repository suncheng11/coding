package lc2500;

class Solution {
    public int deleteGreatestValue(int[][] grid) {
        int ret = 0;
        int rows = grid.length;

        for(int[] row : grid){
            Arrays.sort(row);
        }

        int col = grid[0].length;

        for(int i = 0; i < col; i++){
            int maxValueCol = 0;
            for(int j = 0; j < rows; j++){
                maxValueCol = Math.max(maxValueCol,grid[j][i]);
            }
            ret += maxValueCol;
        }

        return ret;
    }
}
