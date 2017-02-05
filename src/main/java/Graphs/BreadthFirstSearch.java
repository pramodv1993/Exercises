package Graphs;



import org.apache.commons.collections.CollectionUtils;

import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by pramodvadiraj on 05/02/17.
 */
public class BreadthFirstSearch {
    static public void traverse(Graph graph ,int source)
    {
        boolean visited[] = new boolean[graph.getVertices()];//initialised to false for all vertices
        LinkedList<Integer>[] adj = graph.getAdj();
        Queue queue = new LinkedList();
        //setting the source
        queue.add(source);
        while(CollectionUtils.isNotEmpty(queue))
        {
            Integer vertex = (Integer)queue.poll();
            System.out.print(vertex + " ");
            visited[vertex] = true;
            for(Integer adjVertex : adj[vertex])
            {
                //visit the adjacent vertex if not visited
                if(!visited[adjVertex])
                {
                    visited[adjVertex] = true;
                    queue.add(adjVertex);
                }

            }

        }


    }
    public static void main(String[] args) {
        Graph graph = new Graph(5);
        graph.addEdge(0, 1);
        graph.addEdge(0, 3);
        graph.addEdge(1, 2);
        graph.addEdge(1, 4);
        graph.addEdge(4, 2);
        traverse(graph,0);

    }
}
