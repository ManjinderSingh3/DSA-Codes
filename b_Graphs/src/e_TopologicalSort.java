import java.util.*;
public class e_TopologicalSort {

    static class Edge{
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

        graph[2].add(new Edge(2,3));
        graph[3].add(new Edge(3,1));

        graph[4].add(new Edge(4,0));
        graph[4].add(new Edge(4,1));

        graph[5].add(new Edge(5,0));
        graph[5].add(new Edge(5,2));
    }

    public static void topologicalSort(ArrayList<Edge> graph[], int current, boolean visitedArray[], Stack<Integer> stack){
        visitedArray[current] = true;
        for(int i=0;i<graph[current].size();i++){
            Edge e = graph[current].get(i);
            if(!visitedArray[e.destination]){
                topologicalSort(graph, e.destination, visitedArray, stack);
            }
        }
        stack.push(current);
    }

    public static void main(String[] args) {
        int V=6;
        ArrayList<Edge> graph[] =new ArrayList[V];
        createGraph(graph);
        boolean[] visitedArray = new boolean[V];
        Stack<Integer> stack = new Stack<>();
        for(int i=0;i<V;i++){
            if(!visitedArray[i]){
                topologicalSort(graph, i, visitedArray, stack);
            }
        }
        while(!stack.isEmpty()){
            System.out.print(stack.pop() + " ");
        }

    }
}
