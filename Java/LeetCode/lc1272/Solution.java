package lc1272;

public class Solution {
    public List<List<Integer>> removeInterval(int[][] intervals, int[] toBeRemoved) {
        List<List<Integer>> ret = new ArrayList<>();
        for(int[] item : intervals){
            if(item[0]>=toBeRemoved[1] || item[1] <= toBeRemoved[0]){
                ret.add(List.of(item[0],item[1]));
            }
            // 下面这些没必要
            // else if(item[0]>toBeRemoved[0] && item[1] < toBeRemoved[1]){
            //     continue;
            // }
            else {
                if(item[0] < toBeRemoved[0]){
                    ret.add(List.of(item[0],toBeRemoved[0]));
                }
                if(item[1] > toBeRemoved[1] ){
                    ret.add(List.of(toBeRemoved[1],item[1]));
                }
            }
        }
        return ret;
    }
}
