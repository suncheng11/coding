package lc253;

public class Solution {
    public int minMeetingRooms(int[][] intervals) {
        List<int[]> list = new ArrayList<>();
        for(int[] item : intervals){
            list.add(new int[]{item[0],1});
            list.add(new int[]{item[1],-1});
        }
        list.sort((a,b)->{
            if(a[0] == b[0]){
                return a[1] - b[1];
            }
            return a[0]-b[0];
        });

        int ret = 0, cnt = 0;
        
        for(int[] item : list){
            ret = Math.max(ret,cnt = cnt + item[1]);
        }
        return ret;
    }
}
