package com.leetcode;

import org.junit.Test;

/**
 * Created with IntelliJ IDEA.
 * User: gummadi
 * Date: 4/3/13
 * Time: 12:07 AM
 * To change this template use File | Settings | File Templates.
 */
public class SudokuSolverTest {

    @Test
    public void testSolveSudoku(){
        char[][] board = new char[9][];

        board[0] = "..9748...".toCharArray();
        board[1] = "7........".toCharArray();
        board[2] = ".2.1.9...".toCharArray();
        board[3] =  "..7...24.".toCharArray();
        board[4] = ".64.1.59.".toCharArray();
        board[5] = ".98...3..".toCharArray();
        board[6] =  "...8.3.2.".toCharArray();
        board[7] = "........6".toCharArray();
        board[8] = "...2759..".toCharArray();

        SudokuSolver solver = new SudokuSolver();
        solver.solveSudoku(board);
    }

}
