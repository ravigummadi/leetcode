package com.leetcode;

import org.junit.Test;

/**
 * Created with IntelliJ IDEA.
 * User: gummadi
 * Date: 4/12/13
 * Time: 1:55 AM
 * To change this template use File | Settings | File Templates.
 */
public class RotateListTest {
    @Test
    public void testRotateList(){
        RotateList rList = new RotateList();
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        rList.rotateRight(head,1);
    }

}
