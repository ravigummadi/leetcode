package com.general;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ravigum on 9/25/2014.
 */
public class Combinations {

    public <T> void printCombinations(List<T> typedList){
        List<T> sofar = new ArrayList<>();
        recursivePrintCombinations(sofar, typedList);
    }

    private <T> void recursivePrintCombinations(List<T> soFar, List<T> left){
        if(left.isEmpty()) {
            System.out.println(CommonUtils.printList(soFar));
            return;
        }


        T topElem = left.remove(0);
        recursivePrintCombinations(soFar, left);
        soFar.add(topElem);
        recursivePrintCombinations(soFar, left);
        soFar.remove(topElem);
        left.add(topElem);
    }

}
