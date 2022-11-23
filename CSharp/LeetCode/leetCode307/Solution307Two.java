public class Solution307Two {

    public static void main(String[] args) {
        int[] nums = new int[]{0,9,5,7,3};
        Solution307Two solution = new Solution307Two();
        Solution307Two.NumArray numArray = solution.new NumArray(nums);

        System.out.println(numArray.sumRange(4,4));
        System.out.println(numArray.sumRange(2,4));
        System.out.println(numArray.sumRange(3,3));
        numArray.update(1,-3);
        numArray.update(0,3);
        numArray.update(0,3);
        System.out.println(numArray.sumRange(0,1));
        numArray.update(1,-3);
        System.out.println(numArray.sumRange(0,1));
        numArray.update(1,-3);

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

    //链式存储
    class SegmentTree<E>{
        class Node<E>{
            //本节点维护的数据范围-左边界
            int nodeRangeL;
            //本节点维护的数据范围-有边界
            int nodeRangeR;
            //节点值
            E value;
            Node<E> leftChild;
            Node<E> rightChild;

            public Node(int nodeRangeL, int nodeRangeR, E value) {
                this.nodeRangeL = nodeRangeL;
                this.nodeRangeR = nodeRangeR;
                this.value = value;
            }
        }

        //链式存储需要维护根节点信息
        Node<E> root;
        //合并函数
        Merge<E> merger;

        public SegmentTree(E[] data,Merge<E> merger) {
            this.merger = merger;
            root = buildTree(data, 0, data.length-1);
        }

        /**
         * 建树操作
         * @param data 原始的数据
         * @param left 节点需要处理的数据范围-左边界
         * @param right 节点需要处理的数据范围-有边界
         * @return 树的根节点
         */
        private Node buildTree(E[] data, int left, int right) {
            //当节点需要处理的元素只有一个时，节点值维护成对应的元素值
            if (left == right) {
                Node node = new Node(left, right, data[left]);
                return node;
            }

            int mid = left + (right-left)/2;
            //tip：关于mid元数据放置在左子树还是右子树这一点，数组存储的方式中是需要和查询逻辑中保持一致的，因为数组存储时，节点维护的数据
            //范围是通过调用时计算并传递的；而在链式存储方式中，节点本身维护了这个信息，所有查询时不再需要计算
            Node<E> leftChild = buildTree(data, left, mid);
            Node<E> rightChild = buildTree(data, mid + 1, right);
            Node node = new Node(left, right, merger.merge(leftChild.value, rightChild.value));
            node.leftChild = leftChild;
            node.rightChild = rightChild;
            return node;
        }

        public E query(int left, int right) {
            return query(root, left, right);
        }

        private E query(Node<E> root, int dataL, int dataR) {
            //当查询已经来到叶子节点时，直接返回节点值
            if (root.nodeRangeL == dataL && root.nodeRangeR == dataR) {
                return root.value;
            }
            //当所有的数据都在左子树中时，可以直接调用查询左子树
            if (dataR <= root.leftChild.nodeRangeR) {
                return query(root.leftChild, dataL, dataR);
            }

            //当所有的数据都在右子树中时，可以直接调用查询右子树
            if (dataL >= root.rightChild.nodeRangeL) {
                return query(root.rightChild, dataL, dataR);
            }

            //当数据范围横跨左右子树时，需要分别获取之后并合并，注意入参中边界的取值
            return merger.merge(query(root.leftChild, dataL, root.leftChild.nodeRangeR), query(root.rightChild, root.rightChild.nodeRangeL, dataR));
        }

        public void update(int index, E val) {
            update(root, index, val);
        }

        private void update(Node<E> root, int index, E val) {
            //更新操作到达叶子节点时，更新节点的值
            if (root.nodeRangeL == root.nodeRangeR) {
                root.value = val;
                return;
            }

            //判断更新操作需要在左子树还是右子树中执行，然后进行相关调用
            if (index <= root.leftChild.nodeRangeR) {
                update(root.leftChild, index, val);
            } else {
                update(root.rightChild, index, val);
            }

            //子树执行过更新操作之后，返回之前顺路维护当前节点的值。
            root.value = merger.merge(root.leftChild.value, root.rightChild.value);
        }
    }

    interface Merge<E>{
        E merge(E a, E b);
    }

}
