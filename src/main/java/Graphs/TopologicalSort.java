package Graphs;

import java.util.LinkedList;
import java.util.Stack;

/**
 * Created by pramodvadiraj on 11/02/17.
 */
//Applications of DFS, mainly used to decide what node to visit after the given node
    //say like u have a bunch of tasks ,one dependent on the other, say u,v and u->v, v is dependent on u,
    //u need to make sure u comes before in the ordering,
 //use DFS but need to alter that in a small way

public class TopologicalSort {

     static  void topo(Integer vertex ,boolean[] visited , Stack<Integer> res ,LinkedList<Integer>[] gData)
    {
        visited[vertex] = true;
        LinkedList<Integer> adjVertices = gData[vertex];
        for(Integer i : adjVertices)
        {
           if(!visited[i])
            topo(i,visited,res,gData);
        }
        res.push(vertex);
    }
    public static void topologicalSort(Graph graph)
    {
        LinkedList<Integer>[] graphData = graph.getAdj();
        boolean[] visited = new boolean[graph.getVertices()];
        Stack<Integer> finalResult = new Stack();//to store the finalResult
        for(int i =0 ; i < graph.getVertices() ; i++)
        {
            if(!visited[i])
            topo(i,visited,finalResult,graphData);
        }

        while (finalResult.empty()==false)
            System.out.print(finalResult.pop() + " ");

    }
    public static void main(String[] args) {
        Graph g = new Graph(6);
        g.addEdge(5, 2);
        g.addEdge(5, 0);
        g.addEdge(4, 0);
        g.addEdge(4, 1);
        g.addEdge(2, 3);
        g.addEdge(3, 1);

        System.out.println("Following is a Topological " +
                "sort of the given graph");
        topologicalSort(g);

    }
}
