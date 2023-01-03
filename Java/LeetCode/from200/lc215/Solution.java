package from200.lc215;

public class Solution {
    public int findKthLargest(int[] nums, int k) {
        if(nums == null || k > nums.length){
            return -1;
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->b-a);
        for(int item : nums){
            pq.add(item);
        }
        for(int i = 0; i <k-1;i++){
            pq.poll();
        }
        return pq.poll();
    }
}