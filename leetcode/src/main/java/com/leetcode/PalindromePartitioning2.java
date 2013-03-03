package com.leetcode;

/**
 * Created with IntelliJ IDEA.
 * User: gummadi
 * Date: 3/2/13
 * Time: 10:38 PM
 * To change this template use File | Settings | File Templates.
 */
public class PalindromePartitioning2 {

    public int minCut(String s) {
        return recursiveMinCut(s);
    }

    private int recursiveMinCut(String s){
        if(s == null || s.length() <= 1 || isPalindrome(s)){
            return 0;
        }else{
            int currentMin = Integer.MAX_VALUE;
            for(int i=1; i < s.length(); i++){
                if(isPalindrome(s.substring(i,s.length()))){
                    currentMin = Math.min(currentMin, 1 + recursiveMinCut(s.substring(0,i)));
                }
            }
            return currentMin;
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
