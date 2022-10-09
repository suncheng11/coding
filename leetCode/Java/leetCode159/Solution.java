package leetCode159;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        if(s == null || s.length() == 0){
            return 0;
        }
        Map<Character,Integer> map  = new HashMap<>();
        int max = 0;

        int left = 0, right = 0;
        while(right < s.length() && map.size()<3){
            char cur = s.charAt(right);
            int cnt = map.getOrDefault(cur,0 );
            map.put(cur, cnt+1);
            while(map.size()>2 && left < right){
                char cur2 = s.charAt(left);
                int cnt2 = map.getOrDefault(cur2,0 );
                map.put(cur2, cnt2-1);
                if(map.get(cur2)<=0){
                    map.remove(cur2);
                }
                left++;
            }
            max = Math.max(right-left+1, max);
            right++;
        }

        return max;
    }
}
