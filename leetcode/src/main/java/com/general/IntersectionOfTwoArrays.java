package com.general;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: ravigummadi
 * Date: 3/4/13
 * Time: 10:04 PM
 * To change this template use File | Settings | File Templates.
 */
public class IntersectionOfTwoArrays {

    public Integer[] printIntersection(int[] arr1, int[] arr2) {
        List<Integer> intersectList = new ArrayList<Integer>();
        int i = 0;
        int j = 0;
        while (i < arr1.length && j < arr2.length) {
            if (arr1[i] == arr2[j]) {
                intersectList.add(arr1[i]);
                i++;
                j++;
            } else if (arr1[i] < arr2[j]) {
                i++;
            } else {
                j++;
            }
        }
        return intersectList.toArray(new Integer[0]);
    }

}
