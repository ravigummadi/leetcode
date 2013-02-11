package com.leetcode;

/**
 * Created with IntelliJ IDEA.
 * User: ravigummadi
 * Date: 2/10/13
 * Time: 8:04 PM
 * To change this template use File | Settings | File Templates.
 */
public class DistinctSubsequenceIterative {

    public int numDistinct(String S, String T) {
        int width = S.length()+1;
        int height = T.length()+1;
        if(height > width)
            return 0;
        int M[][] = new int[width][height];
        initMatrix(M,width,height);

        for(int i=1; i < width; i++){
            for(int j=1; j <= i; j++){
                if(S.charAt(i-1) == T.charAt(j-1)){
                    M[i][j] = M[i-1][j-1] + M[i-1][j];
                }else{
                    M[i][j] = 0;
                }
            }
        }
        return M[width-1][height-1];
    }

    private void initMatrix(int[][] M,int width, int height){
        for(int i=0; i < width; i++){
            M[i][0] = 1;
        }
    }

}
