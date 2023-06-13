package main.java.IMap.CHashMap;
/*
1) HashMap is implemented using Array of LinkedList. At every index of Array we have a linked List/\.
    ---------------------------------------
    |   LL    |   LL    |    LL   |  LL   |
    ---------------------------------------

           -----------------
           |                |
    key -> |  Hash Function |   -> Bucket Index
           |                |
           ------------------
2) A good hash function is one which distributes nodes/data evenly across different bucket index
3) Time complexity required to search if a node is present in HashMap = O(linkedList size)
4) On an average size of each Linked list will be n/N = lambda
    where,  n= Number of nodes
            N= Bucket Index/ Or size of array

    HashMap is implemented in such a way that (lambda) will always be less than or equal to constant 'K'.

5) When value of (lambda) increases 'k' , we perform re-hashing/ increase the size of Array or increase bucket size.
    Array size can be increased twice, thrice, etc.
6) When we perform re-hashing our array size changes, or we can say that our HashMap changes. In that case there is a
    possibility that bucket index for a key will change.
    For example - If node {"India" - 100} was stored at bucket index-1 in original array. This key might be now stored
                  at bucket index-3 in new hashMap.

 */

import java.util.ArrayList;
import java.util.LinkedList;

public class CustomHashMapImplementation {
    static class HashMap<K,V>{ //generics type key and value
        private class Node{
            K key;
            V value;
            public Node(K key, V value) {
                this.key = key;
                this.value = value;
            }
        }
        private int n; // Number of nodes
        private int N; // Bucket index or size of array
        private LinkedList<Node> buckets[]; // Array of size N

        public HashMap(){
            this.N=4;
            this.buckets = new LinkedList[4];
            // create an empty linked list at each index of array.
            for(int i=0;i<N;i++){
                buckets[i] = new LinkedList<>();
            }
        }

        /*
            Time Complexity:
                Average case - O(1) or O(lambda) , where lambda is size of linkedlist
                Worst case - O(n). It occurs when our Hash function is not optimized. It means hash function will
                                    return same bucket index for most keys or all the keys.
         */
        public void put(K key, V value){
            int bucketIndex = hashFunction(key);
            int dataIndex = searchInLinkedList(key,bucketIndex) ;// will search key at bucketList/index of array
            if(dataIndex==-1){
                // It means key does not exit;
                buckets[bucketIndex].add(new Node(key, value));
                n++;
            }else{
                // key already exist
                Node existingNode = buckets[bucketIndex].get(dataIndex);
                existingNode.value = value;
            }
            double lambda = (double) n/N;
            if(lambda>2.0){
                // perform rehashing
                rehash();
            }
        }

        private int hashFunction(K key){
            int bi = key.hashCode();
            return Math.abs(bi)%N;
        }

        private int searchInLinkedList(K key, int bucketIndex){
            LinkedList<Node> linkedList = buckets[bucketIndex];
            for (int i=0;i<linkedList.size();i++){
                if(linkedList.get(i).key == key){
                    return i; // i= data Index
                }
            }
            return -1;
        }

        private void rehash(){
            LinkedList<Node> oldBuckets[] = buckets;
            buckets = new LinkedList[N*2];

            // created empty linked list at each index of array/ bucketindex
            for(int i=0;i<buckets.length;i++){
                buckets[i] = new LinkedList<>();
            }

            for(int i=0;i<oldBuckets.length;i++){
                LinkedList<Node> linkedList = oldBuckets[i];
                for(int j=0;j<linkedList.size();j++){
                    Node existingNode = linkedList.get(j);
                    put(existingNode.key, existingNode.value);
                }
            }
        }
        // 2- GET method Implementation
        public V get(K key){
            int bi = hashFunction(key);
            int di = searchInLinkedList(key,bi);
            if(di == -1){
                // key does not exist
                return null;
            }else{
                Node node = buckets[bi].get(di);
                return node.value;
            }
        }

        // 3- Contains Key method Implementation
        public boolean containsKey(K key){
            int bi = hashFunction(key);
            int di = searchInLinkedList(key,bi);
            if(di==-1){
                return false;
            }
            return true;
        }

        // 4- REMOVE method implementation
        public V remove(K key){
            int bi = hashFunction(key);
            int di = searchInLinkedList(key,bi);
            if(di==-1){
                return null;
            }else{
                Node node = buckets[bi].remove(di);
                n--;
                return node.value;
            }
        }

        // 5- keySet method implementation
        public ArrayList<K> keySet(){
            ArrayList arrayList = new ArrayList();
            for(int bi=0;bi<buckets.length;bi++){
                LinkedList<Node> linkedList = buckets[bi];
                for(int di=0; di<linkedList.size();di++){
                    Node node = linkedList.get(di);
                    arrayList.add(node.key);
                }
            }
            return arrayList;
        }
    }

    public static void main(String[] args) {
        HashMap<String,Integer> map = new HashMap<>();
        map.put("India",200);
        map.put("China",190);
        map.put("USA", 140);
        System.out.println(map.get("IndiA"));
        System.out.println(map.containsKey("USA"));
        System.out.println(map.keySet());
        //System.out.println(map.remove("China"));
        //System.out.println(map.keySet());

        ArrayList<String> keys = map.keySet();
        for(int i=0;i<keys.size();i++){
            System.out.println(keys.get(i)+"-"+map.get(keys.get(i)));
        }
    }
}
