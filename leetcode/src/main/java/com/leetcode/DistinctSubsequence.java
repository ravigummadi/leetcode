package com.leetcode;

/**
 * Created with IntelliJ IDEA.
 * User: gummadi
 * Date: 12/24/12
 * Time: 7:47 PM
 * To change this template use File | Settings | File Templates.
 */
public class DistinctSubsequence {

    public int numDistinct(String S, String T) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int[][] M = new int[S.length()][T.length()];
        initializeMatrix(M, S.length(), T.length());
        return recNumDistinct(S,T);
    }

    private int recNumDistinct(String S, String T){
        System.out.println(S + " " + T);
        if(S.length() >=0 && T.length()==0){
            return 1;
        }else if(S.length() < T.length() || T.length()==0){
            return 0;
        }else {
            if(S.charAt(S.length()-1) == T.charAt(T.length()-1)){
                return recNumDistinct(S.substring(0,S.length()-1),T.substring(0,T.length()-1)) +
                        recNumDistinct(S.substring(0,S.length()-1),T.substring(0,T.length()));
            }else{
                return recNumDistinct(S.substring(0,S.length()-1),T.substring(0,T.length()));
            }
        }
    }

    private void initializeMatrix(int[][] M,int x, int y){
        for(int i=0; i < )
    }

    private void dynamicNumDistinct(String S, String T,int[][] M){


    }


}
