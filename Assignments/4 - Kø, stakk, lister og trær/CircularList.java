package Assignments.four;

public class CircularList {

    private Node head = null;
    private Node tail = null;

    public Node getHead() {
        return head;
    }

    public void setHead(Node head) {
        this.head = head;
    }

    public Node getTail() {
        return tail;
    }

    public void setTail(Node tail) {
        this.tail = tail;
    }



    /**
     * Adding a node to the circular list.
     * @param value the value of the Node to be added
     */

    public void addNode(int value) {

        //The new node to be added
        Node newNode = new Node(value);
        if (head == null) {//if the head is null, the new node to be added will be the head.
            head = newNode;
        } else {//if the list isn't empty, the current tail is connected to the new node
            tail.setNext(newNode);
        }
        //setting the new node as the new tail
        tail = newNode;

        //Connecting the tail to the head to make the list circular
        tail.setNext(head);
    }

}
