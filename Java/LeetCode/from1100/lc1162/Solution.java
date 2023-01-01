package lc1162;

import java.util.Queue;

public class Solution {
    int[][] map = new int[][]{{-1,0},{1,0},{0,-1},{0,1}};

    public int maxDistance(int[][] grid) {
        int ret = -1;
        int m = grid.length;
        int n = grid[0].length;

        boolean[][] visited = new boolean[m][n];
        int[][] distance = new int[m][n];
        Queue<int[]> queue = new LinkedList<>();

        init(grid,visited,queue);

        while(!queue.isEmpty()){
            int[] node = queue.poll();
            int row = node[0], col = node[1];
            for(int d = 0 ;d < 4; d++){
                int nextRow = row + map[d][0];
                int nextCol = col + map[d][1];
                if(nextRow >=0 && nextRow < m 
                    && nextCol >=0 && nextCol < n
                    && !visited[nextRow][nextCol]){
                        distance[nextRow][nextCol] = distance[row][col] +1;
                        queue.offer(new int[]{nextRow,nextCol});
                        visited[nextRow][nextCol] = true;
                        ret = Math.max(distance[nextRow][nextCol],ret);
                    }
            }
        }
        

        return ret;
    } 

    private void init(int[][] grid,boolean[][] visited, Queue<int[]> queue){
        for(int i = 0; i < grid.length; i ++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == 1){
                    queue.offer(new int[]{i,j});
                    visited[i][j] = true;
                }
            }
        }
    }
}
