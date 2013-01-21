package com.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: ravigummadi
 * Date: 1/20/13
 * Time: 9:17 PM
 * To change this template use File | Settings | File Templates.
 */
public class ThreeSum {


    Map<Integer, Integer> value2PosMap;
    Map<TwoPair, Integer> twoPairSumMap;

    public int threeSumClosest(int[] num, int target) {
        // Start typing your Java solution below
        // DO NOT write main() function
        return 1;
    }

    public int threeSum(int[] num, int target){
        initTwoPairs(num);
        initIndexToValueMap(num);
        for(Map.Entry<TwoPair,Integer> entry : twoPairSumMap.entrySet()){
            int key = target - entry.getValue();
            if(value2PosMap.get(key) != null){
                int val = value2PosMap.get(key);
                if(val != entry.getKey().pos1 && val != entry.getKey().pos2){
                    System.out.println(num[entry.getKey().pos1] + ", " +  num[entry.getKey().pos2] + ", " + num[value2PosMap.get(key)]);
                }
            }
        }
        return 0;
    }


    private void initTwoPairs(int[] num){
        twoPairSumMap = new HashMap<TwoPair, Integer>();
        for(int i = 0; i < num.length; i++){
            for(int j = 0;j < num.length; j++){
                if( i != j){
                    twoPairSumMap.put(new TwoPair(i,j),num[i] + num[j]);
                }
            }
        }
    }

    private void initIndexToValueMap(int[] num){
        value2PosMap = new HashMap<Integer, Integer>();
        for(int i=0; i < num.length;i ++){
            value2PosMap.put(num[i],i);
        }
    }


    class TwoPair{
        int pos1;
        int pos2;

        public TwoPair(int pos1, int pos2){
            this.pos1 = pos1;
            this.pos2 = pos2;
        }

        @Override
        public boolean equals(Object other){
            if (other instanceof TwoPair){
                TwoPair otherTwoPair = (TwoPair)other;
                if (this == other){
                    return true;
                }else if(otherTwoPair.pos1 == this.pos1 && otherTwoPair.pos2 == this.pos2){
                    return true;
                }else{
                    return false;
                }
            }else{
                return false;
            }
        }


        @Override
        public int hashCode(){
            int result = 17;
            result = 31 * result + pos1;
            result = 31 * result + pos2;
            return result;
        }

    }
}
