public class Solution {
    public int CountLetters(string s) {

        //子串数量就是累加
        int length = s.Length;
        int[] sum = new int[length+1];
        sum[1] = 1;
        for(int i = 2; i <= length; i++){
            sum[i] = sum[i-1]+i;
        }

        
        char cur = ' ';
        int cnt = 0;

        int ret = 0;
        
        for(int i = 0; i < length; i++){
            if(cur != ' ' && cur != s[i]){
                ret += sum[cnt];
                cnt = 1;
            }else{
                cnt ++;
            }
            cur = s[i];
        }

        ret += sum[cnt];

        return ret;
    }
}