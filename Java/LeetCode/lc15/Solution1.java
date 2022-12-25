package package0.solution15;

import java.util.*;

public class Solution1 {

    public static void main(String[] args) {
        int[] nums = new int[]{0,0,0,0};
        System.out.println(threeSum(nums));
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ret = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length-2; i++) {
            int target = 0 - nums[i];
            for(List<Integer> list :twoSum(nums, i + 1, target)){
                list.add(nums[i]);
                ret.add(list);
            };

            while (i+1 < nums.length  && nums[i + 1] == nums[i]) {
                i++;
            }
        }

        return ret;
    }

    private static List<List<Integer>> twoSum(int[] sortedNums, int start, int target) {
        List<List<Integer>> ret = new ArrayList<>();
        for (int i = start; i < sortedNums.length - 1; i++) {
            for (int j = i+1; j <sortedNums.length ; j++) {
                if (sortedNums[i] + sortedNums[j] == target) {
                    List<Integer> addItem = new ArrayList<>();
                    addItem.add(sortedNums[i]);
                    addItem.add(sortedNums[j]);
                    ret.add(addItem);
                    while (j + 1 < sortedNums.length && sortedNums[j + 1] == sortedNums[j]) {
                        j++;
                    }
                }
            }

            while (i+1 < sortedNums.length  && sortedNums[i] == sortedNums[i + 1]) {
                i++;
            }
        }

        return ret;
    }


}
