package com.workday;

/**
 * Created by Ravi on 2/5/2015.
 */
public class RangeContainerFactoryImpl implements RangeContainerFactory {
    @Override
    public RangeContainer createContainer(long[] data) {
        return new TreeRangeContainer(data);
    }
}
