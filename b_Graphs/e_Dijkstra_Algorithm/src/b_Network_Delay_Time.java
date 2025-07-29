import java.util.*;

public class b_Network_Delay_Time {

    class Pair implements Comparable<Pair>{
        int node;
        int time;
        public Pair(int node, int time){
            this.node = node;
            this.time = time;
        }
        @Override
        public int compareTo(Pair p2){
            return this.time - p2.time; //ascending order
        }
    }

    public int networkDelayTime(int[][] times, int n, int k){

        // Step 1 : Create Graph
        Map<Integer, List<Pair>> adjList = new HashMap<>();
        for(int[] time : times){
            int u = time[0];
            int v = time[1];
            int w = time[2];
            if(!adjList.containsKey(u)){
                adjList.put(u, new ArrayList<>());
            }
            adjList.get(u).add(new Pair(v, w));
        }

        // Step 2 :
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        int[] timeArray = new int[n+1];
        Arrays.fill(timeArray, Integer.MAX_VALUE);
        timeArray[k] = 0;
        pq.offer(new Pair(k,0));

        // Step 3: Iterate over Graph
        while(!pq.isEmpty()){
            Pair current = pq.poll();
            for (Pair neighbor : adjList.getOrDefault(current.node , Collections.emptyList())){
                int newDistance = (timeArray[current.node]+ neighbor.time);
                if(newDistance < timeArray[neighbor.node]){
                    timeArray[neighbor.node] = newDistance;
                    pq.offer(new Pair(neighbor.node, newDistance));
                }
            }
        }

        // Step 4:
        int maxDistance = 0;
        for(int i=1 ; i<=n;i++){
            if(timeArray[i]==Integer.MAX_VALUE)
                return -1;
            maxDistance = Math.max(maxDistance, timeArray[i]);
        }

        return maxDistance;
    }

    public static void main(String[] args) {
        b_Network_Delay_Time obj = new b_Network_Delay_Time();

        int[][] times = {
                {2, 1, 1},
                {2, 3, 1},
                {3, 4, 1}
        };
        int n = 4, k = 2;

        int result = obj.networkDelayTime(times, n, k);
        System.out.println("Network Delay Time: " + result); // Expected output: 2
    }
}
