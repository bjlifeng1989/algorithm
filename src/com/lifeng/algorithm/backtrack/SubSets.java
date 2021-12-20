package com.lifeng.algorithm.backtrack;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * leetcode-78
 * @description: 回溯算法-子集问题
 * @author: lifeng
 * @create: 2021-12-20 11:24:52
 **/
public class SubSets {

    List<List<Integer>> res = new LinkedList<>();

    public List<List<Integer>> subSets(int[] nums){
        LinkedList<Integer> track = new LinkedList<>();
        backtrackSubsets(nums,0,track);
        return res;
    }

    public void backtrackSubsets(int[] nums,int start,LinkedList<Integer> track){
        res.add(new ArrayList<>(track));
        for(int i=start;i<nums.length;i++){
            track.offerLast(nums[i]);
            backtrackSubsets(nums,i+1,track);
            track.removeLast();
        }
    }
}
