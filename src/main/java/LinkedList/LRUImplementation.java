package LinkedList;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by pramodvadiraj on 01/03/17.
 */
public class LRUImplementation {
    private int capacity;
    private Map<Integer,DoubleNode> cache = new HashMap<Integer, DoubleNode>();//actual cache used for operations
    DoubleNode head ;//to keep track of the nodes
    DoubleNode tail ;
    private int count = 0;

    public LRUImplementation(int capacity)
    {
        this.capacity = capacity;
        head = new DoubleNode(0,0);
        tail = new DoubleNode(0,0);
        head.next = tail;
        tail.prev = head;

    }

    private void deleteNode(DoubleNode node)
    {
        node.prev.next = node.next;
        node.next.prev = node.prev;

    }

    // |head - -tail|
    private void moveToHead(DoubleNode node)
    {
        node.next = head.next;
        node.next.prev = node;
        node.prev = head;
        head.next = node;

    }
    public void set(int key , int value)
    {
        if(cache.get(key) != null)
        {
            DoubleNode existingNode = cache.get(key);
            existingNode.key = key;
            deleteNode(existingNode);
            moveToHead(existingNode);

        }
        else
        {
            DoubleNode node = new DoubleNode(key,value);
            cache.put(key,node);
            if(count < capacity)
            {

                count++;
                moveToHead(node);
            }
            else
            {
                deleteNode(tail.prev);
                cache.remove(tail.prev.key);
                moveToHead(node);

            }
        }


    }
    public static void main(String[] args) {
        LRUImplementation lruImplementation = new LRUImplementation(3);
        lruImplementation.set(1,12);
        lruImplementation.set(2, 12);
        System.out.println(lruImplementation.cache.keySet());
        lruImplementation.set(3, 123);
        System.out.println(lruImplementation.cache.keySet());
        lruImplementation.set(4, 123);
        System.out.println(lruImplementation.cache.keySet());
    }

}

class DoubleNode
{
    public  int key;
    public int value;
    public  DoubleNode prev;
    public DoubleNode next;

    public DoubleNode(int key, int value) {
        this.key = key;
        this.value = value;
    }
}