package LinkedList;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by pramodvadiraj on 28/02/17.
 */
//1)Floyd's Cycle Detection Algorithm
/*
why this works?

i- no of steps taken by the tortoise
m-lenth og the list till the starting of the loop
l-length of the loop
k-no of steps from the starting of the loop where the tortoise and rabbit meets
we know hare goes 2i steps
 //tortoise
 i = m + k + a(l)-1
 //hare
 2i = m + k + b(l)-2

 therefore, from 1 and 2
 we get, m + k = (b-2a) l - m+k is integer multiple of length of loop

*/

public class LoopTest {

    private static String hasCycle(Node node)
    {
        Node s= node,f = node;
        while(f != null)
        {
            s = s.next;
            f = f.next.next;
            if(s == f)
                return "has loop";

        }
        return "no loop";
    }
    public static void main(String[] args) {
        Node node = new Node(2);
        node.next = new Node(4);
        node.next.next = new Node(5);
        node.next.next.next = new Node(6);
        node.next.next.next.next = node.next.next;

        System.out.println(hasCycle(node));


    }
}


