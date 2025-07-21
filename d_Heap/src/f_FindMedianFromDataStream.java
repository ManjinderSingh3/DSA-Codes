import java.util.*;

public class f_FindMedianFromDataStream {
    /*
    Approach 1 : Brute force approach using list
    List<Integer> list;
    public MedianFinder() {
        list = new ArrayList<>();
    }
    public void addNum(int num) {
        list.add(num);
    }
    public double findMedian() {
        Collections.sort(list);
        int listSize = list.size();
        if(listSize % 2 == 0){
            // Even size list : 1, 2, 3, 4, 5, 6
            return (list.get(listSize/2) + list.get(listSize/2 -1))/2.0;
        }
        // Odd size list : 1,2,3
        return list.get(listSize/2);
    }
    */

    // Approach 2 : Optimized approach
    PriorityQueue<Integer> minHeap ;
    PriorityQueue<Integer> maxHeap ;

    public f_FindMedianFromDataStream() {
        minHeap = new PriorityQueue<Integer>();
        maxHeap = new PriorityQueue<Integer>(Collections.reverseOrder());
    }

    public void addNum(int num) {
        maxHeap.add(num);
        minHeap.add(maxHeap.poll());
        if(minHeap.size()>maxHeap.size()){
            maxHeap.add(minHeap.poll());
        }
    }

    public double findMedian() {
        // Even list
        if(maxHeap.size() == minHeap.size()){
            return (maxHeap.peek()+minHeap.peek())/2.0;
        }
        return maxHeap.peek();
    }

    public static void main(String[] args) {
        f_FindMedianFromDataStream mf = new f_FindMedianFromDataStream();

        int[] nums = {5, 15, 1, 3};
        for (int num : nums) {
            mf.addNum(num);
            System.out.println("After inserting " + num + ", current median: " + mf.findMedian());
        }
    }
}
