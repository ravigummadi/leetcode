package com.general;

import com.common.ListNode;

/**
 * Created by Ravi on 10/1/2014.
 */
public class LinkedListOperations {

    public static ListNode insertNth(ListNode head, int pos, int value){
        if(pos == 0) {
            return insertAtHead(head, value);
        }

        ListNode current = head;
        int currentPos = 0;
        while(current != null){
            if(currentPos == pos-1){
                insertAfterNode(current, value);
                return head;
            }else{
                current = current.next;
                currentPos++;
            }
        }
        throw new IllegalArgumentException("pos is greater than list lenght");
    }


    public static ListNode sortedInsert(ListNode head, ListNode newNode){
        if(head == null || head.val > newNode.val)
            return insertAtHead(head, newNode);

        ListNode current = head;
        while(current != null && current.next != null){
            if(current.next.val > newNode.val){
                insertAfterNode(current, newNode);
                return head;
            }
            current = current.next;
        }
        current.next = newNode;
        return head;
    }


    public static ListNode insertAfterNode(ListNode currentNode, int value){
        ListNode newNode = new ListNode(value);
        newNode.next = currentNode.next;
        currentNode.next = newNode;
        return currentNode;
    }

    public static ListNode insertAfterNode(ListNode currentNode, ListNode newNode){
        newNode.next = currentNode.next;
        currentNode.next = newNode;
        return currentNode;
    }

    public static ListNode insertAtHead(ListNode currentNode, int value){
        ListNode newNode = new ListNode(value);
        newNode.next = currentNode;
        return newNode;
    }

    public static ListNode insertAtHead(ListNode currentNode, ListNode newNode){
        newNode.next = currentNode;
        return newNode;
    }

}
