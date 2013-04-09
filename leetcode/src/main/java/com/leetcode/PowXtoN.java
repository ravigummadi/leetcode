package com.leetcode;

/**
 * Created with IntelliJ IDEA.
 * User: ravigummadi
 * Date: 4/8/13
 * Time: 11:57 PM
 * To change this template use File | Settings | File Templates.
 */
public class PowXtoN {

    public double pow(double x, int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        boolean isNegative = false;
        if(n < 0){
            isNegative = true;
            n = -1 * n;
        }
        double result = recPow(x,n);
        if(isNegative){
            result = 1/result;
        }
        return result;

    }


    private double recPow(double x, int n){
        if(n==0)
            return 1;
        int remainder = n % 2;
        double halfResult = recPow(x,n/2);
        return halfResult * halfResult * (remainder == 1 ? x : 1);
    }

}
