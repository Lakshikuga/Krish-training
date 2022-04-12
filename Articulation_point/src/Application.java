import java.util.Scanner;

public class Application {

    public static void main(String args[]){

        Scanner sc = new Scanner(System.in);

        graphImpl graph = new graphImpl(7);

        /*graph.addEdges(0, 1);
        graph.addEdges(0, 3);
        graph.addEdges(1, 3);
        graph.addEdges(1, 2);
        graph.addEdges(1, 5);
        graph.addEdges(1, 6);
        graph.addEdges(2, 3);
        graph.addEdges(2, 4);
        graph.addEdges(2, 5);
        graph.addEdges(3, 4);
        graph.addEdges(4, 6);*/

        /*graph.addEdges(0, 1);
        graph.addEdges(0, 2);
        graph.addEdges(0, 3);
        graph.addEdges(1, 3);
        graph.addEdges(2, 3);
        graph.addEdges(3, 4);*/

        graph.addEdges(0, 1);
        graph.addEdges(1, 2);
        graph.addEdges(2, 0);
        graph.addEdges(1, 3);
        graph.addEdges( 1, 4);
        graph.addEdges(1, 6);
        graph.addEdges(3, 5);
        graph.addEdges(4, 5);


        //graph.printGraph();

        /*System.out.println("What is your root node?");
        int rootNode = sc.nextInt();
        graph.DFS(rootNode);*/

        System.out.println("Articulation points of the graph are: ");
        graph.AP();
    }
}
