public class Solution {
    public int[] AnagramMappings(int[] nums1, int[] nums2) {
        Dictionary<int,int> map = new Dictionary<int,int>();

        for(int i = 0; i < nums2.Length; i++){
            if(!map.ContainsKey(nums2[i])){
                map.Add(nums2[i],i);
            }  
        }
        int[] ret = new int[nums1.Length];
        for(int i = 0; i < nums1.Length; i++){
            ret[i] = map[nums1[i]];
        }
        return ret;
    }
}