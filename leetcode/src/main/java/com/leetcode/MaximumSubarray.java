package com.leetcode;

/**
 * Created with IntelliJ IDEA.
 * User: gummadi
 * Date: 4/11/13
 * Time: 6:45 AM
 * To change this template use File | Settings | File Templates.
 */
public class MaximumSubarray {
    public int maxSubArray(int[] A) {
        int maxSum = 0;
        int sumSofar = 0;
        for(int i=0; i < A.length; i++){
            sumSofar += A[i];
            if(sumSofar < 0){
                sumSofar = 0;
            }else if(sumSofar > maxSum){
                maxSum = sumSofar;
            }
        }
        if(maxSum == 0)
            maxSum = getHighestNum(A);
        return maxSum;
    }

    private int getHighestNum(int[] A){
        int highNum = Integer.MIN_VALUE;
        for(int num : A){
            if(num > highNum)
                highNum = num;
        }
        return highNum;
    }

}
