package com.leetcode;

/**
 * Created with IntelliJ IDEA.
 * User: gummadi
 * Date: 2/25/13
 * Time: 11:06 PM
 * To change this template use File | Settings | File Templates.
 */
public class RecoverBST {

    NodePair first;
    NodePair second;
    TreeNode previous;

    public void recoverTree(TreeNode root) {
        first = null;
        second = null;
        previous = null;
        inorderTraversal(root);
        swapNodes(first,second);
    }

    private void inorderTraversal(TreeNode current){
        if(current == null){
            return;
        }
        inorderTraversal(current.left);
        visit(current);
        inorderTraversal(current.right);
    }


    private void visit(TreeNode current){
        if(previous != null){
            if(previous.val < current.val){
                if(first == null){
                    first = new NodePair();
                    first.first = previous;
                    first.second = current;
                }else{
                    second = new NodePair();
                    second.first = previous;
                    second.second = current;
                }
            }
        }
        previous = current;
    }

    private void swapNodes(NodePair first, NodePair second){
       if(first == null){
           return;
       }else{
           if(second == null){
               int temp = first.first.val;
               first.first.val = first.second.val;
               first.second.val = temp;
           }else{
               int temp = first.first.val;
               first.first.val = second.second.val;
               second.second.val = temp;
           }
       }
    }


    class NodePair{
        TreeNode first;
        TreeNode second;
    }
}
