import java.util.PriorityQueue;

public class c_KClosestPointsToOrigin {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((e1, e2)->{
            return e2[0] - e1[0];
        });
        for(int i=0; i<points.length; i++){
            int[] point = points[i];
            int x  = point[0];
            int y = point[1];
            int dis = (x*x)+(y*y);
            maxHeap.add(new int[]{
                    dis,
                    i
            });
            if(maxHeap.size()>k){
                maxHeap.poll();
            }
        }

        int[][] result = new int[k][2];
        int i=0;
        while(i<k){
            int[] currentArray = maxHeap.poll();
            int index = currentArray[1];

            result[i][0] = points[index][0];
            result[i][1] = points[index][1];

            i++;
        }
        return result;
    }

    public static void main(String[] args) {
        c_KClosestPointsToOrigin obj = new c_KClosestPointsToOrigin();
        // Sample input: list of points and k value
        int[][] points = {
                {1, 3},
                {-2, 2},
                {5, 8},
                {0, 1}
        };
        int k = 2;

        // Call the method
        int[][] closestPoints = obj.kClosest(points, k);
        // Print the result
        System.out.println("The " + k + " closest points to the origin are:");
        for (int[] point : closestPoints) {
            System.out.println("[" + point[0] + ", " + point[1] + "]");
        }
    }
}
