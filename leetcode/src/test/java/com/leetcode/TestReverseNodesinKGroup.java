package com.leetcode;

import org.junit.Test;

/**
 * Created with IntelliJ IDEA.
 * User: gummadi
 * Date: 3/28/13
 * Time: 10:08 PM
 * To change this template use File | Settings | File Templates.
 */
public class TestReverseNodesinKGroup {

    @Test
    public void testReverse(){
        ListNode head = new ListNode(4);
        head.next = new ListNode(5);
        head.next.next = new ListNode(6);
        head.next.next.next = new ListNode(8);
        head.next.next.next.next = new ListNode(9);
        head.next.next.next.next.next = new ListNode(12);

        ReverseNodesinKGroup reverse = new ReverseNodesinKGroup();
        ListNode newHead = reverse.reverseKGroup(head,3);
        System.out.println(newHead);
    }

}
