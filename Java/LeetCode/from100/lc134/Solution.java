package from100.lc134;

public class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        if(gas.length == 1){
            return gas[0]>=cost[0]?0:-1;
        }
        
        int[] remain = new int[2*gas.length];
        for(int i = 0; i < gas.length; i++){
            remain[i] = gas[i] - cost[i];
            remain[i+gas.length] = remain[i];
        }

        int incStart = 0, incEnd = 0, sum = 0;
        for(int i = 0; i < remain.length; i++){
            if(sum<0){
                sum = 0;
                incStart = i;   
            }
            sum+=remain[i];
            incEnd = i;
        }

        boolean has = incEnd-incStart+1 >= gas.length;
        return has?incStart:-1;
    }
}