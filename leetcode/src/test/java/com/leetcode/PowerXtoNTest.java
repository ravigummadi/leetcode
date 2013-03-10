package com.leetcode;

import junit.framework.Assert;
import org.junit.Test;

/**
 * Created with IntelliJ IDEA.
 * User: ravigummadi
 * Date: 3/9/13
 * Time: 6:54 PM
 * To change this template use File | Settings | File Templates.
 */
public class PowerXtoNTest {

    @Test
    public void testPower(){
        PowerXToN pow = new PowerXToN();
        Assert.assertEquals(1024, pow.pow(2,10));
    }

}
