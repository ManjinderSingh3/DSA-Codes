package main.java.IMap.CHashMap;
/*
    Properties of HashMap class:
    1- They are unordered maps i.e, Insertion order is not maintained
 */
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class InbuiltHashMapImplementation {
    public static void main(String[] args) {
        HashMap<String, Integer> hashMap = new HashMap<>();

        // 1- INSERTION
        hashMap.put("India", 129);
        hashMap.put("USA", 58);
        hashMap.put("China",135);
        hashMap.put("Russia",45);
        System.out.println(hashMap);
        // If key is already there, and we insert new value for existing key, hashMap will update the existing value.
        hashMap.put("India",110);
        System.out.println(hashMap);

        // 2- SEARCH
        if(hashMap.containsKey("USA")){
            System.out.println("Key is present");
        }else {
            System.out.println("Key is not present");
        }
        // search value corresponding to a key
        System.out.println(hashMap.get("USa"));

        // 3- ITERATION in HashMap
        // Method (a)- Using Entry Set
        for(Map.Entry<String,Integer> element: hashMap.entrySet()){
            System.out.println(element);
        }

        // Method (b)- Using Key Set
        // get SET of only keys from map
        Set<String> keys =hashMap.keySet();
        for(String key:keys){
            System.out.println(key+"-"+hashMap.get(key));
        }

        //4- Remove key-value pair from hash map
        hashMap.remove("USA");
        System.out.println(hashMap);

    }
}
