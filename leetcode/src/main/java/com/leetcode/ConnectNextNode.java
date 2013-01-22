package com.leetcode;

/**
 * Created with IntelliJ IDEA.
 * User: ravigummadi
 * Date: 1/21/13
 * Time: 10:18 PM
 * To change this template use File | Settings | File Templates.
 */
public class ConnectNextNode {

    public void connect(TreeLinkNode root) {
        recursiveConnect(root);
    }

    private void recursiveConnect(TreeLinkNode current){
        if(current == null)
            return;

        if(current.left != null){
            if(current.right != null){
                current.left.next = current.right;
            }else{
                current.left.next = getAdjacentNode(current);
            }
        }

        if(current.right != null){
            current.right.next = getAdjacentNode(current);
        }
        recursiveConnect(current.left);
        recursiveConnect(current.right);
    }


    private TreeLinkNode getAdjacentNode(TreeLinkNode current){
        if(current.next == null)
            return null;
        if(current.next.left != null){
            return current.next.left;
        }else if(current.next.right != null){
            return current.next.right;
        }else if(current.next.next != null){
            return getAdjacentNode(current.next.next);
        }
        return null;
    }
}
