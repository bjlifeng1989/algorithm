package com.lifeng.algorithm.dp;

import java.util.Arrays;

/**
 * @description: 兑换硬币-leetcode322
 * @URL https://leetcode-cn.com/problems/coin-change/
 * @author: lifeng
 * @create: 2021-12-16 10:58:46
 **/
public class CoinChange {

    public static void main(String[] args) {
        int[] coins = {1,2,5};
        int amount = 11;
        System.out.println(coinChange(coins,amount));
    }
    public static int coinChange(int[] coins,int amount){
        //定义dp[i]为，目标金额为i时需要dp[i]个硬币
        int[] dp = new int[amount+1];
        Arrays.fill(dp,amount+1);
        //base case
        dp[0] = 0;
        for(int i=1;i<dp.length;i++){
            for(int j=0;j<coins.length;j++){
                if(i>=coins[j]){
                    dp[i] = Math.min(dp[i],dp[i-coins[j]]+1);
                }
            }
        }
        return (dp[amount]==amount+1)?-1:dp[amount];
    }
}
