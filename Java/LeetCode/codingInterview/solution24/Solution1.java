package codingInterview.solution24;

/**
 * 翻转链表
 */
public class Solution1 {
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode newHead = reverseList(head.next);
        //必为null
        System.out.println(head.next.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }
}
