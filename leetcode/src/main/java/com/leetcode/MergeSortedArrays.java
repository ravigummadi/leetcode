package com.leetcode;

/**
 * Created with IntelliJ IDEA.
 * User: ravigummadi
 * Date: 1/16/13
 * Time: 10:08 AM
 * Q) Given two sorted arrays of size n and m+n, merge the smaller array into
 the bigger one and keep the result sorted. The bigger array has extra
 spaces at the end of the array which is exactly equal to the size of
 smaller array. Please mention the time complexity of the code you have
 written and see if this is the optimal solution. Note that you’re not
 allowed to use any additional space other than what’s already provided.

 * Assumption 1: The ordering from lower to higher.
 * Approach: Insert the elements from bigger to smaller, starting at the end of the array
 * This way we can ensure that no overwriting in the array
 */
public class MergeSortedArrays {

    /**
     * Large array will be updated with final output
     * @param large Large array
     * @param m Number of actual elements present in m
     * @param total m + n
     * @param small Small array
     * @param n Number of actual elements present in n
     */
    private static void mergeArrays(int[] large, int m, int total, int[] small, int n){
        int current = total-1;
        int i = m-1;
        int j = n-1;
        while(i >= 0 && j >= 0){
            if(small[j] > large[i]){
                large[current] = small[j];
                j--;
            }else{
                large[current] = large[i];
                i--;
            }
            current--;
        }
        System.out.println(large);

        if(i >= 0){
            // Actually this is redundant, kept for uniformity
            while(i >= 0){
                large[current--] = large[i--];
            }
        }else if(j >= 0){
            while (j >= 0){
                large[current--] = small[j--];
            }
        }

    }

    public static void main(String[] args){

        int[] large = {1,5,6,0,0,0};
        int[] small = {2,4,7};
        mergeArrays(large,3,6,small,3);
        System.out.println(large);
    }


}
