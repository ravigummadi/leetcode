package com.leetcode;

import junit.framework.Assert;

/**
 * Created with IntelliJ IDEA.
 * User: gummadi
 * Date: 12/24/12
 * Time: 7:50 PM
 * To change this template use File | Settings | File Templates.
 */
public class DistinctSubsequenceTest {

    @org.junit.Test
    public void testNumDistinct(){
        DistinctSubsequence ds = new DistinctSubsequence();
        Assert.assertEquals(3,ds.numDistinct("rabbbit","rabbit"));
        Assert.assertEquals(1,ds.numDistinct("ABCDE","ACE"));
    }

}
