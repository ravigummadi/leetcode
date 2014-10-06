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
        newNode.next = null;
        return head;
    }

    public static ListNode insertionSort(ListNode head){
        ListNode newHead = null;
        ListNode current = head;
        while(current != null){
            ListNode nextNode = current.next;
            newHead = sortedInsert(newHead, current);
            current = nextNode;
        }
        return newHead;
    }


    public static ListNode insertAfterNode(ListNode currentNode, int value){
        ListNode newNode = new ListNode(value);
        newNode.next = currentNode.next;
        currentNode.next = newNode;
        return currentNode;
    }

    public static ListNode[] frontBackSplit(ListNode head){

        ListNode[] firstSecond = new ListNode[2];

        if(head == null) return firstSecond;
        if(head.next == null) {
            firstSecond[0] = head;
            return firstSecond;
        }

        ListNode slowCurrentHeadTrailer = head;
        ListNode slowCurrentHead = head;
        ListNode fastCurrentHead = head;

        while(fastCurrentHead.next != null && fastCurrentHead.next.next != null){
            slowCurrentHeadTrailer = slowCurrentHead;
            slowCurrentHead = slowCurrentHead.next;
            fastCurrentHead = fastCurrentHead.next.next;
        }

        if(fastCurrentHead!= null){
            slowCurrentHeadTrailer = slowCurrentHead;
            slowCurrentHead = slowCurrentHead.next;
        }

        slowCurrentHeadTrailer.next = null;
        firstSecond[0] = head;
        firstSecond[1] = slowCurrentHead;
        return firstSecond;
    }


    public static ListNode[] frontBackSplit2(ListNode head){
        ListNode[] firstSecond = new ListNode[2];
        if(head == null) return firstSecond;
        if(head.next == null) {
            firstSecond[0] = head;
            return firstSecond;
        }

        ListNode slowCurrent = head;
        ListNode fastCurrent = head.next;

        while(fastCurrent != null && fastCurrent.next != null){
            slowCurrent = slowCurrent.next;
            fastCurrent = fastCurrent.next.next;
        }

        firstSecond[0] = head;
        firstSecond[1] = slowCurrent.next;
        slowCurrent.next = null;
        return  firstSecond;
    }


    public static ListNode removeDuplicates(ListNode head){
        ListNode newHead = null;
        if(head == null) return head;

        ListNode current = head.next;
        newHead = insertAtHead(newHead, head);
        ListNode newCurrent = newHead;
        int lastVal = newCurrent.val;
        while(current != null){
            ListNode nextNode = current.next;
            current.next = null;
            if(lastVal != current.val){
                newCurrent = insertAfterNode(newCurrent, current);
                newCurrent = newCurrent.next;
                lastVal = current.val;
            }
            current = nextNode;
        }
        return newHead;
    }


    public static ListNode removeDuplicates2(ListNode head){
        if(head == null) return head;
        ListNode current = head;
        while(current != null && current.next != null){
            if(current.val == current.next.val) {
                current.next = current.next.next;
            }
            current = current.next;
        }
        return head;
    }

    public static ListNode[] moveNode(ListNode head1, ListNode head2){
        if(head2 != null) {
            ListNode head2Copy = head2;
            head2 = head2.next;
            head1 = insertAtHead(head1, head2Copy);
        }
        return new ListNode[]{head1, head2};
    }

    public static ListNode[] alternatingSplit(ListNode head){
        ListNode head1 = null;
        ListNode head2 = null;
        boolean isHead1 = true;
        ListNode[] newHeads;
        while(head != null){
            if(isHead1) {
                newHeads = moveNode(head1, head);
                head1 = newHeads[0];
                head= newHeads[1];
                isHead1 = false;
            }else {
                newHeads = moveNode(head2, head);
                head2 = newHeads[0];
                head = newHeads[1];
                isHead1 = true;
            }
        }
        return new ListNode[]{head1, head2};
    }

    public static ListNode sortedMerge(ListNode head1, ListNode head2){
        if(head1 == null) return head2;
        if(head2 == null) return head1;

        ListNode newHead = null;
        ListNode currentHead1 = head1;
        ListNode currentHead2 = head2;
        while(currentHead1 != null && currentHead2 != null){
            if(currentHead1.val < currentHead2.val){
                ListNode[] updatedNodes = moveNode(newHead, currentHead1);
                newHead =
            }
        }


    }



    public static ListNode insertAfterNode(ListNode currentNode, ListNode newNode){
        newNode.next = currentNode.next;
        currentNode.next = newNode;
        return currentNode;
    }

    public static ListNode insertAtTail(ListNode currentNode, ListNode newNode){
        currentNode.next = newNode;
        newNode.next = null;
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
