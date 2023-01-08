package packageoffer.solution06;

/**
 * 翻转链表
 */
public class Solution2 {

    public int[] reversePrint(ListNode head) {
        if (head == null) {
            return new int[]{};
        }
        if (head.next == null) {
            return new int[]{head.val};
        }

        head = reverseList(head);
        ListNode cntNode = head;
        int cnt = 0;
        while (cntNode != null) {
            cnt++;
            cntNode = cntNode.next;
        }
        int[] ret = new int[cnt];

        int i = 0;
        cntNode = head;
        while (cntNode != null) {
            ret[i++] = cntNode.val;
            cntNode = cntNode.next;
        }
        return ret;
    }

    private ListNode  reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode newHead = reverseList(head.next);
        //这里一定为null
        System.out.println(head.next.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }
}
