/**
 * Definition for singly-linked list.
 * class ListNode {
 *     val: number
 *     next: ListNode | null
 *     constructor(val?: number, next?: ListNode | null) {
 *         this.val = (val===undefined ? 0 : val)
 *         this.next = (next===undefined ? null : next)
 *     }
 * }
 */

 function detectCycle(head: ListNode | null): ListNode | null {
    let fast = head, slow = head;
    while(fast !=null && fast.next != null){
        fast = fast.next.next;
        slow = slow.next;

        if(fast == slow){
            fast = head;
            while(fast!=slow){
                fast = fast.next;
                slow = slow.next;
            }
            return fast;
        }
    }
    return null;
};