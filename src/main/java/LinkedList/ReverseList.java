package LinkedList;

/**
 * Created by pramodvadiraj on 01/03/17.
 */
//Iterative implementation and Recursive implementation
public class ReverseList {

    public static void reverseIterative(Node node)
    {
        Node cur=node, prev = null,next = null;
        while(cur != null)
        {
            next= cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        head = prev;


    }
    static Node head;
    public static void  reverseRecursive(Node node)
    {
        if(node == null)
            return;
        if(node.next == null)
        {
            head = node;
            return ;
        }
        reverseRecursive(node.next);
        node.next.next = node;
        node.next = null;

    }
    public static void printList(Node node)
    {
        while(node != null)
        {
            System.out.println(node.data);
            node = node.next;
        }
    }
    public static void main(String[] args)
    {
        Node node = new Node(1);
        node.next = new Node(2);
        node.next.next = new Node(3);
        node.next.next.next = new Node(4);
        node.next.next.next.next = new Node(5);
        reverseIterative(node);
       // printList(node);
        //reverseRecursive(node);
        printList(head);

    }

}
