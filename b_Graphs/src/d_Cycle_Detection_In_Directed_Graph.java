import java.util.*;
public class d_Cycle_Detection_In_Directed_Graph {

    static  class Edge{
        int source;
        int destination;

        public Edge(int s, int d){
            this.source = s;
            this.destination = d;
        }
    }

    public static void createGraph(ArrayList<Edge> graph[]){
        for(int i=0; i<graph.length ; i++){
            graph[i] = new ArrayList<Edge>();
        }

        graph[0].add(new Edge(0,2));
        graph[1].add(new Edge(1,0));
        graph[2].add(new Edge(2,3));
        graph[3].add(new Edge(3,0));

    }

    public static boolean isCycleDetected(ArrayList<Edge> graph[], int current, boolean visitedArray[], boolean stackArray[]){
        visitedArray[current] = true;
        stackArray[current] = true;
        for(int i=0; i<graph[current].size();i++){
            Edge e = graph[current].get(i);
            if(stackArray[e.destination]){
                return true; // CYCLE Condition
            } else if (!visitedArray[e.destination]) {
                if(isCycleDetected(graph, e.destination, visitedArray, stackArray)){
                 return true;
                }
            }
        }
        stackArray[current] = false;
        return false;

    }

    public static void main(String[] args) {
        int V =4;
        ArrayList<Edge> graph[] = new ArrayList[V];
        createGraph(graph);
        boolean[] visitedArray = new boolean[V];
        boolean[] stackArray = new boolean[V];
        for(int i=0;i<V;i++){
            if(!visitedArray[i]){
                boolean isCycle = isCycleDetected(graph,i,visitedArray,stackArray);
                System.out.println(isCycle);
                break;
            }
        }

    }
}
