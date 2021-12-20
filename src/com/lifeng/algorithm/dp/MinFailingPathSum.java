package com.lifeng.algorithm.dp;

import java.util.Arrays;

/**
 * leetcode-931
 * @description: 最小下降路径
 * @author: lifeng
 * @create: 2021-12-20 14:18:56
 **/
public class MinFailingPathSum {
    int[][]memo;
    public int minFalingPathSum(int[][] martrix){
        int n = martrix.length;
        int res = Integer.MAX_VALUE;
        memo = new int[n][n];
        for(int i=0;i<n;i++){
            Arrays.fill(memo[i],66666);
        }
        for (int j = 0; j <n ; j++) {
            res = Math.min(res,dp(martrix,n-1,j));
        }
        return res;
    }
    public int dp(int[][]martix,int i,int j){
        if(i<0 || j<0 || i>=martix.length || j>=martix[0].length){
            return 99999;
        }
        if(memo[i][j]!=66666){
            return memo[i][j];
        }
        memo[i][j] = martix[i][j] + min(dp(martix,i-1,j),dp(martix,i-1,j-1),dp(martix,i-1,j+1));
        return memo[i][j];
    }
    public int min(int a,int b,int c){
        return Math.min(a,Math.min(b,c));
    }
}
