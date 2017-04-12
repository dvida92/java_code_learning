package Basics.Data_Structure;

import java.util.HashMap;

/**
 * Created by davidzhou on 4/11/17.
 * Hashmap is unsynchronized
 */
public class test_hashMap {
    public static void main(String[] args) {
        HashMap<String, Integer> hashMap = new HashMap<>();
        System.out.println("hashMap = " + hashMap);

        //put: put a key:value pair to the map
        hashMap.put("apple", 5);
        hashMap.put("banana", 6);
        hashMap.put("plum", 4);
        hashMap.put("fig", 3);
        System.out.println(hashMap.get("apple"));
        System.out.println(hashMap.values());
        int size = hashMap.size();
        System.out.println("size = " + size);
    }
}
