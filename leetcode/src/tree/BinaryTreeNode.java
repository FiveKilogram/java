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
public class BinaryTreeNode {

    public String data;

    public BinaryTreeNode left;

    public BinaryTreeNode right;

    public BinaryTreeNode(String data, BinaryTreeNode left, BinaryTreeNode right) {
        this.data = data;
        this.left = left;
        this.right = right;
    }
}
