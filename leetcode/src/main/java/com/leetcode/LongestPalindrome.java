package com.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: ravigummadi
 * Date: 3/5/13
 * Time: 7:56 AM
 * To change this template use File | Settings | File Templates.
 */
public class LongestPalindrome {

    Map<String, String> nodeCache = new HashMap<String, String>();

    public String longestPalindrome(String s){
        nodeCache = new HashMap<String, String>();
        return recLongestPalindrome(s);
    }

    public String recLongestPalindrome(String s) {
        if(s == null || s.length() < 2 || isPalindrome(s)){
            return s;
        }

        String prefixPalindrom = getFromCacheOrRecursive(s.substring(1));
        String suffixPalindrom = getFromCacheOrRecursive(s.substring(0, s.length() - 1));
        String midPalindrom = getFromCacheOrRecursive(s.substring(1, s.length() - 1));
        return maxOfThree(prefixPalindrom,suffixPalindrom,midPalindrom);
    }


    private String getFromCacheOrRecursive(String str){
        if(str == null || str.length() < 2 || isPalindrome(str)){
            return str;
        }
        String result = nodeCache.get(str.substring(1));
        if(result == null){
            result = recLongestPalindrome(str.substring(1));
            nodeCache.put(str.substring(1), result);
        }
        return result;
    }


    private String maxOfThree(String str1, String str2, String str3){
        if(str3.length() > str1.length()){
            if(str3.length() > str2.length()){
                return str3;
            }else{
                return str2;
            }
        }else{
            if(str1.length() > str2.length()){
                return str1;
            }else{
                return str2;
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
