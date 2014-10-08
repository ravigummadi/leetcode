package com.leetcode;

import com.common.TreeNode;

/**
 * Created with IntelliJ IDEA.
 * User: ravigummadi
 * Date: 1/30/13
 * Time: 8:30 PM
 * To change this template use File | Settings | File Templates.
 */
public class FlattenTree {

    public void flatten(TreeNode root) {
        recursiveFlatten(root);
    }


    private TreeNode recursiveFlatten(TreeNode current){
        if(current == null) return null;
        if(current.left != null){
            TreeNode nextRight = current.right;
            current.right = current.left;
            current.left = null;
            TreeNode nextNode = recursiveFlatten(current.right);
            nextNode.right = nextRight;
            return  recursiveFlatten(nextNode);
        }else if(current.right != null){
            return recursiveFlatten(current.right);
        }else{
            return current;
        }
    }
}
