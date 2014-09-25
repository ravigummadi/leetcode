package com.general;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ravi on 9/24/2014.
 */
public class Permutations {

    // Prints the permutations of a generic list
    public <T> void printPermutations(List<T> typedList){
        List<T> soFarList = new ArrayList<T>();
        recursivePrintPermutations(soFarList, typedList);
    }

    private <T> void recursivePrintPermutations(List<T> soFar, List<T> restOfList){
        if(restOfList.isEmpty()){
            System.out.println(printList(soFar));
        }

        for(int i=0; i < restOfList.size(); i++){
            T lastObj = restOfList.get(i);
            soFar.add(lastObj);
            restOfList.remove(i);
            recursivePrintPermutations(soFar, restOfList);
            soFar.remove(lastObj);
            restOfList.add(i, lastObj);
        }
    }

    private <T> String printList(List<T> printList){
        StringBuilder sb = new StringBuilder();
        printList.stream().forEach(obj -> sb.append(obj));
        return sb.toString();
    }


}
