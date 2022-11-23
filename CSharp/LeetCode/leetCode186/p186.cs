public class Solution {
    public void ReverseWords(char[] s) {
        int l = 0;
        for(int i = 0; i < s.Length; i++){
            if(' ' == s[i] || i == s.Length -1){
               reverse(l,i == s.Length-1? i : i-1,s);
               l = i+1;
            }
            
        }

        reverse(0,s.Length-1,s);
    }

    public void reverse(int l, int r, char[] s){
        while(l < r){
            char tmp  = s[l];
            s[l++] = s[r];
            s[r--] = tmp;
        }
    }
}