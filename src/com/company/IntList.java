package com.company;

/**
 * IntList class represents a linked list of integers.
 * Added custom methods:
 * length - number of elements
 * delete - delete value
 * print - print list of elements
 * recursive print of elements from first to last, and last to first.
 */
public class IntList {
    // first node in list
    private IntNode front;
    // counter for items
    private int counter;

    // default Constructor
    public IntList() {
        front = null;
        counter = 0;
    }

    // adds integer in front of list
    public void addFirst(int val) {
        front = new IntNode(val,front);
        // increment length
        ++counter;
    }

    // adds integer to end of list
    public void addLast(int val) {
        IntNode newnode = new IntNode(val,null);

        // if list is empty, this will be the only node in it
        if (front == null)
            front = newnode;
        else {
            //make temp point to last thing in list
            IntNode temp = front;
            while (temp.getNext() != null)
                temp = temp.getNext();

            // link new node into list
            temp.setNext(newnode);
        }
        // increment length
        ++counter;
    }

    public int getFirst() {
        return front.getVal();
    }

    public int getLast() {
        IntNode temp = front;
        if(front != null && front.getNext() == null)
            return front.getVal();
        else {
            while(temp.getNext() != null)
                temp = temp.getNext();

            return temp.getVal();
        }
    }

    // remove the first node from list
    public void removeFirst() {
        // non-empty list
        if (front != null) {
            front = front.getNext();
            // decrement length
            --counter;
        }
    }

    // removes the last element in list
    public void removeLast() {
        IntNode temp = front;

        if(front != null && front.getNext() == null)
            front = null;
        else {
            while(temp.getNext().getNext() != null)
                temp = temp.getNext();

            temp.setNext(null);
        }
    }

    // returns the number of elements in the list
    public int length() {
        IntNode temp = front;
        //reset counter
        counter = 0;
        while (temp != null) {
            counter++;
            temp = temp.getNext();
        }
        return counter;
    }

    // replaces node with new value
    public void replace(int oldVal, int newVal) {
        IntNode temp = front;

        while(temp != null) {
            if(temp.getVal() == oldVal)
                temp.setVal(newVal);
            temp = temp.getNext();
        }
    }

    // deletes a value in list
    public boolean delete(int value) {
        IntNode current = front;
        IntNode previous = null;

        while(current != null && current.getVal() != value) {
            previous = current;
            current = current.getNext();
        }

        if(current == null)	//not found
            return false;

        else {
            if(current == front)
                front = front.getNext();	//delete head

            else
                previous.setNext(current.getNext());

            counter--;
            return true;
        }
    }

    // prints list of elements from first to last
    public void print() {
        IntNode temp = front;
        while (temp != null) {
            System.out.print(temp.getVal() + " ");
            temp = temp.getNext();
        }
    }

    // prints the list from first to last
    public void printRecursive() {
        IntNode n = front;

        if(n != null) {
            System.out.print( n.getVal() + " ");
            n = n.getNext();
            RecursiveList(n);	// call to recursive method
        }
    }

    // recursive implementation for printing remainder of list
    private void RecursiveList(IntNode p ) {
        if (p != null) {
            System.out.print(p.getVal() + " ");
            RecursiveList(p.getNext());
        }
    }

    // prints the list from last to first
    public void printRecursiveBackwards() {
        IntNode node = front;

        if( node != null ) {
            RecursiveReverse(node.getNext());	// call to recursive method
            System.out.print(node.getVal() + " ");
        }
    }
    // recursive implementation for printing remainder of list
    private void RecursiveReverse(IntNode p) {
        if (p != null) {
            RecursiveReverse(p.getNext());
            System.out.print(p.getVal() + " ");
        }
    }
}
