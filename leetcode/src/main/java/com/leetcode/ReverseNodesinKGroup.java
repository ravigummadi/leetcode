package com.leetcode;

import java.util.Stack;

/**
 * Created with IntelliJ IDEA.
 * User: gummadi
 * Date: 3/27/13
 * Time: 11:29 PM
 * To change this template use File | Settings | File Templates.
 */
public class ReverseNodesinKGroup {

    Stack<ListNode> nodeStack;

    public ListNode reverseKGroup(ListNode head, int k){
        nodeStack = new Stack<ListNode>();
        ListNode currentNode = head;
        if(pushNextKNodesToStack(currentNode,k)){
            NodePair pair  = reverseNodesInStack(currentNode);
            head = pair.node1;
            currentNode = pair.node2;
            while(currentNode.next != null){
                if(pushNextKNodesToStack(currentNode.next,k)){
                    NodePair pair2 = reverseNodesInStack(currentNode);
                    currentNode.next = pair2.node1;
                    currentNode = pair2.node1;
                }else{
                    break;
                }
            }
        }
        return head;
    }

    private boolean pushNextKNodesToStack(ListNode currentNode, int k){
        for(int i=1; currentNode != null && i <= k; currentNode=currentNode.next, i++){
            nodeStack.push(currentNode);
        }
        if(nodeStack.size() == k){
            return true;
        }else{
            return false;
        }
    }

    private NodePair reverseNodesInStack(ListNode currentNode){
        ListNode lastNode = nodeStack.peek().next;
        ListNode headNode = nodeStack.peek();
        while(!nodeStack.empty()){
            currentNode.next = nodeStack.pop();
            currentNode = currentNode.next;
        }
        currentNode.next = lastNode;
        return new NodePair(headNode,currentNode);
    }

    class NodePair{
        ListNode node1;
        ListNode node2;
        public NodePair(ListNode node1, ListNode node2){
            this.node1 = node1;
            this.node2 = node2;
        }
    }
}

class ListNode {
     int val;
     ListNode next;
     ListNode(int x) {
         val = x;
         next = null;
     }
}
