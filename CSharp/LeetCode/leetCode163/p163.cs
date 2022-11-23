public class Solution {
    public IList<string> FindMissingRanges(int[] nums, int lower, int upper) {
        IList<string> ret = new List<string>();
        if(nums == null || nums.Length == 0){
            addItem(lower-1,upper+1,ret);
            return ret;
        }

        addItem(lower-1,nums[0],ret);

        for(int i = 0; i < nums.Length-1; i ++){
            addItem(nums[i],nums[i+1],ret);
        }

        addItem(nums[nums.Length-1],upper+1,ret);

        return ret;
    }

    public void addItem(int low, int high, IList<string> list){     
        int diff = high-low;
        if(diff<=1){
            return;
        }
        if(diff == 2){
            list.Add((low+1)+"");
        }else{
            list.Add((low+1)+"->"+(high-1));
        }
    }
}