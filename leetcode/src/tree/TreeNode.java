/*
 * Copyright (c) 2017 maoyan.com
 * All rights reserved.
 *
 */
package tree;

/**
 * 在这里编写类的功能描述
 *
 * @author luweiliang
 * @created 2019/10/23
 */
public class TreeNode {

    public int val;

    public TreeNode left;

    public TreeNode right;

    public TreeNode(int val) {
        this.val = val;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
