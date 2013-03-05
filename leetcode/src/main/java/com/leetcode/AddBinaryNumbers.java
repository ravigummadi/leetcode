package com.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: ravigummadi
 * Date: 3/4/13
 * Time: 10:47 PM
 * To change this template use File | Settings | File Templates.
 */
public class AddBinaryNumbers {

    public String addBinary(String a, String b) {
        String reverseA = reverse(a);
        String reverseB = reverse(b);
        String result = "";
        int carry = 0;
        for(int i=0; i < reverseA.length() || i < reverseB.length(); i++){
            int intA = 0;
            if(i < reverseA.length()){
                intA = Integer.valueOf(reverseA.charAt(i) + "");
            }
            int intB = 0;
            if(i < reverseB.length()){
                intB = Integer.valueOf(reverseB.charAt(i) + "");
            }
            int remainder = (intA + intB + carry) % 2;
            carry = (intA + intB + carry) / 2;
            result += remainder;
        }
        if(carry == 1){
            result += carry;
        }
        return reverse(result);
    }

    private static String reverse(String str){
        char[] strChars = str.toCharArray();
        for(int i=0, j=strChars.length-1; i < j; i++, j--){
            char temp = strChars[j];
            strChars[j] = strChars[i];
            strChars[i] = temp;
        }
        return new String(strChars);
    }

}
