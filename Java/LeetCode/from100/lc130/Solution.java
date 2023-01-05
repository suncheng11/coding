package from100.lc130;

import java.util.HashSet;

public class Solution {
    static int[][] moves = new int[][]{
        {-1,0},{1,0},{0,1},{0,-1}
    };
    
    public void solve(char[][] board) {
        if(board.length <3 || board[0].length < 3){
            return ;
        }

        int[][] visited = new int[board.length][board[0].length];
        //0-未探索；1-可以出去；-1不可以出去
        int[][] freePoint =new int[board.length][board[0].length];
        for(int row = 1; row < board.length-1; row ++){
            for(int col = 1; col < board[0].length -1; col ++){
                Stack<int[]> stack = new Stack<>();
                recursive(row,col,board,freePoint,stack);
            }
        }

        for(int i = 1; i < board.length-1; i++){
            for(int j = 1; j < board[0].length-1; j++){
                if(board[i][j] == 'O' && freePoint[i][j] == -1){
                    board[i][j] = 'X';
                }
            }
        }
    }
    private void recursive(int row, int col, char[][] board, int[][] freePoint, Stack<int[]> stack){
        
        if(board[row][col] == 'X' || freePoint[row][col] == -1 ){
            return;
        }
        
        if(freePoint[row][col] == 1 || !inBorder(row,col,board)){
            for(int[] item : stack){
                freePoint[item[0]][item[1]] = 1;
            }
            return;
        }

        freePoint[row][col] = -1;
        stack.push(new int[]{row,col});
        for(int[] move : moves){
            recursive(row+move[0], col+move[1], board, freePoint, stack);
        }
        // 注意这里不弹出
        // stack.pop();
        // visited[row][col] = 0;
    }

    private boolean inBorder(int row, int col, char[][] board){
        int n = board.length, m = board[0].length;
        if(row <= 0 || row >= n -1){
            return false;
        }
        if( col <= 0 || col >= m -1){
            return false;
        }
        return true;
    }
} 