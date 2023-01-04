package lc17;

public class Solution {
    Map<Integer,char[]> map;
    public List<String> letterCombinations(String digits) {
        initMap();
        List<String> ret = new ArrayList<>();
        if(digits == null || digits.length() == 0){
            return ret;
        }
        recursive(digits.toCharArray(),0,new StringBuilder(),ret);
        return ret;        
    }

    public void initMap(){
        map = new HashMap<>();
        map.put(2,new char[]{'a','b','c'});
        map.put(3,new char[]{'d','e','f'});
        map.put(4,new char[]{'g','h','i'});
        map.put(5,new char[]{'j','k','l'});
        map.put(6,new char[]{'m','n','o'});
        map.put(7,new char[]{'p','q','r','s'});
        map.put(8,new char[]{'t','u','v'});
        map.put(9,new char[]{'w','x','y','z'});
    }

    private void recursive(char[] nums, int start,StringBuilder builder, List<String> ret){
        if(start >= nums.length){
            ret.add(builder.toString());
            return;
        }

        int curNum = Integer.parseInt(nums[start]+"");

        char[] chars = map.get(curNum);

        for(int i = 0; i < chars.length ; i++){
            char ch = chars[i];
            builder.append(ch);
            recursive(nums,start+1,builder,ret);
            builder.deleteCharAt(builder.length()-1);
        }
    }
}