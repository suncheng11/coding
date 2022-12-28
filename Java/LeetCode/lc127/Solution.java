package lc127;

public class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> set = new HashSet<>(wordList);
        Queue<String> q = new LinkedList<>();
        int cnt = 1;
        q.add(beginWord);
        while(!q.isEmpty()){
            int size = q.size();
            for(int i = 0; i < size;i++){
                String s = q.poll();
                if(s.equals(endWord)){
                    return cnt;
                }
                for(int j = 0; j < s.length(); j++ ){
                    StringBuilder builder = new StringBuilder(s);
                    for(int ch = 'a'; ch<='z'; ch++){
                        char c = (char)ch;
                        builder.setCharAt(j,c);
                        if(!set.contains(builder.toString())){
                            continue;
                        }
                        q.offer(builder.toString());
                        //如果不remove，就会再两层之间反复横跳
                        set.remove(builder.toString());
                    }
                }
            }
            cnt++;
        }

        return 0;
        // 找不到的时候才来到这个地方
        // return cnt;
    }
}