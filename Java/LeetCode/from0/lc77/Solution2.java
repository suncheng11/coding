package lc77;

public class Solution2 {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> ret = new ArrayList<>();
        List<Integer> item = new ArrayList<>();
        
        recursive(n,k,1,item,ret);
        
        return ret;
    }

    private void recursive(int n, int k, int index, List<Integer> item, List<List<Integer>> ret){
        if(item.size() == k){
            ret.add(new ArrayList<>(item));
            return;
        }
        if(index > n){
            return;
        }
        
        recursive(n,k,index+1,item,ret);
        item.add(index);
        recursive(n,k,index+1,item,ret);
        item.remove(item.size()-1);
    }
}
