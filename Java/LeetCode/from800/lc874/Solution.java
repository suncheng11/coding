package from800.lc874;

public class Solution {
    public int robotSim(int[] commands, int[][] obstacles) {
        int[][] directions = new int[][]{
            {0,1},
            {-1,0},
            {0,-1},
            {1,0}};
        int x = 0,y = 0;
        int directionIndex = 0;

        // Map<Integer,Set<Integer>> map = new HashMap<>();
        // for(int[] item : obstacles){
        //     Set<Integer> set = map.getOrDefault(item[0],new HashSet<>());
        //     set.add(item[1]);
        //     map.put(item[0],set);
        // }

        Set<Long> set = new HashSet<>();
        for(int[] item : obstacles){
            set.add((long)(item[0]<<16) + item[1]);
        }

        int ret = 0;
        for(int i : commands){
            if(i == -2){
                directionIndex = (directionIndex+1)%4;
                continue;
            }
            if(i == -1){
                directionIndex = (directionIndex+3)%4;
                continue;
            }

            int[] nextPos = getNextXY(x,y,directions[directionIndex],set,i);
            x = nextPos[0];
            y = nextPos[1];
            ret = Math.max(ret,x*x+y*y);
        }
        return ret;
    }

    private int[] getNextXY(int x,int y,int[] moveDirection,Set<Long> set, int move){
            int nextX = x;
            int nextY = y;

            for(int i = 0; i < move; i++){
                nextX+=moveDirection[0];
                nextY+=moveDirection[1];
                if(set.contains((long)(nextX<<16)+nextY)){
                    return new int[]{x,y};
                }
                x = nextX;
                y = nextY;
            }
            
            return new int[]{x,y};
    }
}