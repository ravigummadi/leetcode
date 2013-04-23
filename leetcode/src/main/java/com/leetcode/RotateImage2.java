package com.leetcode;

/**
 * Created with IntelliJ IDEA.
 * User: gummadi
 * Date: 4/12/13
 * Time: 1:02 AM
 * To change this template use File | Settings | File Templates.
 */
public class RotateImage2 {
    public void rotate(int[][] matrix) {
        Point topLeft = new Point(0,0);
        int size = matrix.length-1;
        while(size > 1){
            rotateBox(matrix,topLeft,size);
            topLeft = new Point(topLeft.x+1, topLeft.y+1);
            size = size - 2;
        }
    }

    private void rotateBox(int[][] matrix, Point topLeft, int size){
        for(int i=0; i < size; i++){
            int temp = matrix[topLeft.x][topLeft.y+i];
            matrix[topLeft.x][topLeft.y+i] = matrix[topLeft.x+size-i][topLeft.y];
            matrix[topLeft.x+size-i][topLeft.y] = matrix[topLeft.x+size][topLeft.y+size-i];
            matrix[topLeft.x+size][topLeft.y+size-i] = matrix[topLeft.x+i][topLeft.y+size];
            matrix[topLeft.x+i][topLeft.y+size] = temp;
        }
    }

    class Point{
        int x,y;
        Point(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
}
