package com.workday;

import java.util.*;

/**
 * Created by Ravi on 2/5/2015.
 */
public class TreeRangeContainer implements RangeContainer {

    private TreeMap<Long, Short> rangeIndex = new TreeMap<>();

    public TreeRangeContainer(long[] data){
        for(short i=0; i < data.length; i++) {
            rangeIndex.put(data[i], i);
        }
    }

    @Override
    public Ids findIdsInRange(long fromValue, long toValue, boolean fromInclusive, boolean toInclusive) {
        NavigableMap<Long, Short> idsInRange = rangeIndex.subMap(fromValue, fromInclusive, toValue, toInclusive);
        List<Short> idList = new ArrayList<>(idsInRange.values());
        Collections.sort(idList);
        Ids ids = new IdsEnumeration(Collections.enumeration(idList));
        return ids;
    }
}
