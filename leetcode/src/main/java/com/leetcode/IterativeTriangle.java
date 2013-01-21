package com.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: ravigummadi
 * Date: 1/21/13
 * Time: 1:28 PM
 * To change this template use File | Settings | File Templates.
 */
public class IterativeTriangle {


    private Map<TwoPair,Integer> arraySum;

    private int getMinSum(ArrayList<ArrayList<Integer>> triangle){
        if (triangle.size() == 1) {
            return triangle.get(0).get(0);
        }
        initArraySum(triangle);
        for(int i=triangle.size()-2; i >= 0; i--){
            List<Integer> currentList = triangle.get(i);
            for(int j=0; j < currentList.size(); j++){
                arraySum.put(new TwoPair(i,j),
                        currentList.get(j)+Math.min(
                                arraySum.get(new TwoPair(i+1,j)),
                                arraySum.get(new TwoPair(i+1,j+1))
                        ));
            }
        }
        return arraySum.get(new TwoPair(0,0));
    }

    private void initArraySum(ArrayList<ArrayList<Integer>> triangle){
        arraySum = new HashMap<TwoPair, Integer>();
        List<Integer> finalArray = triangle.get(triangle.size()-1);
        int index = triangle.size()-1;
        for(int i=0; i < finalArray.size(); i++){
            arraySum.put(new TwoPair(index,i),finalArray.get(i));
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


