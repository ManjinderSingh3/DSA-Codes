import java.util.*;

public class c_Cheapest_Flights_Within_K_Stops {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        Map<Integer, List<int[]>> adjList = new HashMap<>();
        for(int[] flight: flights){
            int u = flight[0];
            int v = flight[1];
            int w = flight[2];
            if(!adjList.containsKey(u))
                adjList.put(u, new ArrayList<>());
            adjList.get(u).add(new int[]{v,w});
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a1, a2)->a1[0]-a2[0]);
        int[] stopsArray = new int[n];
        Arrays.fill(stopsArray, Integer.MAX_VALUE);
        pq.offer(new int[]{0, src, 0});

        while(!pq.isEmpty()){
            int[] current = pq.poll();
            int priceSoFar = current[0];
            int currentNode = current[1];
            int stops = current[2];

            if(currentNode == dst)
                return priceSoFar;

            if(stops > k || stops > stopsArray[currentNode])
                continue;
            stopsArray[currentNode] = stops;

            for(int[] neighbor: adjList.getOrDefault(currentNode, Collections.emptyList())){
                pq.offer(new int[]{priceSoFar + neighbor[1], neighbor[0], stops+1});
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int n = 4;
        int[][] flights = {
                {0, 1, 100},
                {1, 2, 100},
                {2, 0, 100},
                {1, 3, 600},
                {2, 3, 200}
        };
        int src = 0;
        int dst = 3;
        int k = 1;

        c_Cheapest_Flights_Within_K_Stops solver = new c_Cheapest_Flights_Within_K_Stops();
        int result = solver.findCheapestPrice(n, flights, src, dst, k);
        System.out.println("Cheapest price with at most " + k + " stops: " + result);
    }
}
