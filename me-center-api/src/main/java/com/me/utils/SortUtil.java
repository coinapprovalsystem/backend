package com.me.utils;


/**
 * @author zhaohaojie
 * @date 2019-01-11 17:02
 */
public class SortUtil {
    // sort
    public static void sort(Comparable[] arr){
        if (arr == null){
            throw new NullPointerException("arr 不能为空！排序失败！");
        }
    }

    //对元素进行比较,假如 v = B,w =A ; 返回 false
    public static boolean less(Comparable v,Comparable w){
        return v.compareTo(w)<0;
    }

    //是否已经排过序
    public static boolean isSorted(Comparable[] arr){
        for (int i =0;i<arr.length;i++){
            if (less(arr[i],arr[i-1])){//后者 比 前者 小。
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(Integer.MAX_VALUE);
    }
}

