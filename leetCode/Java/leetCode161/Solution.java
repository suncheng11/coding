package leetCode161;

class Solution {
    public boolean isOneEditDistance(String s, String t) {
        if(t.length() < s.length()){
            return isOneEditDistance(t, s);
        }

        if(t.length() - s.length() >1){
            return false;
        }

        for(int i = 0; i < s.length(); i ++){
            if(s.charAt(i)!=t.charAt(i)){
                if(s.length() == t.length()){
                    return s.substring(i+1, s.length()).equals(t.substring(i+1, t.length()));
                }else{
                    return s.substring(i, s.length()).equals(t.substring(i+1, t.length()));
                }
            }
        }
        return s.length() != t.length();
    }
}