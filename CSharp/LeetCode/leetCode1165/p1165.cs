public class Solution {
    // public int CalculateTime(string keyboard, string word) {
    //     Dictionary<char,int> map = new Dictionary<char,int>();
    //     for(int i = 0; i < keyboard.Length; i ++){
    //         map.Add(keyboard[i],i);
    //     }

    //     int ret = 0;
    //     int pos = 0;
    //     for(int i = 0; i < word.Length; i++){
    //         int next = map[word[i]];
    //         if(next>pos){
    //             ret += next-pos;
    //         }else{
    //             ret += pos-next;
    //         }
    //         pos = next;
    //     }
    //     return ret;
    // }

    public int CalculateTime(string keyboard, string word) {
        int[] map = new int[26];
        for(int i = 0; i < keyboard.Length; i ++){
            map[keyboard[i]-'a'] =i;
        }

        int ret = 0;
        int pos = 0;
        for(int i = 0; i < word.Length; i++){
            int next = map[word[i]-'a'];
            ret += Math.Abs(pos-next);
            pos = next;
        }
        return ret;
    }
}