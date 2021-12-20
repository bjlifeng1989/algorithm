package com.lifeng.algorithm.bfs;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @description: BFS应用-二叉树的最小高度
 * @author: lifeng
 * @create: 2021-12-20 15:26:36
 **/
public class Bfs {
    public int minDepth(TreeNode root){
        if(root==null){
            return 0;
        }
        Queue<TreeNode> q = new LinkedList<>();
        int depth = 1;
        while(!q.isEmpty()){
            TreeNode cur= q.poll();
            if(cur.left == null && cur.right ==null){
                return depth;
            }
            if(cur.left!=null){
                q.offer(cur.left);
            }
            if(cur.right!=null){
                q.offer(cur.right);
            }
            depth++;
        }
        return depth;
    }

}
 class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
  }
