package com.leetcode;

import junit.framework.Assert;
import org.junit.Test;

/**
 * Created with IntelliJ IDEA.
 * User: ravigummadi
 * Date: 3/5/13
 * Time: 9:38 AM
 * To change this template use File | Settings | File Templates.
 */
public class LongestPalindromTest {

    @Test
    public void testPalindrome(){
        LongestPalindrome palindrome = new LongestPalindrome();
        Assert.assertEquals("abcba",palindrome.recLongestPalindrome("abcdeabcbaaaa23aa"));
    }

}
