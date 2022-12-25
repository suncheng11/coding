package package0.solution15;

import java.util.*;

public class Solution2 {

    public static void main(String[] args) {
        int[] nums = new int[]{0,0,0,0};
        System.out.println(threeSum(nums));
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ret = new ArrayList<>();

        Set<List<Integer>> set = new HashSet<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length-2; i++) {
            int target = 0 - nums[i];
            for(List<Integer> list :twoSum(nums, i + 1, target)){
                list.add(nums[i]);
                Collections.sort(list);
                set.add(list);
            }
        }

        return new ArrayList<>(set);
    }

    private static List<List<Integer>> twoSum(int[] sortedNums, int start, int target) {
        List<List<Integer>> ret = new ArrayList<>();

        Map<Integer, Integer> map = new HashMap<>();

        for (int i = start; i < sortedNums.length; i++) {
            int cur = sortedNums[i];
            map.put(cur, map.getOrDefault(cur, 0) + 1);
        }

        for (int i = start; i < sortedNums.length; i++) {
            List<Integer> item = new ArrayList<>();
            int cur = sortedNums[i];
            int tar = target - cur;
            if (cur == tar) {
                if (map.getOrDefault(tar, 0) > 1) {
                    item.add(cur);
                    item.add(tar);
                    ret.add(item);
                }
            } else {
                if (map.getOrDefault(tar, 0) > 0) {
                    item.add(cur);
                    item.add(tar);
                    ret.add(item);
                }
            }

        }
        return ret;
    }
}
