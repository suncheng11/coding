package from200.lc208;

public class Trie {
    class Node{
        Node[] next;
        int cnt;

        Node(){
            this.next = new Node[26];
            this.cnt = 0;
        }
    }

    private Node root;

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
    
    public boolean search(String word) {
        Node cur = root;
        for(int i = 0; i < word.length(); i++){
            char ch = word.charAt(i);
            if(cur.next[ch-'a'] == null){
                return false;
            }
            cur = cur.next[ch-'a'];
        }
        return cur.cnt > 0;
    }
    
    public boolean startsWith(String prefix) {
        Node cur = root;
        for(int i = 0; i < prefix.length(); i++){
            char ch = prefix.charAt(i);
            if(cur.next[ch-'a'] == null){
                return false;
            }
            cur = cur.next[ch-'a'];
        }
        return cur.cnt > 0 || Arrays.stream(cur.next).anyMatch(x->x!=null);
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */