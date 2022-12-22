package lc542;

import java.util.Queue;

public class Solution {
    static int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public int[][] updateMatrix(int[][] mat) {

        int m = mat.length;
        int n = mat[0].length;

        int[][] dist = new int[m][n];
        boolean[][] visited = new boolean[m][n];

        Queue<int[]> queue = new LinkedList<>();

        for(int i = 0; i < m; i ++){
            for(int j = 0; j < n; j++){
                if(mat[i][j] == 0){
                    queue.offer(new int[]{i,j});
                    visited[i][j] = true;
                }
            }
        }

        while(!queue.isEmpty()){
            int[] node = queue.poll();
            int i = node[0],j = node[1];
            for(int d= 0; d < 4; d++){
                int nextI = i + dirs[d][0];
                int nextJ = j + dirs[d][1];

                if(nextI >=0 && nextI < m && nextJ >=0 && nextJ < n && !visited[nextI][nextJ]){
                    dist[nextI][nextJ] = dist[i][j] +1;
                    queue.offer(new int[]{nextI,nextJ});
                    visited[nextI][nextJ] = true;
                }
            }
        }

        return dist;
    } 
}
