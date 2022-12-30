package Java.LeetCode.lc1109;

public class Solution2 {
    public int[] corpFlightBookings(int[][] bookings, int n) {
        int[] nums = new int[n];
        for(int i = 0; i < bookings.length; i++){
            int[] item = bookings[i];
            nums[item[0]-1]+=item[2];
            if(item[1] < n){
                nums[item[1]]-=item[2];
            }
            // System.out.println(Arrays.toString(nums));
        }

        for(int i = 1; i < n; i++){
            nums[i] += nums[i-1];
        }

        return nums;
    }
}
