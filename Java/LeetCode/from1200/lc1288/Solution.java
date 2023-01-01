package lc1288;

public class Solution {
    public int removeCoveredIntervals(int[][] intervals) {
        if(intervals.length == 1){
            return 1;
        }
        Arrays.sort(intervals,(a,b)->{
            if(a[0]==b[0]){
                //注意这里的顺序，考虑为什么。（cur覆盖next）
                return b[1] - a[1];
            }
            return a[0] - b[0];
        });

        int ret = 0;
        int[] cur = intervals[0];
        for(int i =1; i< intervals.length; i++ ){
            int[] next = intervals[i];
            if(aCoveredByB(next,cur)){
                ret++;
                continue;
            }else{
                cur = next;
            }
        }
        return intervals.length - ret;
    }

    private boolean aCoveredByB(int[] a, int[] b){
        boolean ret = b[0] <= a[0] && a[1] <= b[1];
        System.out.println(ret);
        return ret;
    }
}