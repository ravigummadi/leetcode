package com.leetcode;

import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * User: ravigummadi
 * Date: 12/27/12
 * Time: 12:10 PM
 * To change this template use File | Settings | File Templates.
 */
public class MinimumWindowSubstring {

    // A stack-like behavior to track the what characters are left
    List<Character> charList;
    // A map of the position to characters. Makes it easy to pop out the first item
    Map<Integer,Character> posCharMap;
    // A set for fast verification of whether the character is present in input and store positions
    Map<Character,PriorityQueue<Integer>> charPosMap;

    int minWindowSize;
    int windowPos[];


    public String minWindow(String S, String T) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (T.length() > S.length())
            return "";
        minWindowSize = Integer.MAX_VALUE;
        windowPos = new int[]{-1,-1};
        posCharMap= new TreeMap<Integer, Character>();
        convertTtoList(T);
        findWindow(S);
        try{
             return S.substring(windowPos[0],windowPos[1]+1);
        }catch(IndexOutOfBoundsException ioe){
            return "";
        }
    }

    private void convertTtoList(String T){
        charList = new ArrayList<Character>();
        charPosMap = new HashMap<Character, PriorityQueue<Integer>>();
        for(char c : T.toCharArray()){
            charList.add(c);
            charPosMap.put(c,new PriorityQueue<Integer>());
        }
    }


    private void findWindow(String S){
        for(int i=0; i < S.length(); i++){
            Character c = S.charAt(i);
           if(charPosMap.containsKey(c)){
                if(charList.contains(c)){
                    charList.remove(c);
                }else{
                    int lastPos = charPosMap.get(c).poll();
                    posCharMap.remove(lastPos);
                }
                posCharMap.put(i,c);
                charPosMap.get(c).add(i);

               if(charList.isEmpty()){
                   updateWindowSize(c);
               }
           }
        }
    }

    private void updateWindowSize(Character lastChar){

        Integer[] posSet = posCharMap.keySet().toArray(new Integer[0]);
        int startPos = posSet[0];
        int lastPos = posSet[posSet.length-1];
        int currentWindowSize = lastPos - startPos;
        if(currentWindowSize < minWindowSize && currentWindowSize >= 0){
            minWindowSize = currentWindowSize;
            windowPos[0] = startPos;
            windowPos[1] = lastPos;
        }
        charList.add(posCharMap.remove(startPos));
    }

}
