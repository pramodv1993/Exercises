package Graphs;

import java.util.LinkedList;

/**
 * Created by pramodvadiraj on 05/02/17.
 */
public class Graph {
    LinkedList[] adj;
    Integer vertices;

    public Graph(int vertices) {
        this.vertices = vertices;
        this.adj = new LinkedList[vertices];
        for(int i = 0 ; i < vertices ; i++)
        {
            adj[i] = new LinkedList();

        }
    }
    public Integer getVertices() {
        return vertices;
    }
    public void addEdge(int s , int d)
    {
        adj[s].add(d);
    }
    public LinkedList<Integer>[] getAdj() {
        return adj;
    }

}
