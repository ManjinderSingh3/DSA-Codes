import java.util.*;

public class Graph_Representation {

    public static void main(String[] args) {

        int n=3, m=3;
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<ArrayList<Integer>>();

        // Create n+1 ArrayLists
        for(int i=0;i<n;i++){
            adjList.add(new ArrayList<Integer>());
            // U and v are two vertex/Nodes
            //adjList.get(u).add(v);
            //adjList.get(v).add(u);

            // Example : there is a edge between node 2 & 3
            adjList.get(2).add(3);
            adjList.get(3).add(2);
        }
    }
}
