package com.leetcode;

/**
 * Created by Ravi on 10/9/2014.
 */
public class MinCandy {

    // 1,2,3 ==> 1,2,3
    // 5,3,1 ==> 3,2,1
    public int candy(int[] ratings) {
        //Track the number of candies
        int[] numCandies = new int[ratings.length];
        for (int i = 0; i < numCandies.length; i++) {
            numCandies[i] = 1;
        }
        return 0;
    }

    private boolean recursiveCandy(int[] ratings, int[] numCandies, int currentIndex){
        if(ratings[currentIndex] > ratings[currentIndex-1]){
            numCandies[currentIndex] = numCandies[currentIndex-1] + 1;
            if(!recursiveCandy(ratings, numCandies, currentIndex+1)){
                numCandies[currentIndex]++;
            }else
                return true;
        }else if(ratings[currentIndex] < ratings[currentIndex-1]){
            if(numCandies[currentIndex-1] == 1) return false;
        }
        return false;
    }

}
