class Solution {
    public int maxNumberOfApples(int[] weight) {
        Arrays.sort(weight);
        int sum = 0;
        int ret = 0;
        for(Integer item : weight){
            sum += item;
            if(sum <= 5000){
                ret ++;
            }else{
                break;
            }
        }
        return ret;
    }
}