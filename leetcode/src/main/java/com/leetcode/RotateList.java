package com.leetcode;

/**
 * Created with IntelliJ IDEA.
 * User: gummadi
 * Date: 4/12/13
 * Time: 1:27 AM
 * To change this template use File | Settings | File Templates.
 */
public class RotateList {
    public ListNode rotateRight(ListNode head, int n) {
        if(head == null || head.next == null || n == 0){
            return head;
        }
        n = n % lengthOfList(head);
        if(n == 0)
            return head;
        ListNode leadNode = head;
        ListNode trailNode = head;
        for(int i=0; i < n; i++){
            leadNode = leadNode.next;
        }

        while(leadNode != null){
            trailNode = trailNode.next;
            leadNode = leadNode.next;
        }

        ListNode tNode2 = trailNode;
        while(tNode2.next != null){
            tNode2 = tNode2.next;
        }
        tNode2.next = head;
        ListNode current = head;
        while(current.next != trailNode){
            current = current.next;
        }
        current.next = null;
        head = trailNode;
        return head;
    }

    private int lengthOfList(ListNode head){
        int length = 0;
        ListNode current = head;
        while(current != null){
            length++;
            current = current.next;
        }
        return length;
    }
}
