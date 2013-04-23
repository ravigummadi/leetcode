package com.leetcode;

import org.junit.Test;

/**
 * Created with IntelliJ IDEA.
 * User: gummadi
 * Date: 4/22/13
 * Time: 1:07 AM
 * To change this template use File | Settings | File Templates.
 */
public class ReverseLinkedListTest {

    @Test
    public void testReverse(){
        ListNode head = new ListNode(-1);
        head.next = new ListNode(-3);
        ReverseLinkedList rll = new ReverseLinkedList();
        rll.reverseBetween(head,2,2);
    }

}
