package com.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * Created with IntelliJ IDEA.
 * User: gummadi
 * Date: 4/11/13
 * Time: 11:12 PM
 * To change this template use File | Settings | File Templates.
 */
public class MergeIntervals {
    public ArrayList<Interval> merge(ArrayList<Interval> intervals) {
        ArrayList<Interval> resultList = new ArrayList<Interval>();
        Collections.sort(intervals, new IntervalComparator());
        if(intervals.size() > 0){
            Interval prevInterval = intervals.get(0);
            for(int i=1; i<intervals.size(); i++){
                Interval currentInterval = intervals.get(i);
                if(prevInterval.end < currentInterval.start){
                    resultList.add(prevInterval);
                    prevInterval = currentInterval;
                }else{
                    prevInterval = new Interval(Math.min(prevInterval.start,currentInterval.start), Math.max(prevInterval.end,currentInterval.end));
                }
            }
            resultList.add(prevInterval);
        }
        return resultList;
    }

    private static class IntervalComparator implements Comparator<Interval>
    {
        @Override
        public int compare(Interval o1, Interval o2) {
            if(o1.start < o2.start)
                return -1;
            else if(o1.start > o2.start)
                return 1;
            else
                return 0;  //To change body of implemented methods use File | Settings | File Templates.
        }
    }

}
