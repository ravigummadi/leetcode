package com.leetcode;

import com.common.TreeNode;
import org.junit.Test;

/**
 * Created with IntelliJ IDEA.
 * User: ravigummadi
 * Date: 2/27/13
 * Time: 11:49 PM
 * To change this template use File | Settings | File Templates.
 */
public class RecoverBSTTest {

    @Test
    public void testRecover(){
        RecoverBST bst = new RecoverBST();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        bst.recoverTree(root);
    }


}
