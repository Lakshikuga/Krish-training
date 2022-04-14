package BFS;

import java.util.LinkedList;
import java.util.Queue;

public class bfs {

    graphImpl graphImpl = new graphImpl();
    Queue<Integer> queue = new LinkedList<>();
    int size = graphImpl.noOfVertices;

    public void traverse(int rootNode) {

        //adding edges to each vertex
        graphImpl.addEdge(0,1);
        graphImpl.addEdge(0,4);
        graphImpl.addEdge(0 , 3);
        graphImpl.addEdge(1, 2);
        graphImpl.addEdge(3,5);
        graphImpl.addEdge(4, 5);


        graphImpl.printGraph(graphImpl.am);


        boolean nodeVisited[] = new boolean[size];
        int adjNode = 0;

        //rootnode inserted to queue and visited
        queue.add(rootNode);
        nodeVisited[rootNode] = true;

        while (!queue.isEmpty()) {
            rootNode = queue.poll();
            System.out.print(rootNode+ " ");

            for (int i = 0; i < graphImpl.am.size(); i++) {
                for (int j = 0; j < graphImpl.am.get(rootNode).size(); j++) {
                    adjNode = graphImpl.am.get(rootNode).get(j); // 1 3 4 //here 0th node has 1 3 4
                    //System.out.print("" + a + ""); //4 3 1
                    if (nodeVisited[adjNode] != true) { // checking if the node has not been visited
                        nodeVisited[adjNode] = true; //then set node to true
                        queue.add(adjNode); //at the end of 2nd for loop, there ll be 1 3 4 in the queue
                        //System.out.print(" " + a + " "); //4 3 1
                    }

                }
            }

        }
    }
}
