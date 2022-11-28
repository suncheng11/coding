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

 function addTwoNumbers(l1: ListNode | null, l2: ListNode | null): ListNode | null {
    let dummyHead = new ListNode(0);

    let carry = 0;
    let node1  = l1;
    let node2 = l2;

    let cur = dummyHead;

    while(node1 != null || node2 != null){
        let v1 = node1 == null ? 0 : node1.val;
        let v2 = node2 == null ? 0 : node2.val;

        cur.next = new ListNode((v1+v2+carry)%10, null);
        cur = cur.next;

        carry = Math.floor((v1+v2+carry)/10);

        if(node1 != null){
            node1 = node1.next;
        }
        if(node2 != null){
            node2 = node2.next;
        }
    }

    if(carry > 0){
        cur.next = new ListNode(carry,null);
    }

    return dummyHead.next;
};