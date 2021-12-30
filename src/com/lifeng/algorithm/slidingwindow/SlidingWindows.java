package com.lifeng.algorithm.slidingwindow;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * @description: 滑动窗口
 * @author: lifeng
 * @create: 2021-12-29 15:38:22
 **/
public class SlidingWindows {
    /**
     * 最小覆盖子串 76
     * @param s
     * @param t
     * @return
     */
    public String minWindowk(String s,String t){
        HashMap<Character,Integer> ht = new HashMap<>();
        HashMap<Character,Integer> hs = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            ht.put(t.charAt(i),ht.getOrDefault(t.charAt(i),0)+1);
        }
        int left = 0,right = 0;
        //记录滑动窗口符合字符串t条件的字符数量
        int valid = 0;
        //记录最小覆盖字符串的起始结尾索引和长度
        int start = 0,len = Integer.MAX_VALUE;
        while(right < s.length()){
            //c是将移入窗口的文字
            char c = s.charAt(right);
            //右移窗口
            right++;
            if(ht.containsKey(c)){
                hs.put(c,hs.getOrDefault(c,0)+1);
                if(hs.get(c).equals(ht.get(c))){
                    valid++;
                }
            }
            //判断左侧窗口是否需要收缩
            while(valid == t.length()){
                //在这里更新最小覆盖子串
                if(right-left<len){
                    start = left;
                    len = right -left;
                }
                //d是将移除窗口的字符
                char d = s.charAt(left);
                left++;
                if(ht.containsKey(d)){
                    if(hs.get(d).equals(ht.get(d))){
                        valid--;
                    }
                    hs.put(d,hs.getOrDefault(d,0)-1);
                }

            }
        }
        return len == Integer.MAX_VALUE?"":s.substring(start,start+len);
    }

    public List<Integer> findAnagrams(String s, String p){
        if(s==null || "".equals(s) || s.length()==0 || p==null || "".equals(p) || p.length() ==0){
            return null;
        }
        HashMap<Character,Integer> hs = new HashMap<>();
        HashMap<Character,Integer> hp = new HashMap<>();
        for (char c:p.toCharArray()){
            hp.put(c,hp.getOrDefault(c,0)+1);
        }
        int left =0,right = 0;
        int valid = 0;
        int start = 0;
        List<Integer> res = new LinkedList<>();
        while(right<s.length()){
            char c = s.charAt(right);
            right++;
            if(hp.containsKey(c)){
                hs.put(c,hs.getOrDefault(c,0)+1);
                if(hs.get(c).equals(hp.get(c))){
                    valid++;
                }
            }
            while(right-left>=p.length()){
                if(valid==p.length()){
                    res.add(left);//添加起始下标入结果集
                }
                char d = s.charAt(left);
                left--;
                if(hp.containsKey(d)){
                    if(hs.get(d).equals(hp.get(d))){
                        valid--;
                    }
                    hs.put(d,hs.getOrDefault(d,0)-1);
                }
            }
        }
            return res;
        }

    /**
     * 最长无重复子串
     * @param s
     * @return
     */
    public int lengthOFLongestSubString(String s){
            HashMap<Character,Integer> hs = new HashMap<>();
            int left = 0,right = 0;
            int res = 0;
            while(right <s.length()){
                char c = s.charAt(right);
                right++;
                hs.put(c,hs.getOrDefault(c,0)+1);
                while(hs.get(c)>1){//存在重复元素就该收缩左侧窗口了
                    char d = s.charAt(left);
                    left++;
                    hs.put(d,hs.getOrDefault(d,0)-1);
                }
                res = Math.max(res,right-left);
            }
            return res;
        }

}
