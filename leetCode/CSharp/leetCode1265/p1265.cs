/**
 * // This is the ImmutableListNode's API interface.
 * // You should not implement it, or speculate about its implementation.
 * class ImmutableListNode {
 *     public void PrintValue(); // print the value of this node.
 *     public ImmutableListNode GetNext(); // return the next node.
 * }
 */

public class Solution {
    // 递归
    // public void PrintLinkedListInReverse(ImmutableListNode head) {
    //     if(head == null){
    //         return;
    //     }
    //     PrintLinkedListInReverse(head.GetNext());
    //     head.PrintValue();
    // }


    //栈
    public void PrintLinkedListInReverse(ImmutableListNode head) {
        //没有类型推断？
        Stack<ImmutableListNode> stack = new Stack<ImmutableListNode>();
        ImmutableListNode cur = head;
        while(cur!=null){
            stack.Push(cur);
            cur = cur.GetNext();
        }

        while(stack.Count > 0){
            stack.Pop().PrintValue();
        }
    }
}