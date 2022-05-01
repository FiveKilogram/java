/*
 * Copyright (c) 2017 maoyan.com
 * All rights reserved.
 *
 */
package tree;

/**
 * 重建二叉搜索树
 * 已知一个搜索二叉树后序遍历的数组posArr,请根据posArr,重建出整颗数，返回新建树的头节点
 * O(N * log2 N)
 * @author luweiliang
 * @created 2020/4/18
 */
public class 重建二叉搜索树 {

    public static TreeNode proArrayToBST(int[] array) {
        return proArrayToBST(array, 0 , array.length - 1);
    }
    public static TreeNode proArrayToBST (int[] array, int l, int r) {
        if (l > r) return null;

        TreeNode root = new TreeNode(array[r]);

        if (l == r) return root;

        int m = l - 1;
        int left = l;
        int right = r - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (array[mid] < array[r]) {
                m = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        //left < righth
        //m = r-1
        //l..m      l..r-1;
        //m+1..r-1  r..r-1


        //left > righth
        //m = l-1
        //l..m       l..l-1;
        //m+1..r-1   l..r-1
        root.left = proArrayToBST(array, l, m);
        root.right = proArrayToBST(array, m + 1, r - 1);
        return root;
    }

    public static void main(String[] args) {
//        int[] array = {7,4,9,2,1,3,5,8,11,10,12};
//        int[] preorder = {1, 2, 4, 7, 3, 5, 6, 8};
        int[] array = {-10, -3, 0, 5, 9};
        TreeNode treeNode =  proArrayToBST(array);
        System.out.println(treeNode);

    }
}
