package com.general;

import com.common.CommonUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ravi on 9/24/2014.
 */
public class Permutations {

    // Prints the permutations of a generic list
    public <T> void printPermutations(List<T> typedList) {
        List<T> soFarList = new ArrayList<T>();
        recursivePrintPermutations(soFarList, typedList);
    }

    private <T> void recursivePrintPermutations(List<T> soFar, List<T> restOfList) {
        if (restOfList.isEmpty()) {
            System.out.println(CommonUtils.printList(soFar));
            return;
        }

        for (int i = 0; i < restOfList.size(); i++) {
            T lastObj = restOfList.get(i);
            soFar.add(lastObj);
            restOfList.remove(i);
            recursivePrintPermutations(soFar, restOfList);
            soFar.remove(lastObj);
            restOfList.add(i, lastObj);
        }
    }


}
