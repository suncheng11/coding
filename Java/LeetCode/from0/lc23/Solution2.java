package lc23;

public class Solution2 {
   public ListNode mergeKLists(ListNode[] lists) {
       if(lists == null || lists.length == 0){
           return null;
       }
       return mergeKLists(lists,0,lists.length-1);
   }

   public ListNode mergeKLists(ListNode[] lists, int start, int end){
       if(start == end){
           return lists[start];
       }
       int mid = start + (end-start)/2;
       ListNode n1 = mergeKLists(lists,start,mid);
       ListNode n2 = mergeKLists(lists,mid+1,end);
       ListNode dummyHead = new ListNode(0);
       ListNode cur = dummyHead;
       while(n1!=null || n2 !=null){
           if(n1 == null || n2!=null && n1.val > n2.val){
               cur.next = n2;
               n2 = n2.next;
           }else{
               cur.next = n1;
               n1 = n1.next;
           }
           cur = cur.next;
       }
       return dummyHead.next;
   }
}