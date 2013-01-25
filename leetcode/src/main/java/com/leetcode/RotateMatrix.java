package com.leetcode;

/**
 * Created with IntelliJ IDEA.
 * User: ravigummadi
 * Date: 1/24/13
 * Time: 11:04 PM
 * To change this template use File | Settings | File Templates.
 */
public class RotateMatrix {

    public void rotate(int[][] matrix) {
        int width = matrix.length-1;
        for(int i=0; i < width; i++){
            if(width-2*i <= 0) return;
            for(int j=i; j < width-i; j++){
                int top = matrix[i][j];
                int right = matrix[j][width-i];
                int bottom = matrix[width-i][width-j];
                int left = matrix[width-j][i];
                matrix[j][width-i] = top;
                matrix[width-i][width-j] = right;
                matrix[width-j][i] = bottom;
                matrix[i][j] = left;
            }
        }
    }
}
