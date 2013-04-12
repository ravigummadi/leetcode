package com.leetcode;

/**
 * Created with IntelliJ IDEA.
 * User: gummadi
 * Date: 4/11/13
 * Time: 11:48 PM
 * To change this template use File | Settings | File Templates.
 */
public class JumpGame {
    public boolean canJump(int[] A) {
        return recursiveCanJump(A,0);
    }

    private boolean recursiveCanJump(int[] a,int index){
        if(index == a.length-1){
            return true;
        }else if(index > a.length-1){
            return false;
        }else{
            int count = a[index];
            if(count <= 0)
                return false;
            else{
                for(int i=1; i <= count; i++){
                    if(recursiveCanJump(a,index+i)) return true;
                }
            }
        }
        return false;
    }
}
