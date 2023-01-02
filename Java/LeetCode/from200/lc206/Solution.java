package from200.lc206;

public class Solution {
   public ListNode reverseList(ListNode head) {
       ListNode dummyHead = new ListNode(0);
       ListNode cur = head;        
       ListNode next;
       while(cur!=null){
           next = cur.next;
           cur.next = dummyHead.next;
           dummyHead.next = cur;
           cur = next;
       }
       return dummyHead.next;
   }
}
