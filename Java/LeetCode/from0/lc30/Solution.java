package lc30;

public class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> ret = new ArrayList<>();
        int len = words[0].length() * words.length;
        if(len > s.length()){
            return ret;
        }

        Map<String,Integer> map = new HashMap<>();

        for(String key : words){
            map.put(key,map.getOrDefault(key,0)+1);
        }

        int itemLen = words[0].length();

        for(int i = 0; i <= s.length()-len; i++){
            // System.out.println(s.subSequence(i,i+itemLen));
            if(map.containsKey(s.subSequence(i,i+itemLen))){
                if(qualified(s.substring(i,i+len),words[0].length(),map)){
                    ret.add(i);
                }
            }
        }

        return ret;
    }

    private boolean qualified(String s, int itemLen, Map<String,Integer> map){
        Map<String,Integer> cur = new HashMap<>();

        for(int i = 0; i < s.length(); i+=itemLen){
            String key = s.substring(i,i+itemLen);
            cur.put(key,cur.getOrDefault(key,0)+1);
        }

        return cur.equals(map);
    }
}
