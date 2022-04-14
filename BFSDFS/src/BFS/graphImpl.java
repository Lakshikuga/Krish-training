package BFS;

import java.util.ArrayList;
import java.util.Scanner;

public class graphImpl {

    int noOfVertices;

    ArrayList<ArrayList<Integer>> am;

    Scanner input = new Scanner(System.in);

    public graphImpl() {

        System.out.println("How many vertices are in your graph");
        int noOfVertices = input.nextInt();
        this.noOfVertices = noOfVertices;

        am = new ArrayList<ArrayList<Integer>>(noOfVertices);
        for (int i = 0; i < noOfVertices; i++) {
            am.add(new ArrayList<Integer>());
        }
    }

    public void addEdge(int noOfVertices) {
        System.out.println("Add all the edges");
        for (int i = 0; i < noOfVertices; i++) {
            int source = input.nextInt();
            int destination = input.nextInt();

            am.get(source).add(destination);
            am.get(destination).add(source);
        }

        System.out.println();

    }
    public void addEdge(int s, int d) {

        am.get(s).add(d);
        am.get(d).add(s);
    }

    public void printGraph(ArrayList<ArrayList<Integer>> am) {
        for (int i = 0; i < am.size(); i++) {
            System.out.println("\nVertex " + i + ":");
            for (int j = 0; j < am.get(i).size(); j++) {
                System.out.print(" -> " + am.get(i).get(j));
            }
            System.out.println();
        }
    }


}
