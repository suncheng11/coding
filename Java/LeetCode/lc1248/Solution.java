package lc1248;

public class Solution {
    public int numberOfSubarrays(int[] input, int k) {
        int ret = 0, odd = 0;
        int[] sumCnt = new int[input.length+1];
        sumCnt[0] = 1;
        for(int item : input){
            odd += item &1;
            if(odd >=k){
                ret += sumCnt[odd-k];
            }
            sumCnt[odd] += 1;
        }
        return ret;
    }
} 