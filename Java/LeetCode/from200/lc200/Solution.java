package from200.lc200;

public class Solution {
    static int found = 0;
    int[][] moves;
    public int numIslands(char[][] grid) {
        int row = grid.length, col = grid[0].length;
        int[][] map = new int[row][col];
        int ret = 0;

        moves = new int[][]{
            {1,0},
            {-1,0},
            {0,1},
            {0,-1}
        };

        for(int i = 0; i < row; i++){
            for(int j = 0; j<col; j++){
                found = 0;
                dfs(i,j,grid,map);
                // System.out.println("row:"+i+" col:"+j+" found:"+found);
                ret += found==0?0:1;
            }
        }
        return ret;
    }

    private void dfs(int row, int col, char[][] grid,int[][] map){
        if(!valid(row,col,grid,map)){
            return;
        }
        map[row][col] = 1;
        found++;
        for(int[] move :moves){
            dfs(row+move[0],col+move[1],grid,map);
        }      
    }

    private boolean valid(int row, int col, char[][] grid,int[][] map){
        if(row < 0 || row >= map.length){
            return false;
        }
        if(col < 0 || col >= map[0].length){
            return false;
        }
        
        return map[row][col]!=1 && grid[row][col] == '1';
    }
}