package com.leetcode;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created with IntelliJ IDEA.
 * User: ravigummadi
 * Date: 1/19/13
 * Time: 6:58 PM
 * To change this template use File | Settings | File Templates.
 */
public class SortRotatedArrayTest {

    @Test
    public void testSearch(){
        SortRotatedArray sortRotatedArray = new SortRotatedArray();
        int[] A = new int[]{4,5,6,7,1,2,3};
//        Assert.assertEquals(0,sortRotatedArray.search(A, 4));
//        Assert.assertEquals(5,sortRotatedArray.search(A, 2));

        A = new int[]{1};
        Assert.assertEquals(-1,sortRotatedArray.search(A, 0));
        A = new int[]{1,3};
        Assert.assertEquals(-1,sortRotatedArray.search(A, 2));
    }

    @Test
    public void testMid(){
        int mid = (3 + 4)/2;
        System.out.println(mid);
        mid = (0 + 1)/2;
        System.out.println(mid);
    }
}
