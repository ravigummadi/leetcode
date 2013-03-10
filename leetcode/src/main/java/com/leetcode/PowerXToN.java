package com.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: ravigummadi
 * Date: 3/9/13
 * Time: 6:29 PM
 * To change this template use File | Settings | File Templates.
 */
public class PowerXToN {

    public double pow(double x, int n) {
        if(n == 0){
            return 1;
        }

        if (n < 0){
            n = n * -1;
            x = 1/x;
        }

        if(n % 2 == 1){
            return pow(x,n/2) * pow(x,n/2) * x;
        }else{
            return pow(x,n/2) * pow(x,n/2);
        }

    }

    public double pow2(double x, int n){
        if(n == 0){
            return 1;
        }

        if(n == 1){
            return x;
        }

        if (n < 0){
            n = n * -1;
            x = 1/x;
        }

        Map<Integer,Double> cache = new HashMap<Integer, Double>();
        if(cache.get(n/2) == null){
            double val = pow2(x,n/2);
            cache.put(n/2, val);
        }

        if(n % 2 == 1){
            return cache.get(n/2) * cache.get(n/2) * x;
        }else{
            return cache.get(n/2) * cache.get(n/2);
        }
    }

}
