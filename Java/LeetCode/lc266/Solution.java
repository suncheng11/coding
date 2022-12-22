package lc266;

import java.util.Arrays;

public class Solution {
    public boolean canPermutePalindrome(String s) {
        Set<Character> set = new HashSet<>();
        for(int i = 0 ;i < s.length();i ++){
            Charcter cur = s.charAt(i);
            if(set.contains(cur)){
                set.remove(cur);
            }else{
                set.add(cur);
            }
        }
        return set.size()<2;
    }

    public boolean canPermutePalindrome2(String s) {
        int[] arr = new int[26];
        Arrays.fill(arr, 0);
        int remain = 0;
        for(int i = 0 ;i < s.length(); i++){
            char cur = s.charAt(i);
            int index = cur-'a';

            if(arr[index] == 0){
                arr[index]++;
                remain++;
            }else{
                arr[index]--;
                remain--;
            }
        }

        return remain < 2;
    }
}
