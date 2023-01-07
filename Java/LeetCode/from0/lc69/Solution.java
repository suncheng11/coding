package lc69;

public class Solution {
    public int mySqrt(int x) {
        if(x == 1){
            return 1;
        }
        return bSearch(x);
    }

    private int bSearch(int x) {
        int left = 1,right = x/2;
        while (left < right) {
            int mid = (left+right+1)>>>1;
            if((long)mid * mid > x)
                right = mid-1;
            else
                left = mid;
        }
        return right;
    }
}