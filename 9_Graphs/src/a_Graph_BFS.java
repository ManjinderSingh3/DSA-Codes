import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class a_Graph_BFS {

    static class Edge{
        int source;
        int destination;

        public Edge(int s, int d){
            this.source = s;
            this.destination = d;
        }
    }

    public static void createGraph(ArrayList<Edge> graph[]){
        for(int i=0;i<graph.length;i++){
            graph[i] = new ArrayList<Edge>(); //CREATE EMPTY ArrayList at each index of array

        }
        graph[0].add(new Edge(0,1));
        graph[0].add(new Edge(0,2));

        graph[1].add(new Edge(1,0));
        graph[1].add(new Edge(1,3));

        graph[2].add(new Edge(2,0));
        graph[2].add(new Edge(2,4));


        graph[3].add(new Edge(3,1));
        graph[3].add(new Edge(3,4));
        graph[3].add(new Edge(3,5));

        graph[4].add(new Edge(4,2));
        graph[4].add(new Edge(4,3));
        graph[4].add(new Edge(4,5));

        graph[5].add(new Edge(5,3));
        graph[5].add(new Edge(5,4));
        graph[5].add(new Edge(5,6));

        graph[6].add(new Edge(6,5));
    }

    // Time Complexity of BFS : O(V+E)
    public static void graphBFS(ArrayList<Edge> graph[],int V){
        //ArrayList<Integer> result = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visitedArray = new boolean[V];

        queue.add(0); // Adding Starting Point . It could be 0,1,2 or anything else but by convention I'm taking 0
        //visitedArray[0] = true;

        while(!queue.isEmpty()){
            int edge = queue.poll();
            if(!visitedArray[edge]){
                System.out.print(edge + " ");
                visitedArray[edge]=true;
                for(int i= 0 ; i<graph[edge].size();i++){
                    Edge currentEdge = graph[edge].get(i);
                    queue.offer(currentEdge.destination);
                }
                //result.add(edge);
            }
        }
        //return result;
    }

    public static void main(String[] args) {
        int V=7; // For now defining fixed number of vertices
        /*
                1 ---- 3
               /       | \
              0        |  5 -- 6
               \       | /
                2 ---- 4
         */
        ArrayList<Edge> graphArray[] = new ArrayList[V];
        createGraph(graphArray);
        graphBFS(graphArray,V);
    }
}
