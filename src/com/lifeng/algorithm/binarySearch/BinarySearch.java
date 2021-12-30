package com.lifeng.algorithm.binarySearch;

/**
 * @description: 二分查找
 * @author: lifeng
 * @create: 2021-12-28 17:54:26
 **/
public class BinarySearch {


    /**
     * 寻找一个数
     * @param nums
     * @param target
     * @return
     */
    public int binarySearch(int[] nums,int target){
        int left = 0;
        int right = nums.length-1;
        while(left <= right){
            int mid = left+(right-left)/2;
            if(nums[mid]==target){
                return mid;
            }else if(nums[mid]>target){
               right = mid - 1;//mid的数已参与和target的比较
            }else if(nums[mid]<target){
                left = mid + 1;//mid的数已参与和target的比较
            }
        }
        return -1;
    }

    /**
     * 获取左侧边界（right取数组长度）
     * @param nums
     * @param target
     * @return
     */
    public  int left_bound(int[] nums,int target){
        if(nums.length == 0) return -1;
        int left = 0;
        int right = nums.length;//此处为数组长度
        while(left<right){//此处小于right
            int mid = left + (right -left)/2;
            if(nums[mid] == target){
                right = mid;
            }else if(nums[mid]<target){
                left = mid+1;
            }else if(nums[mid]>target){
                right = mid;//目标值在左侧时，right = mid， left取不到右侧的mid，不用减1
            }
        }
        return left;
    }

    /**
     * 获取左侧边界（right取右侧界限）
     * @param nums
     * @param target
     * @return
     */
    public int left_bound2(int[] nums,int target){
        int left = 0;
        int right = nums.length-1;
        while(left<=right){//跳出循环的条件-是left=right+1；
            int mid = left + (right -left)/2;
            if(nums[mid] == target){
                right = mid -1;
            }else if(nums[mid] < target){
                right = mid -1;
            }else if(nums[mid] > target){
                left = mid +1;
            }
        }
        if(left>=nums.length || nums[left]!=target){
            return -1;
        }
        return left;
    }


    /**
     * 获取右侧边界（right取数组长度）
     * @param nums
     * @param target
     * @return
     */
    public  int right_bound(int[] nums,int target){
        if(nums.length == 0) return -1;
        int left = 0;
        int right = nums.length;//此处为数组长度
        while(left<right){//此处小于right
            int mid = left + (right -left)/2;
            if(nums[mid] == target){
                left = mid+1;
            }else if(nums[mid]<target){
                left = mid+1;
            }else if(nums[mid]>target){
                right = mid;//目标值在左侧时，right = mid， left取不到右侧的mid，不用减1
            }
        }
        return left;
    }

    /**
     * 获取右侧边界（right取右侧界限）
     * @param nums
     * @param target
     * @return
     */
    public int right_bound2(int[] nums,int target){
        int left = 0;
        int right = nums.length-1;
        while(left<=right){//跳出循环的条件-是left=right+1；
            int mid = left + (right -left)/2;
            if(nums[mid] == target){
                left = mid +1;
            }else if(nums[mid] < target){
                right = mid -1;
            }else if(nums[mid] > target){
                left = mid +1;
            }
        }
        if(right<0 || nums[right]!=target){
            return -1;
        }
        return right;
    }
}
