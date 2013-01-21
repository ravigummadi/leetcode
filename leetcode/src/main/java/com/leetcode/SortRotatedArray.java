package com.leetcode;

/**
 * Created with IntelliJ IDEA.
 * User: ravigummadi
 * Date: 1/19/13
 * Time: 6:10 PM
 * Suppose a sorted array is rotated at some pivot unknown to you beforehand.

 (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).

 You are given a target value to search. If found in the array return its index, otherwise return -1.

 You may assume no duplicate exists in the array.
 */
public class SortRotatedArray {

    int search(int A[], int target) {
        return recursiveSearch(A,0,A.length-1,target);

    }

    int recursiveSearch(int A[], int low, int high, int target){

        if(high < low) { return -1; }

        if(low == high){
            if(A[low] == target) return low;
            else return -1;
        }

        int mid = (low + high) / 2;
        if(A[mid] == target) return mid;

        if(A[low] < A[mid]) {
            if(target < A[mid] && target >= A[low]){
                return recursiveSearch(A,low,mid-1,target);
            }else{
                return recursiveSearch(A,mid+1,high,target);
            }
        }else {
            if(target > A[mid] && target <= A[high]){
                return recursiveSearch(A,mid+1,high,target);
            }else{
                return recursiveSearch(A,low,mid-1,target);
            }
        }
    }


}
