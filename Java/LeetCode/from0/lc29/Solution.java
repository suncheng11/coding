package lc29;

public class Solution {
    public int divide(int dividend, int divisor) {
        boolean fu = (((dividend >>> 31) ^ (divisor >>> 31)) == 1);
        if(dividend > 0) dividend = -dividend;
        if(divisor > 0) divisor = -divisor;
        int mod = divisor;
        int minn = dividend >> 1;
        int now = -1;
        while(mod >= minn && mod >= (Integer.MIN_VALUE >> 1)) {
            mod <<= 1;
            now <<= 1;
        }
        int ans = 0;
        while(dividend <= divisor){
            while(mod < dividend){
                mod >>= 1;
                now >>= 1;
            }
            while(dividend <= mod) {
                dividend -= mod;
                ans-=now;
            }
        }
        if(ans == -2147483648 && !fu) return 2147483647;
        return fu?-ans:ans;
    }
}