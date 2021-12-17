package com.lifeng.algorithm.dp;

/**
 * @description: 股票收益
 * @author: lifeng
 * @create: 2021-12-17 14:29:25
 **/
public class MaxProfit {
    /**
     * leetcode 121-仅允许操作一次，利润的最大值为卖出股票的时的收益
     * @param prices
     * @return
     */
      public int maxProfit_k_1(int[] prices){
          int n = prices.length;
          int dp_i_0 = 0,dp_i_1 = Integer.MIN_VALUE;
          for(int i=0;i<n;i++){
              dp_i_0 = Math.max(dp_i_0,dp_i_1+prices[i]);
              dp_i_1 = Math.max(-prices[i],dp_i_1);
          }
          return dp_i_0;
      }

    /**
     * leetcode-122 允许买卖多次，需要考虑之前买卖的收益使用temp存储
     * @param prices
     * @return
     */
      public int maxProfit_k_inf(int[] prices){
          int n = prices.length;
          int dp_i_0 = 0,dp_i_1 = Integer.MIN_VALUE;
          for (int i = 0; i <n ; i++) {
              int temp = dp_i_0;
              dp_i_0 = Math.max(dp_i_0,dp_i_1+prices[i]);
              dp_i_1 = Math.max(dp_i_1,temp-prices[i]);
          }
          return dp_i_0;
      }

    /**
     * leetcode309 股票买卖出现冷静期，需要卖出股票的时的收益存储至dp_pre_0
     * @param prices
     * @return
     */
      public int maxProfit_with_cool(int[] prices){
          int n = prices.length;
          int dp_i_0 = 0,dp_i_1 = Integer.MIN_VALUE;
          int dp_pre_0 = 0;//代表dp[i-2][0]
          for (int i = 0; i < n; i++) {
              int temp =  dp_i_0;
              dp_i_0 = Math.max(dp_i_0,dp_i_1+prices[i]);
              dp_i_1 = Math.max(dp_i_1,dp_pre_0-prices[i]);
              dp_pre_0 = temp;
          }
          return dp_i_0;
      }

    /**
     * leetcode714 股票买卖出现手续费，则在计算收益时减去手续费即可
     * @param prices
     * @return
     */
      public int maxProfit_with_fee(int[] prices,int fee){
          int n = prices.length;
          int dp_i_0 = 0,dp_i_1 = Integer.MIN_VALUE;
          for (int i = 0; i <n ; i++) {
              int temp = dp_i_0;
              dp_i_0 = Math.max(dp_i_0,dp_i_1+prices[i]);
              dp_i_1 = Math.max(dp_i_1,temp-prices[i]-fee);
          }
          return dp_i_0;
      }

    /**
     * leetcode-123 限定买股票的次数为2「需要考虑买股票的次数状态」
     * @param prices
     * @return
     */
      public int maxProfit_max_k(int[] prices){
          int n = prices.length;
          int max_k = 2;
          int[][][] dp = new int[n][max_k-1][2];
          for (int i = 0; i < n; i++) {
              for (int k = max_k; k >=1 ; k--) {
                  if(i-1 == -1){
                      dp[0][1][0] = 0;
                      dp[0][2][0] = 0;
                      dp[0][1][1] = Integer.MIN_VALUE;
                      dp[0][2][1] = Integer.MIN_VALUE;
                  }
                  dp[i][k][0] = Math.max(dp[i-1][k][0],dp[i-1][k-1][1]+prices[i]);
                  dp[i][k][1] = Math.max(dp[i-1][k][1],dp[i-1][k-1][0]-prices[i]);
              }
          }
          return dp[n-1][max_k][0];
      }

    /**
     * leetcode-188
     * @param prices
     * @return
     */
    public int maxProfit_k_any(int[] prices,int max_k){
         int n = prices.length;
         if(max_k>n/2){
             return maxProfit_k_inf(prices);
         }
        int[][][] dp = new int[n][max_k-1][2];
        for (int i = 0; i < n; i++) {
            for (int k = max_k; k >=1 ; k--) {
                if(i-1 == -1){
                    dp[0][1][0] = 0;
                    dp[0][2][0] = 0;
                    dp[0][1][1] = Integer.MIN_VALUE;
                    dp[0][2][1] = Integer.MIN_VALUE;
                }
                dp[i][k][0] = Math.max(dp[i-1][k][0],dp[i-1][k-1][1]+prices[i]);
                dp[i][k][1] = Math.max(dp[i-1][k][1],dp[i-1][k-1][0]-prices[i]);
            }
        }
        return dp[n-1][max_k][0];
    }
}
