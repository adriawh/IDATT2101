package Assignments.Hash.Oppg1;

public class Node {

    private String value;
    private Node pointer;

    public Node(String value){
        this.value = value;
    }

    public void setPointer(Node pointer) {
        this.pointer = pointer;
    }

    public Node getPointer() {
        return pointer;
    }

    public String getValue() {
        return value;
    }
}
