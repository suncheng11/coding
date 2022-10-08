import java.util.Arrays;

public class Solution307 {

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 4};
        Solution307 solution = new Solution307();
        NumArray numArray = solution.new NumArray(nums);
        int ret = numArray.sumRange(0, 1);
        System.out.println(ret);
        numArray.update(1, 100);
        System.out.println(numArray.sumRange(0, 3));
    }

    class NumArray {

        SegmentTree<Integer> tree;

        public NumArray(int[] nums) {
            Integer[] data = new Integer[nums.length];
            for (int i = 0; i < nums.length; i++) {
                data[i] = nums[i];
            }
            tree = new SegmentTree<Integer>(data, (a, b) -> a + b);
        }

        public void update(int index, int val) {
            tree.update(index, val);
        }

        public int sumRange(int left, int right) {
            return tree.query(left, right);
        }
    }

    class SegmentTree<E> {
        E[] data;
        E[] tree;
        Merger<E> merger;

        public SegmentTree(E[] data, Merger<E> merger) {
            this.data = (E[]) new Object[data.length];
            this.tree = (E[]) new Object[4 * data.length];
            this.merger = merger;
            for (int i = 0; i < data.length; i++) {
                this.data[i] = data[i];
            }
            buildTree();
            System.out.println(Arrays.toString(tree));
        }

        private void buildTree() {
            buildTree(0, 0, data.length - 1);
        }

        /**
         * 建树
         *
         * @param root      树种根节点索引
         * @param dataLeft  数据中的左边界
         * @param dataRight 数据中的右边界
         */
        private void buildTree(int root, int dataLeft, int dataRight) {
            if (dataLeft == dataRight) {
                tree[root] = data[dataLeft];
                return;
            }

            int mid = dataLeft + (dataRight - dataLeft) / 2;
            int treeLeft = getLeft(root);
            int treeRight = getRight(root);

            buildTree(treeLeft, dataLeft, mid);
            buildTree(treeRight, mid + 1, dataRight);

            tree[root] = merger.merge(tree[treeLeft], tree[treeRight]);
        }

        private int getLeft(int root) {
            return 2 * root + 1;
        }

        private int getRight(int root) {
            return getLeft(root) + 1;
        }

        public E query(int dataL, int dataR) {
            return query(0, 0, data.length - 1, dataL, dataR);
        }

        private E query(int treeRoot, int nodeRangeL, int nodeRangeR, int queryL, int queryR) {
            if (nodeRangeL == queryL && nodeRangeR == queryR) {
                return tree[treeRoot];
            }

            int mid = nodeRangeL + (nodeRangeR - nodeRangeL) / 2;
            if (mid >= queryR) {
                return query(getLeft(treeRoot), nodeRangeL, mid, queryL, queryR);
            } else if (queryL > mid) {
                return query(getRight(treeRoot), mid + 1, nodeRangeR, queryL, queryR);
            }

            E leftValue = query(getLeft(treeRoot), nodeRangeL, mid, queryL, mid);
            E rightValue = query(getRight(treeRoot), mid + 1, nodeRangeR, mid + 1, queryR);
            return merger.merge(leftValue, rightValue);
        }

        public void update(int index, E value) {
            data[index] = value;
            update(0, 0, data.length - 1, index, value);
            System.out.println(Arrays.toString(tree));
        }

        private void update(int treeRoot, int nodeRangeL, int nodeRangeR, int updateIndex, E updateValue) {
            if (nodeRangeL == nodeRangeR) {
                tree[treeRoot] = updateValue;
                return;
            }

            int mid = nodeRangeL + (nodeRangeR - nodeRangeL) / 2;
            if (mid >= updateIndex) {
                update(getLeft(treeRoot), nodeRangeL, mid, updateIndex, updateValue);
            } else if (mid < updateIndex) {
                update(getRight(treeRoot), mid + 1, nodeRangeR, updateIndex, updateValue);
            }

            tree[treeRoot] = merger.merge(tree[getLeft(treeRoot)], tree[getRight(treeRoot)]);
        }
    }

    interface Merger<E> {
        E merge(E a, E b);
    }

}
