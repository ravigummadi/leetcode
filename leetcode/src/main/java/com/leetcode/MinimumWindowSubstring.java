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

    List<Character> charList;
    Map<Integer,Character> posCharMap;
    int minWindowSize;
    int windowPos[];
    Set<Character> charSet;

    public String minWindow(String S, String T) {
        // Start typing your Java solution below
        // DO NOT write main() function
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
        charSet = new HashSet<Character>();
        for(char c : T.toCharArray()){
            charList.add(c);
            charSet.add(c);
        }
    }


    private void findWindow(String S){
        for(int i=0; i < S.length(); i++){
            Character c = S.charAt(i);
           if(charSet.contains(c)){
                if(charList.contains(c)){
                    charList.remove(c);
                }else{
                    removeCharFromMap(c);
                }
                posCharMap.put(i,c);

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


    private void removeCharFromMap(Character c){
        for(Map.Entry entry : posCharMap.entrySet()){
            if(entry.getValue() == c){
                posCharMap.remove(entry.getKey());
                return;
            }
        }
    }

}
