package com.general;// CS1101 (AY2007/8 Semester 1)
// Lab 7 Exercise 1
// PlaySudoku.java
// Written by: Aaron Tan
//
// Fill in the description of this program here.

import java.util.Scanner;

public class PlaySudoku {

    public static void main(String[] args) {

        System.out.println("Enter the board, using 0 " +
                "to indicate a blank cell: ");

        Scanner scanner = new Scanner(System.in);
        int[][] myBoard = readBoard(scanner);
        Sudoku puzzle = new Sudoku(myBoard);

        // The following 2 statements are used for checking.
        // Remove them before you submit your program.
        System.out.println("The Sudoku board read: ");
        System.out.println(puzzle);

        puzzle.solve();

        // To display the puzzle after it is solved.
        System.out.println("The Sudoku board solved: ");
        System.out.println(puzzle);
    }

    // To create a 9x9 integer array from user's input
    public static int[][] readBoard(Scanner scanner) {

        int[][] boardVals = new int[9][9];
        for (int i = 0; i < 9; i++) {
            String line = scanner.nextLine();
            String[] chars = line.split(" ");
            for (int j = 0; j < 9; j++) {
                boardVals[i][j] = Integer.parseInt(chars[j]);
            }
        }
        return boardVals;
    }
}

