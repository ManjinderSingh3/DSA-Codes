import java.util.*;

class MaxHeap {
    List<Integer> heap;

    public MaxHeap() {
        heap = new ArrayList<Integer>();
    }

    public MaxHeap(int[] nums) {
        //Build Max heap using array
        int n = nums.length;
        heap = new ArrayList<Integer>();
        for (int num : nums) {
            heap.add(num);
        }

        // Find first parent from bottom
        for (int i = (n / 2) - 1; i >= 0; i--) {
            heapify(i);
        }
    }

    public int peek() {
        if (heap.size() == 0) {
            return -1;
        }
        return heap.get(0);
    }

    public void heapify(int index) {
        int size = heap.size();
        int largest = index;

        while (index < size) {
            int leftChildIndex = 2 * index + 1;
            int rightChildIndex = 2 * index + 2;

            if (leftChildIndex < size && heap.get(largest) < heap.get(leftChildIndex)) {
                largest = leftChildIndex;
            }
            if (rightChildIndex < size && heap.get(largest) < heap.get(rightChildIndex)) {
                largest = rightChildIndex;
            }

            if (index != largest) {
                Collections.swap(heap, largest, index);
                index = largest;
            } else {
                break;
            }

        }
    }

    public void insert(int val) {
        heap.add(val);
        int index = heap.size() - 1;
        while (index > 0) {
            int parentIndex = (index - 1) / 2;
            if (heap.get(parentIndex) < heap.get(index)) {
                Collections.swap(heap, index, parentIndex);
                index = parentIndex;
            } else {
                break;
            }
        }
    }

    public int delete() {
        if (heap.size() == 0) {
            return Integer.MAX_VALUE;
        }
        int lastIndex = heap.size() - 1;
        // Step 1: Swap 1st and last index
        Collections.swap(heap, 0, lastIndex);
        // Step 2: Delete value from last index
        int removedValue = heap.remove(lastIndex);
        // Step 3: Apply heapify to see if the newly inserted element is at right position
        heapify(0);


        return removedValue;
    }

    public void print() {
        for (int i = 0; i < heap.size(); i++) {
            System.out.println(heap.get(i));
        }
    }

}
public class MaxHeap_Implementation {
    public static void main(String[] args) {
        /*
        MaxHeap maxheap = new MaxHeap();
        maxheap.insert(10);
        maxheap.insert(100);
        maxheap.insert(200);
        maxheap.insert(50);
        System.out.println(maxheap.peek());
        System.out.println("Deleting Max value :");
        System.out.println(maxheap.delete());
        */

        int[] nums = {20,10,17,30,40};
        MaxHeap maxHeap = new MaxHeap(nums);
        System.out.println("---- Heap Start ----");
        maxHeap.print();
        System.out.println("---- Heap End ----");
        System.out.println(maxHeap.peek());
        System.out.println(maxHeap.delete());
        System.out.println(maxHeap.peek());
    }
}
