package package1.solution121.solution128;

import java.util.HashSet;
import java.util.Set;

public class Solution1 {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int item : nums) {
            set.add(item);
        }

        int ret = 0;
        for (Integer item : set) {
            if (!set.contains(item - 1)) {
                int cur = item;
                int cnt = 1;
                while (set.contains(cur + 1)) {
                    cur++;
                    cnt++;
                }
                ret = Math.max(ret, cnt);
            }
        }
        return ret;
    }
}
