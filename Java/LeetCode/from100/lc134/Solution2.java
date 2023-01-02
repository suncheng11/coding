package from100.lc134;

public class Solution2 {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int finalRemain  = 0, minRemainIndex = 0, minRemain = Integer.MAX_VALUE;

        int[] remains = new int[gas.length];
        for(int i = 0; i < gas.length; i++){
            remains[i] = gas[i] - cost[i];
        }

        for(int i = 0; i < remains.length; i++){
            finalRemain += remains[i];
            if(finalRemain < minRemain){
                minRemain = finalRemain;
                minRemainIndex = i;
            }
        }

        return finalRemain<0?-1:(minRemainIndex+1)%remains.length;
    }
}