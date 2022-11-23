/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * interface NestedInteger {
 *
 *     // Constructor initializes an empty nested list.
 *     public NestedInteger();
 *
 *     // Constructor initializes a single integer.
 *     public NestedInteger(int value);
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     bool IsInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     int GetInteger();
 *
 *     // Set this NestedInteger to hold a single integer.
 *     public void SetInteger(int value);
 *
 *     // Set this NestedInteger to hold a nested list and adds a nested integer to it.
 *     public void Add(NestedInteger ni);
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return null if this NestedInteger holds a single integer
 *     IList<NestedInteger> GetList();
 * }
 */
public class Solution {
    public int DepthSum(IList<NestedInteger> nestedList) {
        return DepthSum(nestedList,1);
    }

    public int DepthSum(IList<NestedInteger> nestedList, int depth) {
        int ret = 0;
        foreach(NestedInteger item in nestedList){
            if(item.IsInteger()){
                ret+=depth * item.GetInteger();
            }else{
                ret+=DepthSum(item.GetList(),depth+1);
            }
        }
        return ret;
    }

    //还可以广度优先
    //遇到树形递归的时候，可以从深度优先和广度优先两个方面考虑
}