package from6300;

public class Solution {
    public int findCrossingTime(int n, int k, int[][] time) {
        Queue<Integer> leftPending = new PriorityQueue<>((a,b)->{
            if (time[a][0] + time[a][2] != time[b][0] + time[b][2]) {
                return Integer.compare(time[b][0] + time[b][2], time[a][0] + time[a][2]);
            }
            return Integer.compare(b, a);
        });

        Queue<Integer> rightPending = new PriorityQueue<>((a,b)->{
            if (time[a][0] + time[a][2] != time[b][0] + time[b][2]) {
                return Integer.compare(time[b][0] + time[b][2], time[a][0] + time[a][2]);
            }
            return Integer.compare(b, a);
        });
        
        for(int i = 0; i < k; i++){
            leftPending.add(i);
        }

        Queue<int[]> leftWIP = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        Queue<int[]> rightWIP = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        
        int brigeOpen = 0;
        
        int need = n;
        while (need > 0) {
            drainWIP(leftWIP, leftPending, brigeOpen);
            drainWIP(rightWIP, rightPending, brigeOpen);
            if (leftPending.isEmpty() && rightPending.isEmpty()) {
                if (leftWIP.isEmpty()) {
                    brigeOpen = rightWIP.peek()[1];
                } else if (rightWIP.isEmpty()) {
                    brigeOpen = leftWIP.peek()[1];
                } else {
                    brigeOpen = Math.min(leftWIP.peek()[1], rightWIP.peek()[1]);
                }
            } else if (!rightPending.isEmpty()) {
                int w = rightPending.poll();
                brigeOpen += time[w][2];
                leftWIP.add(new int[]{w, brigeOpen + time[w][3]});
            } else {
                int w = leftPending.poll();
                brigeOpen += time[w][0];
                need--;
                rightWIP.add(new int[]{w, brigeOpen + time[w][1]});
            } 
        }

        while (!rightWIP.isEmpty()) {
            int[] worker = rightWIP.poll();
            if (worker[1] > brigeOpen) {
                brigeOpen = worker[1];
            }
            brigeOpen += time[worker[0]][2];
        }
        return brigeOpen;
    }

    private void drainWIP(Queue<int[]> leftWIP, Queue<Integer> leftPending, int brigeOpen) {
        while (!leftWIP.isEmpty() && leftWIP.peek()[1] <= brigeOpen) {
            leftPending.add(leftWIP.poll()[0]);
        }
    }
}
