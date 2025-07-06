import java.util.*;
public class b_Graph_DFS {
    
    static class Edge {
        int source;
        int destination;
        
        public Edge(int s, int d){
            this.source = s;
            this.destination = d;
        }
    }
    
    public static void createGraph(ArrayList<Edge> graph[]){
        for(int i=0;i<graph.length;i++){
            graph[i] = new ArrayList<Edge>(); 
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
    
    public static void graphDFS(ArrayList<Edge> graph[], int current, boolean[] visitedArray){
        System.out.print(current + " ");
        visitedArray[current] = true;
        for(int i=0;i<graph[current].size();i++){
            Edge e = graph[current].get(i);
            if(!visitedArray[e.destination]){
                graphDFS(graph, e.destination, visitedArray);
            }
        }
    }

    public static void main(String[] args) {
        int V =7;
        /*
                1 -------- 3
               /           |  \
              0            |   5 ---- 6
               \           |  /
                2 -------- 4
         */
        ArrayList<Edge> graphArray[] = new ArrayList[V];
        createGraph(graphArray);
        boolean visitedArray[] = new boolean[V];
        for(int i=0;i<V;i++){
            if(visitedArray[i] == false){
                graphDFS(graphArray, i, visitedArray);
            }
        }
    }

}
