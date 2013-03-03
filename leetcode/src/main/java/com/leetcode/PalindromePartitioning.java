package com.leetcode;

import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: gummadi
 * Date: 3/2/13
 * Time: 10:21 PM
 * To change this template use File | Settings | File Templates.
 */
public class PalindromePartitioning {
    ArrayList<ArrayList<String>> allPartitions;

    public ArrayList<ArrayList<String>> partition(String s) {
        allPartitions  = new ArrayList<ArrayList<String>>();
        recursivePartition(s,new ArrayList<String>());
        return allPartitions;
    }

    private void recursivePartition(String restString, ArrayList<String> combinations){
        if(restString == null || restString.length()==0){
            allPartitions.add(new ArrayList<String>(combinations));
            return;
        }

        for(int i=0; i < restString.length(); i++){
            String currentString = restString.substring(0,i+1);
            if(isPalindrome(currentString)){
                combinations.add(currentString);
                recursivePartition(restString.substring(i+1), combinations);
                combinations.remove(currentString);
            }
        }
    }

    private boolean isPalindrome(String s){
        if(s == null || s.length()==0)
            return false;
        for(int i=0, j=s.length()-1; i < j;i++,j--){
            if(s.charAt(i) != s.charAt(j))
                return false;
        }
        return true;
    }

}
