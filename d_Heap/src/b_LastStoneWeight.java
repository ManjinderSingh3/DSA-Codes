/*
    Time Complexity : O(nlogn)
    Space Complexity : O(n)
    Author : Manjinder Singh
 */
import java.util.*;
public class b_LastStoneWeight {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        for(int stone: stones){
            maxHeap.add(stone);
        }

        while(maxHeap.size()>=2){
            int y = maxHeap.poll();
            int x = maxHeap.poll();

            if(x == y)
                continue;
            maxHeap.add(y-x);
        }
        return maxHeap.size() == 1 ? maxHeap.poll() : 0;
    }

    public static void main(String[] args) {
        b_LastStoneWeight obj = new b_LastStoneWeight();
        int[] stones = {2, 7, 4, 1, 8, 1};
        int result = obj.lastStoneWeight(stones);
        System.out.println("Last stone weight: " + result);
    }
}
