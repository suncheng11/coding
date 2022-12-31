package lc78;

public class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ret = new ArrayList<>();

        recursive(nums,0,new ArrayList<>(), ret);

        return ret;
    }

    private void recursive(int[] nums, int index,List<Integer> item, List<List<Integer>> ret){
        if(index >= nums.length){
            ret.add(new ArrayList<>(item));
            return;
        }

        item.add(nums[index]);
        recursive(nums,index+1,item,ret);
        item.remove(item.size()-1);
        recursive(nums,index+1,item,ret);
    }
}