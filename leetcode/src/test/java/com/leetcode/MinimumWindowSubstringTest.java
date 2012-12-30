package com.leetcode;

import junit.framework.Assert;
import org.junit.Test;

/**
 * Created with IntelliJ IDEA.
 * User: ravigummadi
 * Date: 12/27/12
 * Time: 12:48 PM
 * To change this template use File | Settings | File Templates.
 */
public class MinimumWindowSubstringTest {

    @Test
    public void testFindMinWindow(){
        MinimumWindowSubstring mws = new MinimumWindowSubstring();
//        Assert.assertEquals("BANC",mws.minWindow("ADOBECODEBANC","ABC"));
        Assert.assertEquals("ADOB",mws.minWindow("ADOBE","AB"));
    }


}
