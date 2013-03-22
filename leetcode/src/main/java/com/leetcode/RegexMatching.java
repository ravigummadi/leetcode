package com.leetcode;

/**
 * Created with IntelliJ IDEA.
 * User: ravigummadi
 * Date: 3/9/13
 * Time: 10:58 PM
 * To change this template use File | Settings | File Templates.
 */
public class RegexMatching {

    public boolean isMatch(String s, String p) {
        return isRecursiveMatch(s,p,'!');
    }

    private boolean isRecursiveMatch(String s, String p, char prevChar){
        if(s.equals(p)) return true;
        return false;
    }


    private boolean isNextChar(String str, char c){
        if(str.length()>1){
            if(str.charAt(1)==c){
                return true;
            }
        }
        return false;
    }
}
