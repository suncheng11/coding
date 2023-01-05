package from100.lc130;

public class Solution2 {
    static int[][] moves = new int[][]{
        {-1,0},{1,0},{0,1},{0,-1}
    };
    
    public void solve(char[][] board) {
        if(board.length <3 || board[0].length < 3){
            return ;
        }
        int n = board.length, m = board[0].length;

        for (int i = 0; i < n; i++) {
            recursive(board, i, 0);
            recursive(board, i, m - 1);
        }
        for (int i = 1; i < m - 1; i++) {
            recursive(board, 0, i);
            recursive(board, n - 1, i);
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == 'A') {
                    board[i][j] = 'O';
                } else if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
            }
        }
    }
    private void recursive(char[][] board,int x, int y){
        int n = board.length, m = board[0].length;
        
        if(!inBorder(x,y,board)|| board[x][y] != 'O' ){
            return;
        }

        board[x][y] = 'A';
        for(int[] move : moves){
            recursive(board,x+move[0], y+move[1]);
        }
    }

    private boolean inBorder(int row, int col, char[][] board){
        int n = board.length, m = board[0].length;
        if(row < 0 || row > n -1){
            return false;
        }
        if( col < 0 || col > m -1){
            return false;
        }
        return true;
    }
} 