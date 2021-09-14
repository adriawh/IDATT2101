package Assignments.lists;

/**
 *
 *
 */

public class Node {
    int value;
    Node next;

    public Node(int element){
        this.value = element;
    }

    public int getValue() {
        return value;
    }

    public Node getNext(){
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }
}
