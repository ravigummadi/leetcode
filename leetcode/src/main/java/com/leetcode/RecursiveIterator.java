package com.leetcode;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.Stack;

/**
 * Created with IntelliJ IDEA.
 * User: ravigummadi
 * Date: 3/25/13
 * Time: 2:52 PM
 * To change this template use File | Settings | File Templates.
 */
public class RecursiveIterator {

    Stack<Iterator> iteratorStack = new Stack();
    Iterator currentIterator;
    Object next;

    RecursiveIterator(Iterator iter){
        this.currentIterator = iter;
    }

    public Object next(){
        if(!hasNext()){
            throw new NoSuchElementException();
        }else{
            return next;
        }
    }

    public boolean hasNext(){
        if(!currentIterator.hasNext()){
            if(iteratorStack.isEmpty()){
                return false;
            }else {
                currentIterator = iteratorStack.pop();
                return hasNext();
            }
        }else{
            Object currentElem = currentIterator.next();
            if(currentElem instanceof Set){
                iteratorStack.push(currentIterator);
                currentIterator = ((Set) currentElem).iterator();
                return hasNext();
            }else{
                next = currentElem;
                return true;
            }
        }
    }


}
