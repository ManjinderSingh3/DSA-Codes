import java.util.ArrayList;
import java.util.Arrays;

public class f_Cycle_Detection_In_Undirected_Graph {

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

        graph[0].add(new Edge(0,1));
        graph[0].add(new Edge(0,4));

        graph[1].add(new Edge(1,0));
        graph[1].add(new Edge(1,2));
        graph[1].add(new Edge(1,4));


        graph[2].add(new Edge(2,1));
        graph[2].add(new Edge(2,3));


        graph[3].add(new Edge(3,2));

        graph[4].add(new Edge(4,0));
        graph[4].add(new Edge(4,1));
        graph[4].add(new Edge(4,5));

        graph[5].add(new Edge(5,4));

    }
    public static boolean isCycleDetected(ArrayList<Edge> graph[], int current, boolean visitedArray[], int parent){
        visitedArray[current] = true;
        for(int i= 0;i<graph[current].size();i++){
            Edge e = graph[current].get(i);
            // CYCLE Condition
            if(visitedArray[e.destination] && e.destination!=parent){
                return true ;
            }
            else if(!visitedArray[e.destination]){
                if(isCycleDetected(graph, e.destination, visitedArray, current)){
                    return true;
                }
            }
        }

        return false;
    }

    public static void main(String[] args) {
        int V=6;
        ArrayList<Edge> graph[] = new ArrayList[V];
        createGraph(graph);
        /*
                    1 -------------- 2
                  / |                |
                 /  |                |
                0   |                |
                 \  |                |
                  \ |                |
                    4                3
                     \
                      \
                       \
                        5

         */
        boolean[] visitedArray = new boolean[V];
        for(int i=0;i<V;i++){
            if(!visitedArray[i]){
                boolean isCycle = isCycleDetected(graph, i, visitedArray, -1);
                System.out.println(isCycle);
                break;
            }
        }
    }
}
