package codingInterview.solution06;

import java.util.ArrayList;
import java.util.List;

/**
 * 输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。
 */
public class Solution1 {

    public int[] reversePrint(ListNode head) {
        List<Integer> retList = new ArrayList<>();

        reversePrint(head, retList);

        int[] ret = new int[retList.size()];
        for (int i = 0; i < retList.size(); i++) {
            ret[i] = retList.get(i);
        }
        return ret;
    }

    private void reversePrint(ListNode node, List<Integer> list) {
        if (node == null) {
            return;
        }
        if (node.next != null) {
            reversePrint(node.next, list);
        }
        list.add(node.val);
    }
}
