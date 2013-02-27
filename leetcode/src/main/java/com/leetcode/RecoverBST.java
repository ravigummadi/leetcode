package com.leetcode;

/**
 * Created with IntelliJ IDEA.
 * User: gummadi
 * Date: 2/25/13
 * Time: 11:06 PM
 * To change this template use File | Settings | File Templates.
 */
public class RecoverBST {

    public void recoverTree(TreeNode root) {
        recursiveRecover(root);
    }

    private void recursiveRecover(TreeNode node){
        if(node == null)
            return;
        if(node.left != null && node.left.val > node.val){
            if(node.right == null || (node.right != null && node.left.val < node.right.val)){
                swapValues(node.left, node);
                return;
            }
        }
        if(node.right != null && node.right.val < node.val){
            if(node.left == null || (node.left != null && node.right.val > node.left.val)){
                swapValues(node.right, node);
                return;
            }
        }
        recursiveRecover(node.left);
        recursiveRecover(node.right);
    }

    private void swapValues(TreeNode node1, TreeNode node2){
        int temp = node1.val;
        node1.val = node2.val;
        node2.val = temp;
    }

}
