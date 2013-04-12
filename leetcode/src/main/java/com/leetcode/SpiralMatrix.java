package com.leetcode;

import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: gummadi
 * Date: 4/11/13
 * Time: 7:00 AM
 * To change this template use File | Settings | File Templates.
 */
public class SpiralMatrix {

    public ArrayList<Integer> spiralOrder(int[][] matrix) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        if(matrix.length == 0)
            return result;
        Point topLeft = new Point(0,0);
        Point bottomRight = new Point(matrix.length-1,matrix[0].length-1);
        while(!(bottomRight.x < topLeft.x || bottomRight.y < topLeft.y)){
            addBoundaryPointsToList(matrix,topLeft,bottomRight,result);
            topLeft = new Point(topLeft.x+1, topLeft.y+1);
            bottomRight = new Point(bottomRight.x-1, bottomRight.y-1);
        }
        return result;
    }

    private void addBoundaryPointsToList(int[][] matrix, Point topLeft, Point bottomRight, ArrayList<Integer> result){
        if(topLeft.x == bottomRight.x){
            for(int j=topLeft.y; j <= bottomRight.y; j++){
                result.add(matrix[topLeft.x][j]);
            }
        }else if(topLeft.y == bottomRight.y){
            for(int i=topLeft.x; i <= bottomRight.x; i++){
                result.add(matrix[i][topLeft.y]);
            }
        }else{
            for(int j=topLeft.y; j < bottomRight.y; j++){
                result.add(matrix[topLeft.x][j]);
            }
            for(int i=topLeft.x; i < bottomRight.x; i++){
                result.add(matrix[i][bottomRight.y]);
            }
            for(int j=bottomRight.y; j > topLeft.y; j--){
                result.add(matrix[bottomRight.x][j]);
            }
            for(int i=bottomRight.x; i > topLeft.x; i--){
                result.add(matrix[i][topLeft.y]);
            }
        }
    }

    class Point{
        int x;
        int y;
        Point(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
}
