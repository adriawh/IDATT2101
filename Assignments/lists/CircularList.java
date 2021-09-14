package Assignments.lists;

public class CircularList {

    private Node head = null;
    private Node tail = null;
    private int elementCount = 0;

    public int getElementCount() {
        return elementCount;
    }

    public Node getHead() {
        return head;
    }

    public Node getTail() {
        return tail;
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



    /**
     * Method for deleting a node based on a given value
     *
     * @param valueToDelete the valure of the node to be deleted
     */
    public void deleteNode(int valueToDelete) {

        Node currentNode = head; //sets the starting point for the iteration as the head

        if (head == null) { //if the list is empty, return
            return;
        }

        do {
            Node nextNode = currentNode.getNext();

            if (nextNode.getValue() == valueToDelete) {
                if (tail == head) { // the list has only one single element
                    head = null;
                    tail = null;
                } else {
                    currentNode.setNext(nextNode.getNext());//removing the node to be removed by overwriting
                    //the reference to the node to be deleted with the next node

                    if (head == nextNode) { //we're deleting the head
                        head = head.getNext();
                    }

                    if (tail == nextNode) { //we're deleting the tail
                        tail = currentNode;
                    }
                }
            }
            currentNode = nextNode; //iterating to the next Node,
        } while (currentNode != head);
    }
}
