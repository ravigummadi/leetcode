package com.lhcs;

import java.util.Arrays;

/**
 * Created by Ravi on 10/17/2014.
 */
public class ArrayExamples {

    public static void main(String[] args){
        int[] arr = generateArray(100, true);

        long startTime = System.nanoTime();
        System.out.println("Sort status of the array isSortedUsingSort: " + isSortedUsingSort(arr));
        long estimatedTime = System.nanoTime() - startTime;
        System.out.println("Time taken (nanoseconds) isSortedUsingSort:: " + estimatedTime);

        startTime = System.nanoTime();
        System.out.println("Sort status of the array isSortedUsingComparison: " + isSortedUsingComparison(arr));
        estimatedTime = System.nanoTime() - startTime;
        System.out.println("Time taken (nanoseconds) isSortedUsingComparison:: " + estimatedTime);

        arr = generateArray(100, false);

        startTime = System.nanoTime();
        System.out.println("Sort status of the array isSortedUsingSort: " + isSortedUsingSort(arr));
        estimatedTime = System.nanoTime() - startTime;
        System.out.println("Time taken (nanoseconds) isSortedUsingSort:: " + estimatedTime);

        startTime = System.nanoTime();
        System.out.println("Sort status of the array isSortedUsingComparison: " + isSortedUsingComparison(arr));
        estimatedTime = System.nanoTime() - startTime;
        System.out.println("Time taken (nanoseconds) isSortedUsingComparison:: " + estimatedTime);

    }

    public static int[] generateArray(int length, boolean isRandom){
        int[] newArr = new int[length];
        for (int i = 0; i < length; i++) {
            newArr[i] = isRandom ? (int) (Math.random() * 100) : i;
        }
        System.out.println(Arrays.toString(newArr));
        return newArr;
    }

    public static boolean isSortedUsingSort(int[] array)
    {
        int[] copyArray = Arrays.copyOf(array, array.length);
        Arrays.sort(copyArray);
        return (Arrays.equals(array, copyArray));
    }

    public static boolean isSortedUsingComparison(int[] array){
        int lastElement = array[0];
        for(int currentElement : array){
            if(lastElement <= currentElement)
                continue;
            return false;
        }
        return true;
    }

}
