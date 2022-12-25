package lc1019;


/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public int[] nextLargerNodes(ListNode head) {
        if(head == null){
            return new int[]{};
        }
        List<Integer> list = new ArrayList<>();
        ListNode cur = head;
        while(cur != null){
            list.add(cur.val);
            cur = cur.next;
        }
        return nextGreaterElements((Integer[])list.toArray(new Integer[0]));
    }

    public int[] nextGreaterElements(Integer[] nums) {
        if(nums == null || nums.length == 0){
            return new int[]{};
        }
        int n = nums.length;
        Stack<Integer> stack = new Stack<>();
        int[] ret = new int[n];
        for(int i = n-1; i>=0; i--){
            while(!stack.isEmpty() && stack.peek() <= nums[i]){
                stack.pop();
            }
            ret[i] = stack.isEmpty()?0:stack.peek();
            stack.push(nums[i]);
        }
        
        return ret;
    }
}