package com.lifeng.algorithm.backtrack;

import java.util.LinkedList;
import java.util.List;

/**
 * @description: 回溯算法-全排列问题
 * @author: lifeng
 * @create: 2021-12-20 13:39:27
 **/
public class Permute {
    List<List<Integer>> res = new LinkedList<>();

    public List<List<Integer>> permute(int[]nums){
        LinkedList<Integer> track = new LinkedList<>();
        backtrack(nums,track);
        return res;
    }
    public void backtrack(int[]nums,LinkedList<Integer> track){
        if(track.size() == nums.length){
            res.add(new LinkedList<>(track));
        }
        for (int i = 0; i < nums.length; i++) {
            if(track.contains(nums[i])){
               continue;
            }
            track.offerLast(nums[i]);
            backtrack(nums,track);
            track.removeLast();
        }
    }
}
