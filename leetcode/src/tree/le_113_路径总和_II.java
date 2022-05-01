/*
 * Copyright (c) 2017 maoyan.com
 * All rights reserved.
 *
 */
package tree;

import java.util.*;

//三数之和

/**
 * 给你二叉树的根节点 root 和一个整数目标和 targetSum ，找出所有 从根节点到叶子节点 路径总和等于给定目标和的路径。
 * 叶子节点 是指没有子节点的节点。
 *
 * 示例 1：
 *输入：root = [5,4,8,11,null,13,4,7,2,null,null,5,1], targetSum = 22
 * 输出：[[5,4,11,2],[5,8,4,5]]
 *         5
 *        / \
 *       4   8
 *     /   /  \
 *    7   13   4
 *   11       /  \
 *  /  \     5    1
 * 7    2
 *
 * 示例 2
 * 输入：root = [1,2,3], targetSum = 5
 * 输出：[]
 *
 *      1
 *     / \
 *   2    3
 *
 * 示例 3：
 * 输入：root = [1,2], targetSum = 0
 * 输出：[]
 *
 * @author luweiliang
 * @created 2020/3/26
 */
public class le_113_路径总和_II {

    /**
     * 深度优先算法
     *
     * 时间复杂度：O(N^2)，其中 N 是树的节点数。在最坏情况下，树的上半部分为链状，下半部分为完全二叉树，并且从根节点到每一个叶子节点的路径都符合题目要求。
     * 此时，路径的数目为 O(N)，并且每一条路径的节点个数也为 O(N)，因此要将这些路径全部添加进答案中，时间复杂度为 O(N^2)。
     * 空间复杂度：O(N)，其中 N 是树的节点数。空间复杂度主要取决于栈空间的开销，栈中的元素个数不会超过树的节点数。
     *
     * @param root
     * @param targetSum
     * @return
     */

    public static List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> res = new LinkedList<>();
        if (root == null) return res;

        //深度优先遍历
        //1、root, targetSum传递
        //2、递归终止条件是什么
        //3、结果存放在哪里，一种途中拿到的结果pathList，一种是返回的结果res;

        Deque<Integer> pathList = new LinkedList<>();
        dfs(root, targetSum, 0, res, pathList);
        return res;

    }

    /**
     * 深度优先遍历
     * @param root  需要保证入参root一定不能为空
     * @param sum
     * @param calcSum
     * @param res
     * @param pathList
     */
    private static void dfs(TreeNode root, int sum, int calcSum,  List<List<Integer>> res, Deque<Integer> pathList){
        //需要保证入参root一定不能为空
        //递归的终止条件是啥？？？ 条件就是 root 一定要有叶子节点，只有root是叶子节点的时候才会进行sum 与 calcSum的判断;

        //选择root之后，才有几乎选择root的左、右子节点，最后完成一个跟节点到叶子节点的元素加入到集合中
        calcSum += root.val;
        pathList.addLast(root.val);

        //再来看，是否符合叶子节点
        if (root.left == null && root.right == null) {
            if(sum == calcSum) {
//                ((LinkedList)res).addLast(new ArrayList<>(pathList));
                res.add(new ArrayList<>(pathList));
                return;
            }
        }

        //能来到这里，说明当前root节点还不是叶子节点，就有机会选择左、右子节点
        //选择左子节点
        if (root.left != null) {
            dfs(root.left, sum, calcSum, res, pathList);
            //恢复现场
            pathList.removeLast();
        }
        //选择右子节点
        if (root.right != null) {
            dfs(root.right, sum, calcSum, res, pathList);
            //恢复现场
            pathList.removeLast();
        }
    }

    /**
     * 广度优先算法
     *
     * @param root
     * @param sum
     * @return
     */
    public static List<List<Integer>> pathSum1(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<>();
        //如果节点为空直接返回
        if (root == null)
            return res;
        //使用两个队列，一个存储结点，一个存储从更结点到当前节点的路径
        Queue<TreeNode> queueNode = new LinkedList<>();
        Queue<List<Integer>> queueList = new LinkedList<>();
        //根节点入队
        queueNode.add(root);
        //根节点的路径入队
        List<Integer> list = new ArrayList<>();
        list.add(root.val);
        queueList.add(list);

        while (!queueNode.isEmpty()) {
            //当前节点出队
            TreeNode node = queueNode.poll();
            //当前节点的路径出队
            List<Integer> tempList = queueList.poll();
            if (node.left == null && node.right == null && node.val == sum) {
                //如果满足条件，就把路径存储到res中
                res.add(tempList);
            }
            //左子节点不为空，左子节点和路径入队
            if (node.left != null) {
                tempList.add(node.left.val);
                queueList.add(new ArrayList<>(tempList));
                node.left.val += node.val;
                queueNode.add(node.left);
                tempList.remove(tempList.size() - 1);
            }
            //右子节点不为空，右子节点和路径入队
            if (node.right != null) {
                tempList.add(node.right.val);
                queueList.add(new ArrayList<>(tempList));
                node.right.val += node.val;
                queueNode.add(node.right);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(11);
        root.left.left.left = new TreeNode(7);
        root.left.left.right = new TreeNode(2);
        root.right.left = new TreeNode(13);
        root.right.right = new TreeNode(4);
        root.right.right.left = new TreeNode(5);
        root.right.right.right = new TreeNode(1);

//        TreeNode root = new TreeNode(1);
//        root.left = new TreeNode(2);
//        root.right = new TreeNode(3);
        int target = 22;
        System.out.println(pathSum(root, target));
        System.out.println(pathSum1(root, target));
    }
}