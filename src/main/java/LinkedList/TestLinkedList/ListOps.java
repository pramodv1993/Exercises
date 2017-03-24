package LinkedList.TestLinkedList;

/**
 * Created by pramodvadiraj on 10/03/17.
 */
public class ListOps {
    public static void main(String[] args) {
        Node node1 = new Node(1);
        node1.next = new Node(2);
        node1.next.next = new Node(3);

        printList(node1);
        System.out.println("_________addToHead");
        node1 = addToHead(node1, new Node(4));
        printList(node1);
        System.out.println("_________Reverse");
        node1 = reverseList(node1);
        printList(node1);
        System.out.println("_________Reverse");
        reverseListIterative(node1);
        printList(head);

        Node node2 = new Node(123);
        node2.next = head;
        findIntersection(node2,head);

    }


    private static int findLength(Node head)
    {
        int count = 0;
        while(head != null)
        {
            head = head.next;
            count++;

        }return count;
    }

    private static void findIntersection(Node node1,Node node2)
    {
        int l1 = findLength(node1);
        int l2 = findLength(node2);
        int count = 0;
        if(l1 > l2)
        {
            count = l1;
            while(count != l2)
            {
                node1 = node1.next;
                count--;
            }

        }
        else if(l1<l2)
        {
            count = l2;
            while(count != l1)
            {
                node2 = node2.next;
                count--;
            }
        }
        while(node1 != null && node2 != null )
        {
            if(node1.data == node2.data)
            {
                System.out.println("They meet at " + node1.data);
                break;
            }
            node2 = node2.next;
            node1 = node1.next;
        }




    }

    static Node head;
    private static void reverseListIterative(Node node)
    {
        if (node == null)
            return;
        if(node.next == null)
        {
            head = node;
            return;
        }

        reverseListIterative(node.next);
        node.next.next = node;
        node.next = null;
    }
    private static  Node reverseList(Node head)
    {
        Node cur = head,prev = null,next = null;
        while(cur !=  null)
        {
            next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        head = prev;
        return  head;

    }
    private static Node addToHead(Node head,Node node)
    {
        node.next = head;
        head = node;
        return head;
    }
    private static void printList(Node node)
    {
        while(node != null)
        {
            System.out.println(node.getData());
            node= node.getNext();


        }

    }

}
