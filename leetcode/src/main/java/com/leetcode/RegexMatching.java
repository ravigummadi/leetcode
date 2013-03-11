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

        if(p == null || p.length()==0){
            if(s == null || s.length() == 0){
                return true;
            }else{
                return false;
            }
        }

        if(s == null || s.length() == 0){
            if(p.length() == 1 && p.charAt(0) == '*'){
                return true;
            }else{
                return false;
            }
        }

        if(s.equals(p)){
            return true;
        }


        if(p.charAt(0) == '.'){
            return isRecursiveMatch(s.substring(1),p.substring(1),p.charAt(0));
        }

        if(p.charAt(0) == '*'){
            if(prevChar == '.' || s.charAt(0) == prevChar){
                return isRecursiveMatch(s.substring(1),p,prevChar) ||
                        isRecursiveMatch(s.substring(1),p.substring(1),prevChar);
            }else{
                return isRecursiveMatch(s,p.substring(1),p.charAt(0));
            }
        }

        if(s.charAt(0) != p.charAt(0)){
            if(!isNextChar(p,'*')){
                return false;
            }else{
                return isRecursiveMatch(s,p.substring(2),p.charAt(1));
            }
        }else{
            return isRecursiveMatch(s.substring(1),p.substring(1),p.charAt(0));
        }

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
