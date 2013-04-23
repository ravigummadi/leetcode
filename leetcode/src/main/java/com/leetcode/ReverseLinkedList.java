package com.leetcode;

/**
 * Created with IntelliJ IDEA.
 * User: gummadi
 * Date: 4/12/13
 * Time: 7:59 AM
 * To change this template use File | Settings | File Templates.
 */
public class ReverseLinkedList {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode dummy = new ListNode(-9999);
        dummy.next = head;
        ListNode pre = dummy;
        ListNode current = dummy.next;
        int i = 1;
        while(i != m){
            pre = pre.next;
            current = current.next;
            i++;
        }

        ListNode nCurrent = current;
        ListNode nextElem;
        ListNode reverseHead = new ListNode(-999);


        while(i <= n){
            nextElem = nCurrent.next;
            addToHead(reverseHead, nCurrent);
            nCurrent = nextElem;
            i++;
        }

        current.next = nCurrent;
        pre.next = reverseHead.next;
        return dummy.next;
    }

    private void addToHead(ListNode reverse, ListNode current){
        current.next = reverse.next;
        reverse.next = current;
    }

}
