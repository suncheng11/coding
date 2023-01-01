package from1200.lc1245;
/**
 * 第一次知道思路之后的解法，一开始用的数组存储的节点关系，但是最后超过内存限制了，改成了map+set存储，AC了但是比较慢
 */
public class Solution {
    public static int treeDiameter(int[][] edges) {
        int n = 0;
        for(int[] e : edges){
            n = Math.max(n,Math.max(e[0],e[1]));
        }
        Map<Integer,Set<Integer>> map = new HashMap<>();
        for(int[] e : edges){
            Set<Integer> set = map.getOrDefault(e[0], new HashSet<>());
            set.add(e[1]);
            map.put(e[0], set);

            set = map.getOrDefault(e[1], new HashSet<>());
            set.add(e[0]);
            map.put(e[1], set);
        }

        int[] p = getLongestIndexAndDistance(map,0,-1);
        p = getLongestIndexAndDistance(map,p[0],-1);
        return p[1];
    }

    public static int[] getLongestIndexAndDistance(Map<Integer,Set<Integer>> map, int startIndex,int pre){
        int distance = 0, index = startIndex;
        if (!map.containsKey(startIndex)) {
            return new int[]{index,distance};

        }
        Set<Integer> friends = map.get(startIndex);

        for(Integer item : friends){
            if(item == startIndex || item == pre){
                continue;
            }
            int[] tmp = getLongestIndexAndDistance(map,item,startIndex);
            if(1+tmp[1] > distance){
                distance = 1+tmp[1];
                index = tmp[0];
            }
        }
        return new int[]{index,distance};
    }
}
