package from0.lc50;

public class Solution2 {
    public double myPow(double x, int n0) {
        if(n0 == 0){
            return 1;
        }

        long n = Math.abs((long)n0);
        double ret = 1;
        double tmp = x;

        while(n>0){
            if(n % 2 == 1){
                ret *= tmp;
            }
            tmp *= tmp;
            
            n = n/2;
        }
        
        return n0>0?ret:1/ret;
    }
}