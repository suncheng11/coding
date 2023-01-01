package Java.LeetCode.lc1109;

public class Solution {
    public int[] corpFlightBookings(int[][] bookings, int n) {
        int[] seats = new int[n+1];
        for(int[] item : bookings){
            for(int i = item[0]; i <= item[1]; i++){
                seats[i]+=item[2];
            }
        }
        int[] ret = new int[n];
        for(int i = 0; i < n; i ++){
            ret[i] = seats[i+1];
        }
        return ret;
    }
}
