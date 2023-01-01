package from1700.lc1710;

public class Solution {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        Arrays.sort(boxTypes,(a,b)->b[1]-a[1]);
        int ret = 0;
        for(int[] item : boxTypes){
            for(int i = 0; i < item[0];i++){
                if(truckSize == 0){
                    return ret;
                }
                truckSize--;
                ret += item[1];
            }
        }
        return ret;
    }
}