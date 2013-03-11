package com.leetcode;

import junit.framework.Assert;
import org.junit.Test;

/**
 * Created with IntelliJ IDEA.
 * User: ravigummadi
 * Date: 3/10/13
 * Time: 7:09 PM
 * To change this template use File | Settings | File Templates.
 */
public class RegexMatchingTest {

    @Test
    public void testIsMatch(){
        RegexMatching regexMatching = new RegexMatching();
        Assert.assertEquals(regexMatching.isMatch("aa","."),false);
        Assert.assertEquals(regexMatching.isMatch("aa",".*"),true);
        Assert.assertEquals(regexMatching.isMatch("ab",".*c"),false);
        Assert.assertEquals(regexMatching.isMatch("aa","a*"),true);
        Assert.assertEquals(regexMatching.isMatch("aaa","ab*a"),false);
        Assert.assertEquals(regexMatching.isMatch("aaa","a*a"),true);

    }

}
