package lc29;

public class Solution {
    public int divide(int dividend, int divisor) {
        //注意无符号右移
        boolean neg = ((dividend >>> 31) ^ (divisor>>>31)) == 1;

        if(dividend > 0){
            dividend = -dividend;
        }
        if(divisor > 0){
            divisor = - divisor;
        }

        int cnt = 0;
        int tmp = 1;
        int origin = divisor;
        while(dividend <= divisor){
            // System.out.println("dividend:"+dividend+" divisor:"+divisor);
            // System.out.println(divisor );
            // System.out.println((dividend>>1));
            while(divisor > (dividend>>1)){
                divisor += divisor;
                tmp += tmp;
            }

            dividend-=divisor;
            cnt -= tmp;
            tmp = 1;
            divisor = origin;
        }

        if(!neg && cnt == Integer.MIN_VALUE){
            return Integer.MAX_VALUE;
        }
        return neg?cnt:-cnt;
    }
} 