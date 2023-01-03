package from2000.lc2042;

public class Solution {
    public boolean areNumbersAscending(String str) {
        int max = 0;
        for(String s : str.split(" ")){
            if(s.charAt(0)>='0' && s.charAt(0)<='9'){
                int cur = Integer.parseInt(s);
                if(cur<=max){
                    return false;
                }
                max = cur;
            }
        }
        return true;
    }
}