package lc2;
import java.util.Optional;

import util.ListNode;


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
public class Solution1 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        return carried(l1,l2,0);
    }
    
    public ListNode carried(ListNode l1, ListNode l2, int carry){
        if(l1 == null && l2 == null && carry == 0){
            return null;
        }
        ListNode ret = new ListNode();
        if(l1 != null){
            carry += l1.val;
        }
        if(l2 != null){
            carry += l2.val;
        }
        ret.val = carry % 10;
        ret.next = carried(l1 == null? null : l1.next, l2 == null? null : l2.next, carry /10 );
        return ret;
    } 
}