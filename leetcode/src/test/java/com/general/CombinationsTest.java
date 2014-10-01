package com.general;

import com.common.CommonUtils;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ravigum on 9/25/2014.
 */
public class CombinationsTest {

    @Test
    public void testCombinations() {
        List<Character> charList = new ArrayList<>();
        charList.add('a');
        charList.add('b');
        charList.add('c');
        charList.add('d');
        System.out.println(CommonUtils.printList(charList));
        Combinations comb = new Combinations();
        comb.printCombinations(charList);
    }
}
