package com.leetcode;

import org.junit.Test;

import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: ravigummadi
 * Date: 3/21/13
 * Time: 9:40 AM
 * To change this template use File | Settings | File Templates.
 */
public class InsertIntervalTest {

    @Test
    public void testInsert(){
        ArrayList<Interval> list = new ArrayList<Interval>();
        list.add(new Interval(1,2));
        list.add(new Interval(3,5));
        list.add(new Interval(6,7));
        list.add(new Interval(8,10));
        list.add(new Interval(12,16));
        InsertInterval insertInterval = new InsertInterval();
        ArrayList<Interval> result = insertInterval.insert(list, new Interval(4,9));
        for(Interval interval : result){
            System.out.println(interval);
        }
    }

}
