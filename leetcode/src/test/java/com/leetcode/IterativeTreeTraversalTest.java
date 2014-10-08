package com.leetcode;

import com.common.TreeNode;
import junit.framework.Assert;
import org.junit.Test;

/**
 * Created with IntelliJ IDEA.
 * User: gummadi
 * Date: 4/23/13
 * Time: 1:10 AM
 * To change this template use File | Settings | File Templates.
 */
public class IterativeTreeTraversalTest {

    @Test
    public void testPreorderTraversal(){
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(4);
        IterativeTreeTraversal it = new IterativeTreeTraversal();
        Assert.assertEquals("1 2 3 4 ",it.preorderTraversal(root));
    }

}
