package DFS;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Stack;

public class graphImpl {

    int noOfVertices;
    LinkedList<Integer> amd[];
    Stack<Integer> stack;


    public graphImpl(int noOfVertices) {
        this.noOfVertices = noOfVertices;

        amd = new LinkedList[noOfVertices]; //initialising array of arrayList

        for(int i=0; i<noOfVertices; i++){
            amd[i] = new LinkedList<>();
        }

        stack = new Stack<>();
    }

    public void addEdges(int s, int d) {

        amd[s].add(d);
        amd[d].add(s);
    }

    //iterative implementation with the stack -> here the condition for putting into stack is if the node is not visited yet, so every iteration,
    // the stack may have repeating elements since it may not have been visited.

    public void dfswithStack(int rootNode){
        boolean nodeVisited[] = new boolean[noOfVertices];
        int adjNode = 0;

        System.out.println("Depth First Search for the graph is as follows : ");
        stack.push(rootNode); // 0

        while(!stack.isEmpty()){
            int topNode = stack.pop(); //0 3 4 2 1 2 1    //0 1 3 4 2  2 3

            if(!nodeVisited[topNode]){
                nodeVisited[topNode] = true; // mark 0 as visited, mark 3 as visited, mark 4 as visited, mark 2 as visited, mark 1 as visited
                System.out.print(topNode + " "); //0 1 3 4 2
            }
            for(int i=0; i<amd[topNode].size(); i++){
                adjNode = amd[topNode].get(i);
                if(!nodeVisited[adjNode]) {
                    stack.push(adjNode);  //1 2 3   //1 2 4     say you have a different order -> 3 2 1, 3, 2 4
                    //stack has 1 2 1 2 4       //different order -> 3 2 1   so stack has  3 2 3 -> 3 2 2 4 -> 3 2 2 -> 3 2
                }
            }
        }

    }

    public void printGraph() {

        for(int j=0; j<noOfVertices; j++){
            System.out.println("\nVertex " + j + ":");
            for(int k=0; k<amd[j].size(); k++){
                System.out.print(" -> " + amd[j].get(k));
            }
            System.out.println();
        }
    }
}
