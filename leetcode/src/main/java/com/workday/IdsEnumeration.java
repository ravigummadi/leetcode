package com.workday;

import java.util.Collection;
import java.util.Enumeration;

/**
 *
 * This is a wrapper around the Enumeration returned by the RangeContainer with the sorted list of Ids
 */
public class IdsEnumeration implements Ids{

    private Enumeration<Short> idCollection;

    public IdsEnumeration(Enumeration<Short> idCollection){
        this.idCollection = idCollection;
    }

    @Override
    public short nextId() {
        if(idCollection.hasMoreElements())
            return idCollection.nextElement();
        else
            return END_OF_IDS;
    }
}
