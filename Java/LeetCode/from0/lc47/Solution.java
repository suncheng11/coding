package lc47;

public class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        boolean[] used = new boolean[nums.length];
        List<List<Integer>> ret = new ArrayList<>();
        recursive(nums,0,used,new ArrayList<>(),ret);
        return ret;
    }
    
    private void recursive(int[] nums, int cnt, boolean[] uesd, List<Integer> item, List<List<Integer>> ret){
        if(cnt == nums.length){
            ret.add(new ArrayList<>(item));
            return;
        }

        for(int i = 0; i < nums.length; i++){
            if(uesd[i] || i > 0 && nums[i] == nums[i-1] && !uesd[i-1]){
                continue;
            }
            uesd[i] = true;
            item.add(nums[i]);
            recursive(nums,cnt+1,uesd,item,ret);
            uesd[i] = false;
            item.remove(item.size()-1);
        }
    }
}
