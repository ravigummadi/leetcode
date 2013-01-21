package com.leetcode;

import junit.framework.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * User: ravigummadi
 * Date: 1/21/13
 * Time: 10:42 AM
 * To change this template use File | Settings | File Templates.
 */
public class TriangleTest {
    @Test
    public void testTriangleTest(){

        Triangle tr = new Triangle();
        ArrayList<ArrayList<Integer>> triangle = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> list1 = new ArrayList<Integer>(Arrays.asList(2));
        ArrayList<Integer> list2 = new ArrayList<Integer>(Arrays.asList(3,4));
        ArrayList<Integer> list3 = new ArrayList<Integer>(Arrays.asList(6,5,9));
        ArrayList<Integer> list4 = new ArrayList<Integer>(Arrays.asList(4,4,8,0));

        triangle.add(list1);
        triangle.add(list2);
        triangle.add(list3);
        triangle.add(list4);
        Assert.assertEquals(14,tr.minimumTotal(triangle));

    }


}
