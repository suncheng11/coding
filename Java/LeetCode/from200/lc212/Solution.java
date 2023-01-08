package from200.lc212;

import java.util.List;

public class Solution {
    static int[][] moves = new int[][]{
        {1,0},{-1,0},{0,1},{0,-1}
    };

    public List<String> findWords(char[][] board, String[] words) {
        Trie trie = new Trie();
        for(String item : words){
            trie.insert(item);
        }

        Set<String> ret = new HashSet<>();

        int[][] visited = new int[board.length][board[0].length];
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j< board[0].length; j++){
                dfs(i,j,board,visited,new StringBuilder(), trie,ret);
            }
        }
       
        return new ArrayList<>(ret);
    }

    private void dfs(int row, int col, char[][] board, int[][] visited,StringBuilder builder, Trie trie,Set<String> ret){
        char ch = board[row][col];
        builder.append(ch);

        int contains = trie.search(builder.toString());

        if(contains == -1){
             builder.deleteCharAt(builder.length()-1);
            return;
        }

        if(contains > 0){
            ret.add(builder.toString());
        }
        
        visited[row][col] = 1;
       
        for(int[] move : moves){
            int nextRow = row + move[0];
            int nextCol = col + move[1];
            if(nextRow<0 || nextRow >= board.length || nextCol < 0 || nextCol >= board[0].length || visited[nextRow][nextCol] == 1){
                continue;
            }
           
            dfs(nextRow,nextCol,board,visited,builder,trie,ret);

        } 
        builder.deleteCharAt(builder.length()-1);
        visited[row][col] = 0;
    }

    class Node{
        public Node[] next;
        int cnt;

        Node(){
            this.next = new Node[26];
            this.cnt = 0;
        }
    }

    class Trie {
    
        public Node root;
    
        public Trie() {
            this.root = new Node();
        }
        
        public void insert(String word) {
            Node cur = root;
            for(int i = 0; i < word.length(); i++){
                char ch = word.charAt(i);
                if(cur.next[ch-'a'] == null){
                    cur.next[ch-'a'] = new Node();
                }
                cur = cur.next[ch-'a'];
            }
            cur.cnt+=1;
        }
        
        public int search(String word) {
            Node cur = root;
            for(int i = 0; i < word.length(); i++){
                char ch = word.charAt(i);
                if(cur.next[ch-'a'] == null){
                    return -1;
                }
                cur = cur.next[ch-'a'];
            }
            return cur.cnt;
        }
    }
}