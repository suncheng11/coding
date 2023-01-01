package datastructure.from1300.lc1328;

public class Solution {
    public String breakPalindrome(String palindrome) {
        if(palindrome == null || palindrome.length()<2){
            return "";
        }
        char[] chars = palindrome.toCharArray();
       
        for(int i = 0; i < chars.length/2; i++){
            if(chars[i]!='a'){
                chars[i] = 'a';
                return new String(chars);
            }
        }
        chars[chars.length-1]+=1;
        return new String(chars);
    }
}