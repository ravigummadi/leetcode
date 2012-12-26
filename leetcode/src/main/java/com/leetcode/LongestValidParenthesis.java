package com.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: ravigummadi
 * Date: 12/25/12
 * Time: 8:53 PM
 * To change this template use File | Settings | File Templates.
 */
public class LongestValidParenthesis {

    List<ParenCount> list;
    ParenCount pc;

    public int longestValidParentheses(String s) {
        list = new ArrayList<ParenCount>();
        pc = new ParenCount();
        coundAndAddParensToList(s);
        int rightParenCount = getMaxRightParens(list);
        return rightParenCount * 2;
    }


    private void coundAndAddParensToList(String s){
        for(char c : s.toCharArray()){
            if (c == ')'){
                pc.rightParen++;
            }else if(c == '('){
                pc.leftParen++;
            }
            if(pc.rightParen > pc.leftParen){
                pc.rightParen--;
                if(pc.leftParen == 0){
                    continue;
                }
                else{
                    list.add(pc);
                    pc = new ParenCount();
                }
            }
        }
        list.add(pc);
    }

    private int countAllRightParens(List<ParenCount> list){
        int totalRightParenCount = 0;
        for(ParenCount pcObj : list){
            totalRightParenCount+= pcObj.rightParen;
        }
        return totalRightParenCount;
    }

    private int getMaxRightParens(List<ParenCount> list){
        int maxRightParenCount = 0;
        for(ParenCount pcObj : list){
            if(pcObj.rightParen > maxRightParenCount){
                maxRightParenCount = pcObj.rightParen;
            }
        }
        return maxRightParenCount;
    }


    class ParenCount{
        int rightParen = 0;
        int leftParen = 0;
    }

}
