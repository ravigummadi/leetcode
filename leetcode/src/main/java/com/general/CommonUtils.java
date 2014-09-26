package com.general;

import java.util.List;

/**
 * Created by ravigum on 9/25/2014.
 */
public class CommonUtils {

    public static <T> String printList(List<T> printList){
        StringBuilder sb = new StringBuilder();
        printList.stream().forEach(obj -> sb.append(obj));
        return sb.toString();
    }
}
