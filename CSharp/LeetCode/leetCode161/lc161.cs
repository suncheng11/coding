public class Solution {
    public bool IsOneEditDistance(string s, string t) {
        int cnt = 0;

        if(s.Length == t.Length){
            for(int i = 0 ;i < s.Length; i ++){
                if(s[i]!=t[i]){
                    cnt++;
                }
                if(cnt >1){
                    return false;
                }
            }
            return cnt == 1;
        }

        string longer;
        string shorter;
        if(s.Length>t.Length){
            longer = s;
            shorter = t;
        }else{
            longer = t;
            shorter = s;
        }

        if(longer.Length - shorter.Length != 1){
            return false;
        }

        if(longer.Length == 1 && shorter.Length == 0){
            return true;
        }

        int buf = 0;
        for(int i = 0 ; i < shorter.Length; i ++){
            if(shorter[i] != longer[i+buf]){
                cnt++;
                if(buf == 0){
                    buf++;
                    i--;
                }
            }
            if(cnt > 1){
                return false;
            }
        }
        return cnt <= 1;
    }
}