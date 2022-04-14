package BFS;

import java.util.Scanner;

public class Application {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        //graphImpl graphImpl = new graphImpl();

        //adding edges to each vertex
        /*graphImpl.addEdge(0,1);
        graphImpl.addEdge(0,4);
        graphImpl.addEdge(0 , 3);
        graphImpl.addEdge(1, 2);
        graphImpl.addEdge(3,5);
        graphImpl.addEdge(4, 5);

        graphImpl.printGraph(graphImpl.am);*/


        System.out.println("What is your root node?");
        int n = sc.nextInt();

        bfs bfs = new bfs();

        bfs.traverse(n);


    }

}
