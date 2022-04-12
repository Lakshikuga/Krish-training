public class articulation_point {

    //build the DFS spanning tree
    //mark depth indexes on the spanning tree
    //find the lowest depth index  reachable by any vertex by taking only one back edge.
    //(v, u) -> v is the parent node and u is the child node. Condition -> l[v]>=d[u],
    // if condition true, then u is the articulation point.
    //the above condition is not applicable to a root node but if a rootnode is an articulation point
    //because traversal can begin from anywhere.
    //but there is a special condition for root node that if it has more than one child, rootnode becomes an articulation point

    //because articulation point is -> ina graph if there is any vertex whose removal will disconnect the graph
    // into multiple components, then that vertex is an articulation point.
}
