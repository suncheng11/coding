package lc57;

public  class Solution2 {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> ret = new ArrayList<>();
        for(int[] item : intervals){
            if(newInterval == null || item[1]<newInterval[0]){
                ret.add(item);
            }else if(item[0] > newInterval[1]){
                ret.addAll(List.of(newInterval,item));
                newInterval = null;
            }else{
                newInterval[0] = Math.min(item[0],newInterval[0]);
                newInterval[1] = Math.max(item[1], newInterval[1]);
            }
        }
        if(newInterval!=null){
            ret.add(newInterval);
        }

        return ret.toArray(new int[][]{});
    }
}
