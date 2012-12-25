package com.leetcode;

/**
 * Created with IntelliJ IDEA.
 * User: gummadi
 * Date: 12/24/12
 * Time: 7:06 PM
 * To change this template use File | Settings | File Templates.
 */
public class DistinctSubsequences {

    public int numDistinct(String S, String T) {
        // Start typing your Java solution below
        // DO NOT write main() function
        return recNumDistinct(S,T);

    }

    private int recNumDistinct(String S, String T){
        if(S.length()==0 && T.length()==0){
            return 1;
        }else if (S.length() < T.length()){
            return 0;
        }else{
            return recNumDistinct(S.substring(0,S.length()-1), T.substring(0,T.length()-1))
                    + recNumDistinct(S.substring(0,S.length()-1), T.substring(0,T.length()));
        }

    }
}
