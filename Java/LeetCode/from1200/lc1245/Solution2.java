package from1200.lc1245;

/**
 * 相比于Solution1，主要修改了DFS，看起来更简洁
 * 注意，在LC使用全局变量的时候，每次需要重置一下
 */
public class Solution2 {
    private static Integer index = 0;
    private static Integer ret = -1;
    
    public static int treeDiameter(int[][] edges) {
        index = 0;
        ret = -1;
        List<Set<Integer>> map = new ArrayList<>();
        for (int i = 0; i <= edges.length; i++) {
            map.add(new HashSet<>());
        }
        for(int[] e : edges){
            map.get(e[0]).add(e[1]);
            map.get(e[1]).add(e[0]);
        }

        dfs(0,-1,0,map);
        dfs(index,-1,0,map);

        return ret;
    }

    private static void dfs(int from,int pre,int sum,List<Set<Integer>> map) {
        for (Integer item : map.get(from)) {
            if(item == pre){
                continue;
            }
            dfs(item, from,sum+1, map);
        }

        if(sum>ret) {
            ret=sum;
            index=from;
        }
    }
}
