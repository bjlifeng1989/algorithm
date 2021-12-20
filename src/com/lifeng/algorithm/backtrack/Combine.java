package com.lifeng.algorithm.backtrack;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @description: 回溯算法-组合问题
 * @author: lifeng
 * @create: 2021-12-20 13:29:07
 **/
public class Combine {
    List<List<Integer>> res = new LinkedList<>();

    public List<List<Integer>> combine(int n,int k){
        LinkedList<Integer> track = new LinkedList<>();
        backtrackCombine(n,k,1,track);
        return res;
    }

    public void backtrackCombine(int n ,int k,int start,LinkedList<Integer> track){
        if(track.size() == k){
            res.add(new ArrayList<>(track));
        }
        for (int i = start; i <= n; i++) {
            track.offerLast(Integer.valueOf(i));
            backtrackCombine(n,k,i+1,track);
            track.removeLast();
        }
    }
}
