package com.leetcode;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

/**
 * Created with IntelliJ IDEA.
 * User: gummadi
 * Date: 4/2/13
 * Time: 9:42 PM
 * To change this template use File | Settings | File Templates.
 */
public class SudokuSolver {

    public void solveSudoku(char[][] board) {
        Set<PointPair> boxBoundaries = populateBoxBoundaries();
        TreeSet<Point> allEmptyPointsSet = populateListWithAllEmptyCells(board);
        recursiveSolveSudoku(board,allEmptyPointsSet,boxBoundaries);
        System.out.println(board);
    }

    private boolean recursiveSolveSudoku(char[][] boardState, TreeSet<Point> emptyCells, Set<PointPair> boundaries){
        if(emptyCells.size() == 0)
            return true;
        Point currentPoint = emptyCells.pollFirst();
        for(int i=1; i <= 9; i++){
            boardState[currentPoint.x][currentPoint.y] = Character.forDigit(i,10);
            if(doesBoardSatisfyRowConstraint(boardState,currentPoint.x) &&
                doesBoardSatisfyColumnConstraint(boardState, currentPoint.y) &&
                doesBoardSatisfyBoxConstraint(boardState,currentPoint,boundaries)){
                if(recursiveSolveSudoku(boardState, emptyCells, boundaries)){
                    return true;
                }
            }
        }
        boardState[currentPoint.x][currentPoint.y] = '.';
        emptyCells.add(currentPoint);
        return false;
    }

    private TreeSet<Point> populateListWithAllEmptyCells(char[][] board){
        TreeSet<Point> emptyCells = new TreeSet<Point>();
        for(int i=0; i<9; i++){
            for(int j=0;j<9;j++){
                if(board[i][j]=='.'){
                    emptyCells.add(new Point(i,j));
                }
            }
        }
        return emptyCells;
    }

    private Set<PointPair> populateBoxBoundaries(){
        Set<PointPair> boundaries = new HashSet<PointPair>();
        boundaries.add(new PointPair(new Point(0,0), new Point(2,2)));
        boundaries.add(new PointPair(new Point(3,0), new Point(5,2)));
        boundaries.add(new PointPair(new Point(6,0), new Point(8,2)));
        boundaries.add(new PointPair(new Point(0,3), new Point(2,5)));
        boundaries.add(new PointPair(new Point(3,3), new Point(5,5)));
        boundaries.add(new PointPair(new Point(6,3), new Point(8,5)));
        boundaries.add(new PointPair(new Point(0,6), new Point(2,8)));
        boundaries.add(new PointPair(new Point(3,6), new Point(5,8)));
        boundaries.add(new PointPair(new Point(6,6), new Point(8,8)));
        return boundaries;
    }

    private boolean doesBoardSatisfyRowConstraint(char[][] boardState, int row){
        Set<Character> rowChars = new HashSet<Character>();
        for(int i=0; i < 9; i++){
            char c = boardState[row][i];
            if(c != '.' && rowChars.contains(c)){
                return false;
            }
            rowChars.add(c);
        }
        return true;
    }

    private boolean doesBoardSatisfyColumnConstraint(char[][] boardState, int column){
        Set<Character> columnChars = new HashSet<Character>();
        for(int i=0;i < 9; i++){
            char c = boardState[i][column];
            if(c != '.' && columnChars.contains(c)){
                return false;
            }
            columnChars.add(c);
        }
        return true;
    }

    private boolean doesBoardSatisfyBoxConstraint(char[][] boardState, Point point, Set<PointPair> boundaries){
        for(PointPair pair : boundaries){
            if(point.x >= pair.topLeft.x && point.y >= pair.topLeft.y
                    && point.x <= pair.bottomRight.x && point.y <= pair.bottomRight.y){
                return checkBoxConstraint(boardState,pair);
            }
        }
        throw new IllegalArgumentException("The point has to be part of one of the boundary, " + point);
    }

    private boolean checkBoxConstraint(char[][] boardState, PointPair box){
        Set<Character> boxChars = new HashSet<Character>();
        for(int i=box.topLeft.x; i<= box.bottomRight.x; i++){
            for(int j=box.topLeft.y; j<=box.bottomRight.y; j++){
                char c = boardState[i][j];
                if(c != '.' && boxChars.contains(c)){
                    return false;
                }
                boxChars.add(c);
            }
        }
        return true;
    }

    class PointPair{
        Point topLeft;
        Point bottomRight;
        PointPair(Point a, Point b){
            this.topLeft = a;
            this.bottomRight = b;
        }
    }

    class Point implements Comparable<Point>{
        int x;
        int y;

        Point(int x, int y){
            this.x = x;
            this.y = y;
        }

        public String toString(){
            return "[x: " + x + ",y: " + y + "]";
        }

        public int compareTo(Point other){
            if(this.x > other.x){
                return 1;
            }else if(this.x == other.x){
                if(this.y > other.y){
                    return 1;
                }else if(this.y == other.y){
                    return 0;
                }else{
                    return 1;
                }
            }else{
                return -1;
            }
        }
    }

}
