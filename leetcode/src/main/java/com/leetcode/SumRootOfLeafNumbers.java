package com.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: gummadi
 * Date: 2/22/13
 * Time: 10:18 PM
 * To change this template use File | Settings | File Templates.
 */
public class SumRootOfLeafNumbers {
    public int sumNumbers(TreeNode root) {
        List<String> allNumbers = new ArrayList<String>();
        String startString = "";
        recSumNumbers(root, startString, allNumbers);
        return sumOfAllInList(allNumbers);
    }

    private int sumOfAllInList(List<String> allNumbers){
        int sum = 0;
        for(String number : allNumbers){
            sum += Integer.valueOf(number);
        }
        return sum;
    }

    private void recSumNumbers(TreeNode current, String uptoString, List<String> allNumbers){
        if(current == null){
            return;
        }
        if(current.left == null && current.right == null){
            allNumbers.add(uptoString + current.val);
            return;
        }

        if(current.right != null){
            recSumNumbers(current.right, uptoString + current.val, allNumbers);
        }

        if(current.left != null){
            recSumNumbers(current.left, uptoString + current.val, allNumbers);
        }
    }
}
