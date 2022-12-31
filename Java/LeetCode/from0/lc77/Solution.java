package lc77;

public class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> ret = new ArrayList<>();
        List<Integer> item = new ArrayList<>();
        for(int i = 0; i < (1<<n); i++){
            if(Integer.bitCount(i) != k){
                continue;
            }
            item.clear();
            for(int j = 0; j<n; j++){
                if(((i>>j)&1) == 1){
                    item.add(j+1);
                }
            }
            ret.add(new ArrayList<>(item));           
        }
        return ret;
    }
}
