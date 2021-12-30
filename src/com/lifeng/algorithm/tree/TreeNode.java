package com.lifeng.algorithm.tree;

/**
 * @description: 树的基本结构
 * @author: lifeng
 * @create: 2021-12-24 16:12:35
 **/
public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
 }

