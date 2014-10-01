package com.general;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created with IntelliJ IDEA.
 * User: ravigummadi
 * Date: 3/4/13
 * Time: 10:06 PM
 * To change this template use File | Settings | File Templates.
 */
public class IntersectionOfTwoArraysTest {

    @Test
    public void testIntersection() {
        IntersectionOfTwoArrays it = new IntersectionOfTwoArrays();
        Integer[] result = it.printIntersection(new int[]{1, 2, 3, 4, 5, 7, 11, 12}, new int[]{4, 6, 7, 8, 9});
        Integer[] expected = {4, 7, 9};
        Assert.assertArrayEquals(expected, result);
    }
}
