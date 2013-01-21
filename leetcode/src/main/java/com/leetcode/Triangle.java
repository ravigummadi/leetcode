package com.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: ravigummadi
 * Date: 1/21/13
 * Time: 9:35 AM
 * To change this template use File | Settings | File Templates.
 */
public class Triangle {


    public int minimumTotal(ArrayList<ArrayList<Integer>> triangle) {
        int minSum = 0;
        int currentIndex = 0;
        return recursiveMinTotal(triangle,0,0,0);


    }


    private int recursiveMinTotal(ArrayList<ArrayList<Integer>> triangle, int currentList, int currentIndex, int currentSum){
        if(currentList >= triangle.size()){
            return currentSum;
        }

        try{
            return Math.min(
                    recursiveMinTotal(triangle,currentList+1,currentIndex,currentSum+triangle.get(currentList).get(currentIndex)),
                    recursiveMinTotal(triangle,currentList+1,currentIndex+1,currentSum+triangle.get(currentList).get(currentIndex+1))
            );
        }catch(IndexOutOfBoundsException ioe){
            return recursiveMinTotal(triangle,currentList+1,currentIndex,currentSum+triangle.get(currentList).get(currentIndex));
        }

    }

}
