package com.leetcode;

import org.junit.Test;

/**
 * Created with IntelliJ IDEA.
 * User: ravigummadi
 * Date: 1/21/13
 * Time: 1:26 AM
 * To change this template use File | Settings | File Templates.
 */
public class ThreeSumTest {

    @Test
    public void testThreeSum(){
        int[] arr = new int[] {-1,0,1,2,-1,-4};
        ThreeSum threeSum = new ThreeSum();
        threeSum.threeSum(arr,0);
    }
}
