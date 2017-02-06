package Graphs;

import java.util.LinkedList;
import java.util.Stack;

/**
 * Created by pramodvadiraj on 05/02/17.
 */
public class DepthFirstSearch {


    static public void DFS(Graph graph , int source)
    {
        boolean[] visited = new boolean[graph.getVertices()];
        Stack<Integer> stack = new Stack<Integer>();
        stack.push(source);

        LinkedList<Integer>[] adjVertices = graph.getAdj();

        while(!stack.empty())
        {
            int vertexAtTop = stack.pop();
            if(!visited[vertexAtTop])
            {
                System.out.print(vertexAtTop + " ");
                visited[vertexAtTop] = true;
            }
            for(Integer adjVertex : adjVertices[vertexAtTop])
            {
                if(!visited[adjVertex])
                {
                    stack.push(adjVertex);
                }
            }
        }

    }
    public static void main(String[] args) {
        Graph  g = new Graph(5); // Total 5 vertices in graph
        g.addEdge(1, 0);
        g.addEdge(0, 2);
        g.addEdge(2, 1);
        g.addEdge(0, 3);
        g.addEdge(1, 4);
        DFS(g,0);

    }

}
