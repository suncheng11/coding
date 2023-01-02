package from1800.lc1801;

public class Solution {
    public int getNumberOfBacklogOrders(int[][] orders) {
        PriorityQueue<int[]> sellBacklog = new PriorityQueue<>((a,b)->a[0]-b[0]);
        PriorityQueue<int[]> buyBacklog  = new PriorityQueue<>((a,b)->b[0]-a[0]);
        PriorityQueue<int[]> q;
        long cnt = 0;
        for(int[] order : orders){
            int price = order[0];
            int amount = order[1];
            q = order[2] == 0? sellBacklog : buyBacklog;
            while(amount >0 && !q.isEmpty() && q.comparator().compare(q.peek(),order)<=0){
                int[] back = q.peek();
                if(back[1] == 0){
                    q.poll();
                    continue;
                }
                if(back[1]>=amount){
                    cnt -= amount;
                    back[1]-=amount;
                    amount = 0;
                }else{
                    amount -= back[1];
                    cnt -= back[1];
                    q.poll();
                }
            }
            if(amount>0){
                cnt += amount;
                q = q == sellBacklog ? buyBacklog:sellBacklog;
                q.add(new int[]{price,amount});
            }
        }
        return (int)(cnt%1000000007);
    }
}