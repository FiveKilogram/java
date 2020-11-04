package Offer;


import practice.Tree;
import practice.TreeNode;

import java.util.*;

public class Offer {
    public static void main(String[] args) {


    }

    public boolean IsPopOrder(int [] pushA,int [] popA) {
        if(pushA.length == 0 || popA.length == 0)
            return false;
        Stack<Integer> s = new Stack<Integer>();
        //用于标识弹出序列的位置
        int popIndex = 0;
        for(int i = 0; i< pushA.length;i++){
            s.push(pushA[i]);
            //如果栈不为空，且栈顶元素等于弹出序列
            while(!s.empty() &&s.peek() == popA[popIndex]){
                //出栈
                s.pop();
                //弹出序列向后一位
                popIndex++;
            }
        }
        return s.empty();
    }


    public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> ret = new ArrayList<>();
        if (pRoot == null) return ret;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(pRoot);
        boolean reverse = false;
        while (!queue.isEmpty()) {
            int cnt = queue.size();
            ArrayList<Integer> list = new ArrayList<>();
            for (int i = 0; i < cnt; i++) {
                TreeNode node = queue.poll();
                list.add(node.val);
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }
            if (reverse) Collections.reverse(list);
            reverse = !reverse;
            ret.add(list);
        }
        return ret;
    }


    public List<Double> averageOfLevels(TreeNode root) {
        List list = new ArrayList();
        Queue<TreeNode> queue = new LinkedList<>();
        if(root==null){
            return null;
        }
        queue.add(root);
        while (!queue.isEmpty()){
            int len = queue.size();
            double sum = 0.0;
            for (int i = 0; i < len; i++) {
                TreeNode treeNode = queue.poll();
                sum = sum + treeNode.val;
                if(treeNode.left!=null){
                    queue.add(treeNode.left);
                }
                if(treeNode.right!=null){
                    queue.add(treeNode.right);
                }

            }
            list.add(sum/len);
        }
        return list;
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList();
        Queue<TreeNode> queue = new LinkedList<>();
        if(root==null){
            return list;
        }
        queue.add(root);
        while (!queue.isEmpty()){
            List cur = new ArrayList();
            int len = queue.size();
            for (int i = 0; i < len; i++) {
                TreeNode treeNode = queue.poll();
                if(treeNode.left!=null){
                    queue.add(treeNode.left);
                }
                if(treeNode.right!=null){
                    queue.add(treeNode.right);
                }
                cur.add(treeNode.val);
            }
            list.add(cur);
        }

        return list;
    }


}











