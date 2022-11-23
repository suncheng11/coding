public class Solution {
    public int ShortestDistance(string[] wordsDict, string word1, string word2) {
        int index1 = -1, index2 = -1;
        int ret = 30000;
        for(int i = 0; i < wordsDict.Length; i ++){
            string cur = wordsDict[i];
            if(cur != word1 && cur != word2){
                continue;
            }
            if(cur == word1){
                index1 = i;
            }
            if(cur == word2){
                index2 = i;
            }
            if(index1 >=0 && index2 >=0){
                ret = Math.Min(Math.Abs(index1-index2),ret);
            }
        }
        return ret;
    }
}