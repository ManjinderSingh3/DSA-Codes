import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Graph_BFS {
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
        graph[0].add(new Edge(0,2));

        graph[1].add(new Edge(1,2));
        graph[1].add(new Edge(1,3));

        graph[2].add(new Edge(2,0));
        graph[2].add(new Edge(2,1));
        graph[2].add(new Edge(2,3));

        graph[3].add(new Edge(3,1));
        graph[3].add(new Edge(3,2));
    }

    public static void main(String[] args) {
        int V=4; // For now defining fixed number of vertices
        ArrayList<Edge> graphArray[] = new ArrayList[V];
        createGraph(graphArray);

        for(int i=0;i<graphArray.length;i++){

            for(int j=0; j<graphArray[i].size();j++){
                Edge e = graphArray[i].get(j);
                System.out.println(e.source + "-"+e.destination);
            }
        }
    }

    public ArrayList<Integer> graphBFS(){
        ArrayList<Integer> result = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visitedArray = new boolean[5];

        queue.add(0); // Adding Starting Node
        visitedArray[0] = true;

        while(!queue.isEmpty()){
            Integer node = queue.poll();
            result.add(node);

        }


        return result;
    }
}
