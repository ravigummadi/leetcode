package com.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: gummadi
 * Date: 4/7/13
 * Time: 1:10 AM
 * To change this template use File | Settings | File Templates.
 */
public class CombinationSum {

    ArrayList<ArrayList<Integer>> allLists;

    public ArrayList<ArrayList<Integer>> combinationSum(int[] candidates, int target) {
        allLists = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> candidateList = convertArrayToList(candidates);
        ArrayList<Integer> listSoFar = new ArrayList<Integer>();
//        recCombinationSum(listSoFar, candidateList, target);
        smartRecursiveSum(listSoFar, candidateList, target);
        return allLists;
    }

    private void recCombinationSum(ArrayList<Integer> listSoFar, ArrayList<Integer> remainingList, int target){
        int result = compareListSumToTarget(listSoFar,target);
        if(result == 0){
            if(!allLists.contains(listSoFar))
                allLists.add(new ArrayList<Integer>(listSoFar));
            return;
        }else if(result == 1){
            return;
        }
        if(remainingList.isEmpty())
            return;

        ArrayList<Integer> list1 = new ArrayList<Integer>(listSoFar);
        list1.add(remainingList.get(0));
        recCombinationSum(list1,new ArrayList<Integer>(remainingList),target);

        ArrayList<Integer> remainList = new ArrayList<Integer>(remainingList);
        remainList.remove(0);
        recCombinationSum(new ArrayList<Integer>(listSoFar),remainList,target);

        ArrayList<Integer> list2 = new ArrayList<Integer>(listSoFar);
        list2.add(remainingList.get(0));
        ArrayList<Integer> remainList2 = new ArrayList<Integer>(remainingList);
        remainList2.remove(0);
        recCombinationSum(list2, remainList2, target);
    }

    private void smartRecursiveSum(ArrayList<Integer> listSoFar, ArrayList<Integer> remainingList, int target){
        if(target == 0){
            if(!allLists.contains(listSoFar))
                allLists.add(new ArrayList<Integer>(listSoFar));
            return;
        }else if(target < 1){
            return;
        }
        if(remainingList.isEmpty())
            return;

        // Will not have this case for Combination Sum 2 case.
        ArrayList<Integer> list1 = new ArrayList<Integer>(listSoFar);
        list1.add(remainingList.get(0));
        smartRecursiveSum(list1,new ArrayList<Integer>(remainingList),target-remainingList.get(0));

        ArrayList<Integer> remainList = new ArrayList<Integer>(remainingList);
        remainList.remove(0);
        smartRecursiveSum(new ArrayList<Integer>(listSoFar),remainList,target);

        ArrayList<Integer> list2 = new ArrayList<Integer>(listSoFar);
        list2.add(remainingList.get(0));
        ArrayList<Integer> remainList2 = new ArrayList<Integer>(remainingList);
        remainList2.remove(0);
        smartRecursiveSum(list2, remainList2, target-remainingList.get(0));

    }

    private int compareListSumToTarget(ArrayList<Integer> list, int target){
        int total = 0;
        for(int num : list){
            total += num;
        }
        if(total == target){
            return 0;
        }if(total > target){
            return 1;
        }else{
            return -1;
        }
    }

    private ArrayList<Integer> convertArrayToList(int[] arr){
        Arrays.sort(arr);
        ArrayList<Integer> list = new ArrayList<Integer>();
        for(int num : arr)
            list.add(num);

        return list;
    }

}
