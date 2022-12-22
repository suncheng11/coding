package lc243;

import java.util.HashSet;

public class Solution {
    public int shortestDistance(String[] wordsDict, String word1, String word2) {
        String[] strs = new String[]{word1,word2};
        int prePos = 0;
        int min = Integer.MAX_VALUE;
        int index = 0;
        for(int i = 0 ;i < wordsDict.length; i++){
            String cur = wordsDict[i];
            if(cur.equals(word1)){
                prePos = i;
                index = 1;
                break;
            }
            if(cur.equals(word2)){
                prePos = i;
                index=0;
                break;
            }
        }

        for(int i = prePos+1; i < wordsDict.length; i ++){
            if(strs[(index+1)%2].equals(wordsDict[i])){
                prePos = i;
            }
            if(strs[index%2].equals(wordsDict[i])){
                min = Math.min(i-prePos,min);
                prePos = i;
                index++;
            }
        }

        return min;
    }
}
