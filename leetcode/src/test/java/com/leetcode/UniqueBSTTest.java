package com.leetcode;

import junit.framework.Assert;
import org.junit.Test;

/**
 * Created with IntelliJ IDEA.
 * User: ravigummadi
 * Date: 12/30/12
 * Time: 2:26 PM
 * To change this template use File | Settings | File Templates.
 */
public class UniqueBSTTest {

    @Test
    public void testNumTrees(){
        UniqueBST bst = new UniqueBST();
        Assert.assertEquals(5,bst.numTrees(3));
    }
}
