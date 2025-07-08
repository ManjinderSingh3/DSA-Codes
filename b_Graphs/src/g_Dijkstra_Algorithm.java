import java.util.*;

public class g_Dijkstra_Algorithm {

    public static class Edge{
        int source;
        int destination;
        int weight;

        public Edge(int source, int destination, int weight){
            this.source = source;
            this.destination = destination;
            this.weight = weight;
        }
    }

    public static void createGraph(ArrayList<Edge> graph[]){
        for(int i=0;i<graph.length;i++){
            graph[i] = new ArrayList<Edge>();
        }

        graph[0].add(new Edge(0,1, 2));
        graph[0].add(new Edge(0,2, 4));

        graph[1].add(new Edge(1,3, 7));
        graph[1].add(new Edge(1,2,1));

        graph[2].add(new Edge(2,4, 3));

        graph[3].add(new Edge(3,5,1));

        graph[4].add(new Edge(4,3, 2));
        graph[4].add(new Edge(4,5, 5));
    }
    

    public static class Pair implements Comparable<Pair>{
        int node;
        int distance;

        public Pair(int node, int distance){
            this.node = node;
            this.distance = distance;
        }

        @Override
        public int compareTo(Pair p2){
            return this.distance - p2.distance; //Ascending order.
        }
    }

    public static void dijkstra(ArrayList<Edge> graph[], int src, int V){
        PriorityQueue<Pair> priorityQueue = new PriorityQueue<>();
        boolean[] visitedArray = new boolean[V];
        int[] dis = new int[V];
        for(int i=0; i<V; i++){
            if(i!=src){
                dis[i] = Integer.MAX_VALUE; //Infinity
            }
        }
        priorityQueue.add(new Pair(0,0));

        while(!priorityQueue.isEmpty()){
            Pair current = priorityQueue.remove();
            if(!visitedArray[current.node]){
                visitedArray[current.node] = true;
                for(int i=0; i<graph[current.node].size(); i++){
                    Edge e = graph[current.node].get(i);
                    int u = e.source;
                    int v = e.destination;
                    //Relaxation Step
                    if(dis[u] + e.weight < dis[v]){
                        dis[v] = dis[u] + e.weight;
                        priorityQueue.add(new Pair(e.destination, dis[v]));
                    }
                }
            }
        }
        for(int i=0;i<dis.length;i++){
            System.out.print(dis[i] + " ");
        }
    }

    public static void main(String[] args) {
        int V=6;
        ArrayList<Edge> graph[] = new ArrayList[V];
        createGraph(graph);
        dijkstra(graph,0, V);
    }
}
