package com.leetcode;

import junit.framework.Assert;
import org.junit.Test;

/**
 * Created with IntelliJ IDEA.
 * User: ravigummadi
 * Date: 12/25/12
 * Time: 9:09 PM
 * To change this template use File | Settings | File Templates.
 */
public class LongestValidParenthesisTest {

    @Test
    public void testLongestValidParentheses(){
        LongestValidParenthesis lvp = new LongestValidParenthesis();
//        Assert.assertEquals(2,lvp.longestValidParentheses("()(()"));
        Assert.assertEquals(6,lvp.longestValidParentheses(")()((()(())"));
    }

}
