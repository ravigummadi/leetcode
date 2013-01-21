package com.leetcode;

import junit.framework.Assert;
import org.junit.Test;

import java.util.ArrayList;

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
        ArrayList<Integer> list1 = new ArrayList<Integer>();
        list1.add(-10);
        triangle.add(list1);
        Assert.assertEquals(-10,tr.minimumTotal(triangle));
    }


}
