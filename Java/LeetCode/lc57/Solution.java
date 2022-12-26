package lc57;

public class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> list = new ArrayList<>();
        for(int[] item : intervals){
            list.add(item);
        }
        list.add(newInterval);
        list.sort((a,b)->a[1]-b[1]);

        return merge(list.toArray(new int[][]{}));
    }

    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals,(a,b)->{
            return a[0] - b[0];
        });

        List<int[]> ret = new ArrayList<>();

        int[] cur = intervals[0];
        for(int[] next : intervals){
            if(cur[1]>=next[0]){
                cur[1] = Math.max(cur[1],next[1]);
            }else{
                ret.add(cur);
                cur = next;
            }
        }
        ret.add(cur);
        return ret.toArray(new int[][]{});
    }
}
