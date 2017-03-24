package LinkedList.TestLinkedList;

/**
 * Created by pramodvadiraj on 10/03/17.
 */
public class Node{
    public int data;
    public Node next;

    public Node(int data) {
        this.data = data;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }
}
