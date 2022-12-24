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

 function reverseList(head: ListNode | null): ListNode | null {
    let dummyHead = new ListNode();
    let cur = head;
    let next = head;
    while(cur != null){
        next = cur.next;
        cur.next = dummyHead.next;
        dummyHead.next = cur;
        cur = next;
    }

    return dummyHead.next;
};