package from100.lc142;

 public class Solution {
   public ListNode detectCycle(ListNode head) {
       ListNode meet = getMeetNode(head);
       if(meet == null){
           return null;
       }
       ListNode n1 = head, n2 = meet;
       while(n1!=n2){
           n1 = n1.next;
           n2 = n2.next;
       }
       return n1;
   }

   private ListNode getMeetNode(ListNode head){
       ListNode slow = head;
       ListNode fast = head;
       while(fast!=null && fast.next!=null){
           fast = fast.next.next;
           slow = slow.next;
           if(fast == slow){
               return fast;
           }
       }
       return null;
   }
}
