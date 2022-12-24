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

 function reverseKGroup(head: ListNode | null, k: number): ListNode | null {
    if(lessThanK(head,k)){
        return head;
    }

    let cur = head;
    let next;

    let dummyHead = new ListNode();

    let tail;

    for(let i = 0; i < k; i ++){
        if(tail == null){
            tail = cur;
        }
        next = cur.next;
        cur.next = dummyHead.next;
        dummyHead.next = cur; 
        cur = next;
    }

    tail.next = reverseKGroup(next,k);
    return dummyHead.next;
};

function lessThanK(head:ListNode|null , k:number) : boolean{
    let cur = head;
    let cnt = 0;
    while(cur !=null){
        cnt++;
        cur = cur.next;
        if(cnt >=k){
            return false;
        }
    }
    return true;
}