package from200.lc204;

import java.util.Arrays;

public class Solution {
    public int countPrimes(int n) {
        if(n <= 2){
            return 0;
        }
        int[] isPrime = new int[n+1];
        
        for(int i = 2; i < n; i++){
            if(isPrime[i] == 0){
                for(int j = 2*i; j<n; j+=i){
                    isPrime[j] = 1;
                }
            }
        }

        int cnt = 0;
        for(int i = 2; i < n; i ++){
            if(isPrime[i] == 0){
                cnt++;
            }
        }

        return cnt;
    }
}