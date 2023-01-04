package lc51;

public class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> ret = new ArrayList<>();
        int[][] map = new int[n][n];
        recursive(map,0,ret);
        return ret;
    }

    private void recursive(int[][] map,int col,List<List<String>> ret){
        if(col >= map.length){
            addToRet(map,ret);
            return;
        }
        for(int row = 0; row < map.length; row++){
            if(!attack(row,col,map)){
                map[row][col] = 1;
                recursive(map,col+1,ret);
                map[row][col] = 0;
            }   
        }
    }

    private boolean attack(int row, int col, int[][] map){
        int[][] moves = new int[][]{
            {-1,-1},{1,-1},{1,1},{-1,1},
            {-1,0}, {1,0}, {0,1},{0,-1}
        };
        
        for(int[] move : moves){
            int x = row+move[0], y= col+move[1];
            
            while(x >=0 && x<map.length && y>=0 && y<map.length){              
                if(map[x][y] == 1){
                    return true;
                }
                x+=move[0];
                y+=move[1];
            }
        }
        return false;
    }

    private void addToRet(int[][]map, List<List<String>> ret){
        List<String> list = new ArrayList<>();
        for(int[] row : map){
            StringBuilder builder = new StringBuilder();
            for(int i : row){
                if(i == 0){
                    builder.append(".");
                }else{
                    builder.append("Q");
                }
            }
            list.add(builder.toString());
        }
        ret.add(list);
    }
}
