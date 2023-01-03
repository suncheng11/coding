package from200.lc215;

public class Solution2 {
    Random random=new Random();
    public int findKthLargest(int[] nums, int k) {
        return quickSelect(nums,k,0,nums.length-1);
    }

    public int quickSelect(int[] nums, int k,int left, int right ){
        int randomIndex = random.nextInt(right-left+1)+left;
        int flag = nums[randomIndex];
        nums[randomIndex] = nums[right];
        int l = left,r = right;
        while(l<r){
            while( l < r && nums[l] >= flag){
                l++;
            }
            nums[r] = nums[l];
            while(l < r && nums[r] <= flag){
                r--;
            }
            nums[l] = nums[r];
            
        }
        nums[l] = flag;

        if(l == k-1){
            return flag;
        }      

        if(l > k-1){
            return quickSelect(nums,k,left,l-1);
        }
        return quickSelect(nums,k,l+1,right);
    }
}