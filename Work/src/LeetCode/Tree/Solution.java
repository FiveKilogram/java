package LeetCode.Tree;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class Solution {
    public boolean isSymmetric(TreeNode root) {
        return isMirror(root.right,root.left);
    }

    public boolean isMirror(TreeNode t1, TreeNode t2){
        if(t1==null&&t2==null){
            return true;
        }
        if(t1==null||t2==null){
            return false;
        }
        return (t1.val==t2.val)&&isMirror(t1.left,t2.right)&&isMirror(t1.right,t2.left);
    }


    public List<Integer> inorderTraversal(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> list = new LinkedList<>();
        while (root!=null||!stack.isEmpty()){
            while (root!=null){
                stack.push(root);
                root = root.left;
            }
            if(!stack.isEmpty()){
                root = stack.pop();
                list.add(root.val);
                root = root.right;
            }

        }
        return list;
    }



    public List<Integer> postorderTraversal2(TreeNode root) {
        List<Integer> output = new LinkedList<>();
        inorderTraversalCore(output,root);
        return output;
    }

    public void inorderTraversalCore(List list, TreeNode root){
        if(root!=null){
            postorderTraversal2(root.right);
            postorderTraversal2(root.left);
            list.add(root);
        }
    }

    public List<Integer> postorderTraversal(TreeNode root) {
       // LinkedList<TreeNode> stack = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();
        LinkedList<Integer> output = new LinkedList<>();
        if (root == null) {
            return output;
        }
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            output.addFirst(node.val);
            if (node.left != null) {
                stack.push(node.left);
            }
            if (node.right != null) {
                stack.push(node.right);
            }
        }
        return output;
    }


}
