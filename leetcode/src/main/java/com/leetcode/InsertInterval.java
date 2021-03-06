package com.leetcode;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created with IntelliJ IDEA.
 * User: ravigummadi
 * Date: 3/20/13
 * Time: 11:34 PM
 * To change this template use File | Settings | File Templates.
 */
public class InsertInterval {

    public ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) {
        ArrayList<Interval> resultSet = new ArrayList<Interval>();
        Iterator<Interval> intervalIterator = intervals.iterator();
        while(intervalIterator.hasNext()){
            Interval current = intervalIterator.next();
            intervalIterator.remove();
            int result = compareIntervals(newInterval, current);
            if(result == -1){
                resultSet.add(newInterval);
                resultSet.add(current);
                addRemainingToList(resultSet, intervals);
                return resultSet;
            }else if(result == 1){
                resultSet.add(current);
            }else{
                // Super awesome trick stolen from Di!
                newInterval = new Interval(Math.min(current.start, newInterval.start), Math.max(current.end, newInterval.end));
            }
        }
        resultSet.add(newInterval);
        return resultSet;
    }

    private void addRemainingToList(ArrayList<Interval> resultSet, ArrayList<Interval> original){
        for(Interval interval : original){
            resultSet.add(interval);
        }
        return;
    }

    private int compareIntervals(Interval first, Interval second){
        if(first.end < second.start){
            return -1;
        }else if(first.start > second.end){
           return 1;
        }else{
            return 0;
        }
    }
}


class Interval{
    int start;
    int end;
    Interval() { start = 0; end = 0;}
    Interval(int s,int e) {start =s; end = e;}
    public String toString(){
        return "[" + start + ", " + end + "]";
    }
}
