package com.general;// CS1101 (AY2007/8 Semester 1)
// Lab 7 Exercise 1
// Sudoku.java
// Written by: Aaron Tan
//
// Fill in the description of this program here.

import java.util.*;

public class Sudoku {

    // Data member
    private int[][] board;

    // Constructor to create an empty Sudoku board
    public Sudoku() {
        board = new int[9][9];

        for (int r = 0; r < 9; r++)
            for (int c = 0; c < 9; c++)
                board[r][c] = 0;
    }

    // Constructor to create a Sudoku board
    // with values provided in the array inBoard
    public Sudoku(int[][] inBoard) {
        board = inBoard;
    }

//-----------------------------------------------------------
//      Public Methods:
//          int setBoard ( int[][] );
//          int getValue ( int, int );
//          void setValue ( int, int, int );
//          String toString ();
//----------------------------------------------------------

    // Sets the Sudoku board by copying the values in
    // the array inBoard
    public void setBoard(int[][] inBoard) {
        for (int r = 0; r < 9; r++)
            for (int c = 0; c < 9; c++)
                board[r][c] = inBoard[r][c];
    }

    // Gets the (row,col)-value in the Sudoku board
    public int getValue(int row, int col) {
        return board[row][col];
    }

    // Sets the (row,col)-value in the Sudoku board
    public void setValue(int row, int col, int value) {
        board[row][col] = value;
    }

    // Returns string representation of a Sudoku puzzle
    // A blank cell is represented by '-'.
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                sb.append((board[i][j] == 0 ? "-" : board[i][j]) + " ");
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    // Solving a Sudoku puzzle using a very simple
    // algorithm (which may not solve the puzzle completely).
    public void solve() {
        // What is the end state?


        // Recursive part


        // Fail state


    }

    private Set<Integer> getCandidateSet(Point currentPoint){
        Set<Integer> boxNumbers = getAvailableNumbersForBox(currentPoint);
        Set<Integer> rowNumbers = getAvailableNumbersForRow(currentPoint);
        Set<Integer> columnNumbers = getAvailableNumbersForColumn(currentPoint);
        return getIntersectionOfRowColumnBox(rowNumbers, columnNumbers, boxNumbers);
    }


    private Set<Integer> getIntersectionOfRowColumnBox(Set<Integer> rowAvail, Set<Integer> colAvail, Set<Integer> box){
        Set<Integer> staringSet = getInitIntegers();
        staringSet.retainAll(rowAvail);
        staringSet.retainAll(colAvail);
        staringSet.retainAll(box);
        return staringSet;
    }

    private Set<Integer> getAvailableNumbersForRow(Point currentPoint){
        Set<Integer> startingSet = getInitIntegers();
        for(int j=0; j < 9; j++)
            startingSet.remove(board[currentPoint.x][j]);
        return  startingSet;
    }


    private Set<Integer> getAvailableNumbersForColumn(Point currentPoint){
        Set<Integer> startingSet = getInitIntegers();
        for(int i=0; i < 9; i++)
            startingSet.remove(board[i][currentPoint.y]);
        return  startingSet;
    }

    private Set<Integer> getAvailableNumbersForBox(Point startingPoint){
        Set<Integer> startingSet = getInitIntegers();
        for(int i=startingPoint.x; i < startingPoint.x +3; i++){
            for(int j= startingPoint.y; j < startingPoint.y+3; j++){
                startingSet.remove(board[i][j]);
            }
        }
        return startingSet;
    }

    private Set<Integer> getInitIntegers() {
        return new HashSet<>(Arrays.asList(new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9}));
    }


    private Point getStartPointOfBox(int i, int j) {
        return new Point((i / 3) * 3, (j / 3) * 3);
    }


    class Point {
        public int x;
        public int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

    }
}

