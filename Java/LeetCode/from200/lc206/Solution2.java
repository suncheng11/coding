package from200.lc206;

public class Solution2 {
   public ListNode reverseList(ListNode head) {
       if(head == null || head.next == null){
           return head;
       }

       ListNode next =head.next;
       next = reverseList(next);
       head.next.next = head;
       head.next = null;
       return next;
   }
}
