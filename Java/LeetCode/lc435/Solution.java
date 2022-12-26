package lc435;

public class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals,(a,b)->a[1]-b[1]);

        int cnt = 0, end = Integer.MIN_VALUE;
        for(int[] item : intervals){
            if(item[0] >= end){
                end = item[1];
            }else{
                cnt ++;
                // end = Math.max(end,item[1]);
            }
        }
        return cnt;
    }
}