package com.leetcode;

import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: gummadi
 * Date: 2/23/13
 * Time: 7:23 PM
 * To change this template use File | Settings | File Templates.
 */
public class PascalTriangle2 {

    public ArrayList<Integer> getRow(int rowIndex) {
        ArrayList<Integer> lastRow = new ArrayList<Integer>();
        lastRow.add(1);
        if(rowIndex == 0){
            return lastRow;
        }

        for(int i=1; i <= rowIndex; i++){
            ArrayList<Integer> currentRow = computerCurrentRow(lastRow);
            lastRow = currentRow;
        }
        return lastRow;
    }

    private ArrayList<Integer> computerCurrentRow(ArrayList<Integer> lastRow){
        ArrayList<Integer> currentRow = new ArrayList<Integer>();
        currentRow.add(lastRow.get(0));
        for(int i=1; i<lastRow.size(); i++){
            currentRow.add(lastRow.get(i-1)+lastRow.get(i));
        }
        currentRow.add(lastRow.get(lastRow.size()-1));
        return currentRow;
    }
}
