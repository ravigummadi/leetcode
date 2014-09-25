package com.leetcode;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created with IntelliJ IDEA.
 * User: ravigummadi
 * Date: 3/4/13
 * Time: 11:47 PM
 * To change this template use File | Settings | File Templates.
 */
public class AddBinaryNumbersTest {

    @Test
    public void testSolution(){
        AddBinaryNumbers ab = new AddBinaryNumbers();
        Assert.assertEquals("0", ab.addBinary("0", "0"));
    }

}
