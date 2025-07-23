import java.util.ArrayList;
import java.util.PriorityQueue;

public class h_Prims_Algorithm {
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
        for(int i=0; i<graph.length;i++){
            graph[i] = new ArrayList<>();
        }

        graph[0].add(new Edge(0,1,10));
        graph[0].add(new Edge(0,2,15));
        graph[0].add(new Edge(0,3,30));

        graph[1].add(new Edge(1,0,10));
        graph[1].add(new Edge(1,3,40));

        graph[2].add(new Edge(2,0,15));
        graph[2].add(new Edge(2,3,50));

        graph[3].add(new Edge(3,1,40));
        graph[3].add(new Edge(3,2,50));
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
            return this.distance - p2.distance;
        }
    }

    public static void prims(ArrayList<Edge> graph[], int V){
        PriorityQueue<Pair> priorityQueue = new PriorityQueue<>();
        boolean[] visitedArray = new boolean[V];
        int totalCost = 0;
        priorityQueue.add(new Pair(0,0));
        while(!priorityQueue.isEmpty()){
            Pair current = priorityQueue.poll();
            if(!visitedArray[current.node]){
                visitedArray[current.node]=true;
                totalCost+= current.distance;
                for(int i=0; i<graph[current.node].size();i++){
                    Edge edge = graph[current.node].get(i);
                    if(!visitedArray[edge.destination]){
                        priorityQueue.add(new Pair(edge.destination, edge.weight));
                    }
                }
            }
        }
        System.out.println("MST cost is : " + totalCost);

    }

    public static void main(String[] args) {
        int V = 4;
        ArrayList<Edge> graph[] = new ArrayList[V];
        createGraph(graph);
        prims(graph, V);
    }
}
