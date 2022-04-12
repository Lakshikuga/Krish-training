import sun.awt.image.ImageWatched;
import sun.reflect.generics.tree.Tree;

import java.util.LinkedList;
import java.util.Stack;

public class graphImpl {

    int noOfVertices;
    LinkedList<Integer> amd[];
    Stack<Integer> stack;
    int time = 0;


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

    public void DFS(int rootNode) {

        boolean nodeVisited[] = new boolean[noOfVertices];


        int adjNode = 0;

        stack.push(rootNode); //1

        while(!stack.isEmpty()) {
            int topNode = stack.pop(); //1 3 4 2 0

            if(!nodeVisited[topNode]) {
                nodeVisited[topNode] = true; //mark 1 as visited
                System.out.print(topNode + " ");
            }

            for(int i=0; i<amd[topNode].size(); i++){
                adjNode = amd[topNode].get(i);

                if(!nodeVisited[adjNode]){
                    stack.push(adjNode); // 0 3   //0 0 2 4  //0 0
                }
            }
        }
    }

    public void buildDFS_SpanningTree(int root_node) {

    }

    public void APUtil(int node, boolean visited[], int discover_time[], int low[], int parent, boolean isAP[]){
        int adjNode = 0;
        //the count of children vertices in the DFS tree
        int children = 0;

        //mark current node as visited
        visited[node] = true;

        //initialise discovery time and low value of rootNode
        discover_time[node] = low[node] = ++time;

        // Go through all vertices adjacent to this
        for(int i=0; i<amd[node].size(); i++){
            adjNode = amd[node].get(i);
            // If v is not visited yet, then make it a child of u
            // in DFS tree and recur for it
            if(!visited[adjNode]) {
                children++;
                APUtil(adjNode, visited, discover_time, low, parent, isAP);

                // Check if the subtree rooted with v has
                // a connection to one of the ancestors of u
                low[adjNode] = Math.min(low[node], low[adjNode]);

                // If u is not root and low value of one of
                // its child is more than discovery value of u.
                if(parent != -1 && low[adjNode] >= discover_time[node]){
                    isAP[node] = true;
                }
                // Update low value of u for parent function calls.
                else if(adjNode != parent){
                    low[node] = Math.min(low[node], discover_time[adjNode]);
                }

                // If u is root of DFS tree and has two or more children.
                if(parent == -1 && children > 1){
                    isAP[node] = true;
                }
            }
        }
    }

    public void AP() {
        boolean visited[] = new boolean[noOfVertices];
        int discover_time[] = new int[noOfVertices];
        int low[] = new int[noOfVertices];
        boolean isAP[] = new boolean[noOfVertices];
        int time = 0; int parent = -1;

        for(int node=0; node<noOfVertices; node++){
            if(!visited[node]){
                APUtil(node, visited, discover_time, low, parent, isAP);
            }
        }
        for(int node=0; node<noOfVertices; node++){
            if(isAP[node] == true){
                System.out.println(node+ " ");
            }
        }
    }
}
