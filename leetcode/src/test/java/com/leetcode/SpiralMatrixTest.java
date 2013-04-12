package com.leetcode;

import org.junit.Test;

/**
 * Created with IntelliJ IDEA.
 * User: gummadi
 * Date: 4/11/13
 * Time: 7:58 AM
 * To change this template use File | Settings | File Templates.
 */
public class SpiralMatrixTest {

    @Test
    public void testSpiralMatix(){
        int[][] matrix = new int[1][];
        matrix[0] = new int[]{2,3};
        SpiralMatrix spiralMatrix = new SpiralMatrix();
        spiralMatrix.spiralOrder(matrix);
    }

}
