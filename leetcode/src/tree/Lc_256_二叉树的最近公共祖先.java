/*
 * Copyright (c) 2017 maoyan.com
 * All rights reserved.
 *
 */
package tree;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

/**
 * 二叉树的最近公共祖先
 * 算法：
 * 从根节点开始遍历树。
 * 在找到 p 和 q 之前，将父指针存储在字典中。
 * 一旦我们找到了 p 和 q，我们就可以使用父指针字典获得 p 的所有祖先，并添加到一个称为祖先的集合中。
 * 同样，我们遍历节点 q 的祖先。如果祖先存在于为 p 设置的祖先中，这意味着这是 p 和 q 之间的第一个公共祖先（同时向上遍历），因此这是 LCA 节点。
 * 时间复杂度：O(N)
 * 空间复杂度：O(N)
 * https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-tree/solution/er-cha-shu-de-zui-jin-gong-gong-zu-xian-by-leetcod/
 *
 *
 *
 * 给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
 * 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
 * 例如，给定如下二叉树:  root = [3, 5, 1, 6, 2, 0, 8, null, null, 7, 4]
 * 示例 1:
 * 输入: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1 输出: 3
 * 解释: 节点 5 和节点 1 的最近公共祖先是节点 3。
 * 示例 2:
 * 输入: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
 *      3
 *     / \
 *   -3   9
 *   /   /
 * -10  5
 * @author luweiliang
 * @created 2020/4/26
 */
public class Lc_256_二叉树的最近公共祖先 {

    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q){
        if (root == null || p == null || q == null) return null;

        //定义父节点的map，存储root节点
        Map<TreeNode, TreeNode> parentMap = new HashMap<>();
        parentMap.put(root, null);
        //把root根节点入棧
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        //先序遍历
        while (!parentMap.containsKey(p) || !parentMap.containsKey(q)) {
           TreeNode node = stack.pop();
           if (node.left != null) {
               parentMap.put(node.left, node);
               stack.push(node.left);
           }
           if (node.right != null){
               parentMap.put(node.right, node);
               stack.push(node.right);
           }
        }
        //定义一个祖先的set集合
        Set<TreeNode> ancestorSet = new HashSet<>();
        //使用父指针map中获得p的所有祖先，并添加到一个称为祖先的集合中。
        while (p != null) {
            ancestorSet.add(p);
            p = parentMap.get(p);
        }

        //遍历节点 q 的祖先。如果祖先存在于为 p 设置的祖先中，
        //这意味着这是 p 和 q 之间的第一个公共祖先（同时向上遍历），因此这是 LCA 节点。
        while (!ancestorSet.contains(q)){
            q = parentMap.get(q);
        }
        return q;
    }

    public TreeNode lowestCommonAncestor1(TreeNode root, TreeNode p, TreeNode q) {
        //记录遍历到的每个节点的父节点。
        Map<TreeNode, TreeNode> parent = new HashMap<>();
        Queue<TreeNode> queue = new LinkedList<>();
        parent.put(root, null);//根节点没有父节点，所以为空
        queue.add(root);
        //直到两个节点都找到为止。
        while (!parent.containsKey(p) || !parent.containsKey(q)) {
            //队列是一边进一边出，这里poll方法是出队，
            TreeNode node = queue.poll();
            if (node.left != null) {
                //左子节点不为空，记录下他的父节点
                parent.put(node.left, node);
                //左子节点不为空，把它加入到队列中
                queue.add(node.left);
            }
            //右节点同上
            if (node.right != null) {
                parent.put(node.right, node);
                queue.add(node.right);
            }
        }
        Set<TreeNode> ancestors = new HashSet<>();
        //记录下p和他的祖先节点，从p节点开始一直到根节点。
        while (p != null) {
            ancestors.add(p);
            p = parent.get(p);
        }
        //查看p和他的祖先节点是否包含q节点，如果不包含再看是否包含q的父节点……
        while (!ancestors.contains(q))
            q = parent.get(q);
        return q;
    }

    public static TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q){
        // Stack for tree traversal
        Stack<TreeNode> stack = new Stack<>();
        //定义父节点的map，存储root节点
        Map<TreeNode, TreeNode> parent = new HashMap<>();
        parent.put(root, null);
        stack.push(root);

        // Iterate until we find both the nodes p and q
        while (!parent.containsKey(p) || !parent.containsKey(q)) {

            TreeNode node = stack.pop();

            // While traversing the tree, keep saving the parent pointers.
            if (node.left != null) {
                parent.put(node.left, node);
                stack.push(node.left);
            }
            if (node.right != null) {
                parent.put(node.right, node);
                stack.push(node.right);
            }
        }

        // Ancestors set() for node p.
        Set<TreeNode> ancestors = new HashSet<>();
        // Process all ancestors for node p using parent pointers.
        while (p != null) {
            ancestors.add(p);
            p = parent.get(p);
        }

        // The first ancestor of q which appears in
        // p's ancestor set() is their lowest common ancestor.
        while (!ancestors.contains(q))
            q = parent.get(q);
        return q;
    }

    public TreeNode lowestCommonAncestor3(TreeNode cur, TreeNode p, TreeNode q) {
        // 如果树为空，直接返回null
        // 如果 p和q中有等于 root的，那么它们的最近公共祖先即为root（一个节点也可以是它自己的祖先）
        if (cur == null || cur == p || cur == q) {
            return cur;
        }
        // 递归遍历左子树，只要在左子树中找到了p或q，则先找到谁就返回谁
        TreeNode left = lowestCommonAncestor3(cur.left, p, q);
        // 递归遍历右子树，只要在右子树中找到了p或q，则先找到谁就返回谁
        TreeNode right = lowestCommonAncestor3(cur.right, p, q);
        //如果left为空，说明这两个节点在cur结点的右子树上，我们只需要返回右子树查找的结果即可
        if (left == null) {
            return right;
        }
        //同上
        if (right == null) {
            return left;
        }
        //如果left和right都不为空，说明这两个节点一个在cur的左子树上一个在cur的右子树上，
        //我们只需要返回cur结点即可。
        return cur;
    }

    public static void main(String[] args) {
//        TreeNode root = new TreeNode(1);
//        TreeNode right = new TreeNode(2);
//        root.right = right;
//        TreeNode left = new TreeNode(3);
//        root.left = left;

        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(6);
        root.right = new TreeNode(14);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(8);
        root.right.left = new TreeNode(12);
        root.right.right = new TreeNode(16);

        System.out.println(lowestCommonAncestor(root, root.left.left, root.right).val);

    }
}
