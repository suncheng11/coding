package lc78;

public class Solution2 {
    public List<List<Integer>> subsets(int[] nums) {
        int n = nums.length;
        int total = 1<<n;
        List<List<Integer>> ret = new ArrayList<>();
        List<Integer> list = new ArrayList<>();

        for(int cnt = 0; cnt < total; cnt++){
            list.clear();
            for(int i = 0; i < n; i++){
                if((cnt>>i & 1) == 1){
                    list.add(nums[i]);
                }
            }
            ret.add(new ArrayList<>(list));
        }
        return ret;
    }
}
