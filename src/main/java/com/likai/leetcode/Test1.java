package com.likai.leetcode;

import java.util.Arrays;

public class Test1 {

    public int[] twoSum(int[] nums, int target) {
        int[] resultArray = new int[2];
        for (int i = 0, len = nums.length - 1; i < len; i++) {
            for (int j = i + 1, len1 = nums.length; j < len1; j++) {
                if (nums[i] + nums[j] == target) {
                    resultArray[0] = i;
                    resultArray[1] = j;
                    break;
                }
            }
        }
        return resultArray ;
    }

    public static void main(String [] args) {
        Test1 t = new Test1() ;
        int [] nums = {2, 7, 11, 15} ;
        int [] result = t.twoSum(nums,17) ;

        System.out.println(Arrays.toString(result));
    }

}
