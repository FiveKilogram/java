/*
 * Copyright (c) 2017 maoyan.com
 * All rights reserved.
 *
 */
package tree;

import java.util.LinkedList;

/**
 * 在这里编写类的功能描述
 *
 * @author luweiliang
 * @created 2020/7/14
 */
public class 获取二叉树最下层的第N个元素 {

    /**
     * 思路：层次遍历二叉树，并在遍历时记录下一层的个数和当前的层的个数，
     * 如果当前层的数量为0时，如果下一层的节点数量大于0，则更新value的值为队列中【队首】&【队尾】& 【指定】的值。
     * @param root
     * @return
     */
    public static int findBottomLeftTheNValue(TreeNode root) {
        int value = root.val;
        int last = 1, next = 0;
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {

            TreeNode node = queue.poll();
            if (node.left != null) {
                queue.offer(node.left);
                next ++;
            }
            if (node.right != null) {
                queue.offer(node.right);
                next ++;
            }
            last --;
            if (last == 0) {
                if (next != 0) {
                    //获取二叉树底层的第一个元素(最左边的元素)
                    //value = queue.getFirst().val;

                    //获取二叉树底层的最后一个元素(最右边的元素)
                    //value = queue.getLast().val;

                    //获取二叉树底层的第N个元素，
                    //下标从0开始，queue.get(1).val 是第二个元素
                    value = queue.get(1).val;

                }
                last = next;
                next = 0;
            }
        }
        return value;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(6);
        root.right = new TreeNode(14);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(8);
        root.right.left = new TreeNode(12);
        root.right.right = new TreeNode(16);
        System.out.println(findBottomLeftTheNValue(root));
    }
}