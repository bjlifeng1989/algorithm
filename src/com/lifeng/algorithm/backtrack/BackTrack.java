package com.lifeng.algorithm.backtrack;

import java.util.LinkedList;
import java.util.List;

/**
 * @description: 回溯算法
 * @author: lifeng
 * @create: 2021-12-17 16:23:42
 **/
public class BackTrack {

    List<List<Integer>> res = new LinkedList<>();
    /*主函数，输入一组不重复的数字，返回它们的全排列*/
    public List<List<Integer>> permute(int[] nums){
        LinkedList<Integer> track = new LinkedList<>();
        backtrack(nums,track);
        return res;
    }
    public void backtrack(int[] nums,LinkedList<Integer> track){
        if(track.size()==nums.length){
            res.add(new LinkedList<>(track));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if(track.contains(nums[i])){
                continue;
            }
            track.add(nums[i]);
            backtrack(nums,track);
            track.removeLast();
        }
    }
}
