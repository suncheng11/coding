package lc49;

public class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> map = new HashMap<>();
        for(String item : strs){
            char[] chars = item.toCharArray();
            Arrays.sort(chars);
            String key = new String(chars);
            List<String> list = map.getOrDefault(key,new ArrayList<>());
            list.add(item);
            map.put(key,list);
        }

        List<List<String>> ret = new ArrayList<>();
        for(String key : map.keySet()){
            ret.add(map.get(key));
        }
        return ret;
    }
}
