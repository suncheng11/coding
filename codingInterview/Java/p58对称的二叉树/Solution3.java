package p58对称的二叉树;

import utils.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @Classname Solution3
 * @Description TODO
 * @Date 2019/12/28 9:05
 * @Author SonnSei
 */
public class Solution3 {
    /**
     * 笨拙的迭代方法
     * @param root
     * @return
     */
    public boolean isSymmetrical3(TreeNode root) {
        if (root == null) {
            return true;
        }
        ArrayList<ArrayList<Integer>> lists = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size  = queue.size();
            ArrayList<Integer> curLevel= new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode curNode = queue.poll();
                if (curNode != null) {
                    curLevel.add(curNode.val);
                    queue.add(curNode.left);
                    queue.add(curNode.right);
                } else {
                    curLevel.add(null);
                }
            }
            lists.add(new ArrayList<>(curLevel));
        }
        for (ArrayList<Integer> list : lists) {
            if (!symmetric(list)) {
                return false;
            }
        }
        return true;
    }

    /**
     * 检测某个list中的元素是否是对称的
     * @param list
     * @return
     */
    private boolean symmetric(ArrayList<Integer> list) {
        for (int i = 0; i < list.size() / 2; i++) {
            Integer value = list.get(i);
            if (value == null && list.get(list.size() - i - 1) != null) {
                return false;
            }
            if (value!=null && !value.equals(list.get(list.size() - i - 1))) {
                return false;
            }
        }
        return true;
    }
}
