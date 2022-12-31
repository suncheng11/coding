package from0.lc50;

public class Solution {
    public double myPow(double x, int n) {
        long n2 = Math.abs((long)n);
        double ret = myPow2(x,n2);
        return n>0?ret:1/ret;
    }

    private double myPow2(double x, long n){
        if(n == 0){
            return 1;
        }
        if(n == 1){
            return x;
        }
        double ret = myPow2(x,n/2);
        ret*=ret;
        if(n%2 == 1){
            ret *= x;
        }
        return ret;
    }

}
