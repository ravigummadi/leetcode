package com.leetcode;

import java.util.ArrayList;
import java.util.Iterator;
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
    int maxRightParenCount;
    int currentRightParenCount;

    public int longestValidParentheses(String s) {
        list = new ArrayList<ParenCount>();
        pc = new ParenCount();
        coundAndAddParensToList(s);
        return maxRightParenCount * 2;
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
                updateMaxParenCount(list);
                continue;
            }
            if(pc.leftParen > 0 && pc.rightParen == pc.leftParen){
                list.add(pc);
                pc = new ParenCount();
            }
        }
        if(pc.leftParen > 0){
            list.add(pc);
        }
        updateMaxParenCount(list);
    }

    private void updateMaxParenCount(List<ParenCount> list){
        Iterator<ParenCount> it = list.iterator();
        while(it.hasNext()){
            ParenCount pcObj = it.next();
            if(pcObj.rightParen != pcObj.leftParen){
                currentRightParenCount = pcObj.rightParen;
            }else{
                currentRightParenCount+=pcObj.rightParen;
            }
            it.remove();

            if(currentRightParenCount > maxRightParenCount){
                maxRightParenCount = currentRightParenCount;
            }

        }

        currentRightParenCount = 0;
    }


    class ParenCount{
        int rightParen = 0;
        int leftParen = 0;
    }

}
