package com.general;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Ravi on 10/8/2014.
 */
public class CommonProblems {

    public int atoi(String str){
        if(str.isEmpty()) return 0;
        str = str.trim();
        boolean isNegative = false;
        int currentIndex = 0;
        if(str.charAt(0) == '-') {
            isNegative = true;
            currentIndex++;
        }else if(str.charAt(0) == '+')
        {
            isNegative = false;
            currentIndex++;
        }
        long num = 0;
        while(currentIndex < str.length()){
            char currentChar = str.charAt(currentIndex);
            int diff = currentChar - '0';
            if(diff >=  0 && diff <=9) {
                num = (num * 10) + diff;
                currentIndex++;
            }else{
                break;
            }
        }
        return (int) (isNegative ? -1 * num : num);
    }

    public String itoa(int num){
        return "";
    }

}
