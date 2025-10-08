import java.util.*;

public class e_KthSmallestElementInASortedMatrix {
    public int kthSmallest(int[][] matrix, int k) {
        /*

        // Approach 1 : Brute For approach
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        int rows = matrix.length;
        int cols = matrix[0].length;
        // T.C = o(m*n * logk) for insertion
        for(int i=0; i<rows; i++){
            for(int j=0; j<cols; j++){
                maxHeap.add(matrix[i][j]);
                if(maxHeap.size()>k)
                    maxHeap.poll();
            }
        }
        return maxHeap.peek();
        */

        // Approach 2 :
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((e1,e2)->e1[0]-e2[0]);
        int rows = matrix.length, cols=matrix[0].length;

        // T.C = o(min(rows,k) * o(log(min(rows,k)))
        // S.C = o(k)
        for(int i=0; i<Math.min(rows,k); i++){
            minHeap.add(new int[]{
                    matrix[i][0],
                    i,
                    0
            });
        }

        // T.c - o(klogk)
        for(int i=0; i<k-1; i++){
            int[] minValueArray = minHeap.poll();
            int value = minValueArray[0];
            int row = minValueArray[1];
            int col = minValueArray[2];
            if(col < cols-1){
                minHeap.add(new int[]{
                        matrix[row][col+1],
                        row,
                        col+1,
                });
            }
        }
        return minHeap.peek()[0];
    }

    public static void main(String[] args) {
        e_KthSmallestElementInASortedMatrix sol = new e_KthSmallestElementInASortedMatrix();

        int[][] matrix = {
                {1, 3, 8, 10},
                {6, 7, 12, 13},
                {7, 12, 30, 50},
                {9, 14, 42, 60}
        };
        int k = 4;

        int result = sol.kthSmallest(matrix, k);
        System.out.println("The " + k + "-th smallest element is: " + result);
    }
}
