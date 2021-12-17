package com.lifeng.algorithm.backtrack;

/**
 * @description: leetcode 698 划分为k个相等的子集
 * @author: lifeng
 * @create: 2021-12-17 16:53:10
 **/
public class CanPartitionKSubsets {

    /**
     * 以数的角度装入桶中，每个数字都要选择进入到K个桶中的某一个
     * @param nums
     * @param k
     * @return
     */
    public boolean canPartitionKsets(int[] nums,int k){
        if(k>nums.length){
            return false;
        }
        int sum = 0;
        for (int num:nums){
            sum+=num;
        }
        if(sum % k != 0) return false;
        int[] bucket = new int[k];
        int target = sum/k;
        return backtrack(nums,0,bucket,target);
    }

    public boolean backtrack(int[] nums,int index,int[]bucket,int target){
        if(index == nums.length){
            for (int i = 0; i < bucket.length; i++) {
                if(bucket[i]!=target){
                    return false;
                }
            }
            return true;
        }
        //穷举nums[index]可能装入的桶
        for(int i=0;i<bucket.length;i++){
            //剪枝，桶装满了
            if(bucket[i]+nums[index]>target){
                continue;
            }
            //将nums[index]装入桶中bucket[i]
            bucket[i] +=nums[index];
            if(backtrack(nums,index+1,bucket,target)){
                return true;
            }
            bucket[i]-=nums[index];
        }
        return false;
    }



    /**
     * 以数的角度装入桶中，每个数字都要选择进入到K个桶中的某一个
     * @param nums
     * @param k
     * @return
     */
    public boolean canPartitionKsetsBucket(int[] nums,int k){
        if(k>nums.length){
            return false;
        }
        int sum = 0;
        for (int num:nums){
            sum+=num;
        }
        if(sum % k != 0) return false;
        int target = sum/k;
        boolean[] used = new boolean[nums.length];
        return backtrackbucket(k,0,nums,0,target,used);
    }

    public boolean backtrackbucket(int k,int bucket,int[]nums,int start,int target,boolean[]used){
        if(k==0){
            return true;
        }
        if(bucket==target){
            return backtrackbucket(k-1,0,nums,0,target,used);
        }
        for(int i=start;i<nums.length;i++){
            if(used[i]){
                continue;
            }
            if(nums[i]+bucket>target){
                continue;
            }
            used[i] = true;
            bucket+=nums[i];
            if(backtrackbucket(k,bucket,nums,i+1,target,used)){
                return true;
            }
            used[i] = false;
            bucket-=nums[i];
        }
        return false;
    }
}
