package com.leetcode;

/**
 * Created with IntelliJ IDEA.
 * User: ravigummadi
 * Date: 1/31/13
 * Time: 10:18 PM
 * To change this template use File | Settings | File Templates.
 */
public class DecodeWays {

    int count = 0;

    public int numDecodings(String s) {
        count = 0;
        if(s != null && s.length()>0)
            recNumDecodings(s);
        return  count;
    }

    private void recNumDecodings(String s){
        if(s == null || s.length() == 0 ){
            count++;
            return;
        }

        if(s.length() > 0){
            if(s.charAt(0) == '0')
                return;
            else{
                recNumDecodings(s.substring(1));
            }
        }

        if(s.length() > 1){
            int twoDigitNum = Integer.parseInt(s.substring(0,2));
            if(twoDigitNum < 10 || twoDigitNum > 26){
                return;
            }else{
                recNumDecodings(s.substring(2));
            }
        }

    }

}

