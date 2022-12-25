package lc862;

import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
    public int shortestSubarray(int[] A, int k) {
        int N = A.length, res = N+1;

        long[] sum = new long[N+1];
        for(int i = 0; i < N;i ++){
            sum[i+1] = sum[i]+A[i];
        }

        Deque<Integer> dq = new ArrayDeque<>();

        for(int i = 0; i < N+1; i++){
            while(!dq.isEmpty() && sum[i]-sum[dq.peekFirst()] >= k){
                res = Math.min(res,i-dq.pollFirst());
            }
            while(!dq.isEmpty() && sum[dq.peekLast()] >= sum[i] ){
                dq.pollLast();
            }
            dq.offerLast(i);
        }

        return res <=N ? res:-1;
    }
}
