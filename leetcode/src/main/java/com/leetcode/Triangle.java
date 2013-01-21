package com.leetcode;

import java.util.ArrayList;
import java.util.List;

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
        for(List<Integer> list : triangle){
            currentIndex = getSmallestNeighbour(list,currentIndex);
            minSum += list.get(currentIndex);
        }
        return minSum;
    }

    private int getSmallestNeighbour(List<Integer> list, int index){
        int leftNeighbour = list.get(index);
        int rightNeighbour = Integer.MAX_VALUE;
        if(index+1 < list.size()){
            rightNeighbour = list.get(index+1);
        }

        int smallest = Math.min(Math.abs(0-leftNeighbour),Math.abs(0-rightNeighbour));
        if(smallest == leftNeighbour){return index;}
        else return index+1;
    }

}
