package from100.lc153;

public class Solution {
    public int findMin(int[] nums) {
        int left = 0, right = nums.length-1;
        return find(nums,left,right);
    }

    private int find(int[] nums, int l, int r){
        while(l < r){
            // System.out.println("left:"+l+" right:"+r);
            int mid = (l+r)>>>1;
            if(nums[mid] > nums[r]){
                l = mid+1;
            }else if(nums[mid] < nums[r]) {
                r = mid;
            }else{
                return nums[r];
            }
        }
        return nums[r];
    }
}