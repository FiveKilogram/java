/*
 * Copyright (c) 2017 maoyan.com
 * All rights reserved.
 *
 */
package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 给定一个二叉树，返回其节点值的锯齿形层次遍历。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。
 * 例如：给定二叉树 [3,9,20,null,null,15,7],

      3
     / \
    9  20
      /  \
     15   7
 返回锯齿形层次遍历如下：
 [
    [3],
    [20,9],
    [15,7]
 ]
 * 时间复杂度 O(n)
 * 空间复杂度：O(n)
 * @author luweiliang
 * @created 2020/5/11
 */
public class Lc_103_二叉树的锯齿形层次遍历 {
    public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        // 记录层数的奇偶性
        int cnt = 0;
        while(! queue.isEmpty()){
            int size = queue.size();
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < size; i ++) {
                TreeNode node = queue.poll();
                // 这里将层数的奇偶性做下判断
                // 如果是偶数层就正向存储（以 0 为起始层）
                if (cnt % 2 == 0){
                    list.add(node.val);
                } else {
                    list.add(0, node.val);
                }
                if (node.left != null){
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            cnt ++;
            res.add(list);
        }
        return res;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(6);
        root.right = new TreeNode(14);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(8);
        root.right.left = new TreeNode(12);
        root.right.right = new TreeNode(16);
        System.out.println(zigzagLevelOrder(root));
    }
}
