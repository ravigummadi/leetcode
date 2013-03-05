package com.leetcode;

import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * User: ravigummadi
 * Date: 3/5/13
 * Time: 7:32 AM
 * To change this template use File | Settings | File Templates.
 */
public class LetterCombinationsOfAPhoneNumber {

    static Map<Character,List<Character>> charMap = new HashMap<Character, List<Character>>();

    static{
        charMap.put('2',Arrays.asList('a','b','c'));
        charMap.put('3',Arrays.asList('d','e','f'));
        charMap.put('4',Arrays.asList('g','h','i'));
        charMap.put('5',Arrays.asList('j','k','l'));
        charMap.put('6',Arrays.asList('m','n','o'));
        charMap.put('7',Arrays.asList('p','q','r','s'));
        charMap.put('8',Arrays.asList('t','u','v'));
        charMap.put('9',Arrays.asList('w','x','y','z'));
    }

    public ArrayList<String> letterCombinations(String digits) {
        ArrayList<String> combinationList = new ArrayList<String>();
        recursiveCombinations("",digits,combinationList);
        return combinationList;
    }

    private void recursiveCombinations(String sofar, String digitsRemaining, ArrayList<String> combinationList){
        if(digitsRemaining == null || digitsRemaining.length()==0){
            combinationList.add(sofar);
            return;
        }

        Character currentDigit = digitsRemaining.charAt(0);
        List<Character> charList = charMap.get(currentDigit);
        for(char c : charList){
            recursiveCombinations(sofar + c, digitsRemaining.substring(1),combinationList);
        }
    }
}
