package com.company;

/**
 * IntNode class represents a node in the integer list.
 */
public class IntNode {
    // value stored in node
    private int val;
    // link to next node in list
    private IntNode next;

    // sets up the node given a value and IntNode reference
    public IntNode(int val, IntNode next) {
        this.val = val;
        this.next = next;
    }

    // return value of node
    public int getVal() {
        return val;
    }

    // return reference to next node
    public IntNode getNext() {
        return next;
    }

    // mutator for next IntNode
    public void setNext(IntNode node) {
        next = node;
    }


    public void setVal(int newVal) {
        val = newVal;
    }
}
