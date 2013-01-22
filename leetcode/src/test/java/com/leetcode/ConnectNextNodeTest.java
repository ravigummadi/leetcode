package com.leetcode;

import org.junit.Test;

/**
 * Created with IntelliJ IDEA.
 * User: ravigummadi
 * Date: 1/21/13
 * Time: 11:27 PM
 * To change this template use File | Settings | File Templates.
 */
public class ConnectNextNodeTest {

    @Test
    public void testConnect(){
        TreeLinkNode root = new TreeLinkNode(1);
        root.right = new TreeLinkNode(2);
        ConnectNextNode cNode = new ConnectNextNode();
        cNode.connect(root);
    }
}
