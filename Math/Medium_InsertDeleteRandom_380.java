package Leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
    Design a data structure that supports all following operations in average O(1) time.

    insert(val): Inserts an item val to the set if not already present.
    remove(val): Removes an item val from the set if present.
    getRandom: Returns a random element from current set of elements. Each element must have the same probability of being returned.
    Example:

    // Init an empty set.
    RandomizedSet randomSet = new RandomizedSet();

    // Inserts 1 to the set. Returns true as 1 was inserted successfully.
    randomSet.insert(1);

    // Returns false as 2 does not exist in the set.
    randomSet.remove(2);

    // Inserts 2 to the set, returns true. Set now contains [1,2].
    randomSet.insert(2);

    // getRandom should return either 1 or 2 randomly.
    randomSet.getRandom();

    // Removes 1 from the set, returns true. Set now contains [2].
    randomSet.remove(1);

    // 2 was already in the set, so return false.
    randomSet.insert(2);

    // Since 2 is the only number in the set, getRandom always return 2.
    randomSet.getRandom();
 */
public class Medium_InsertDeleteRandom_380 {
    // 思路：由于要求各个操作为O(1)，insert/getRandom很好做，重点是remove
    // 如果用HashSet直接remove，时间复杂度为O(n)
    // 所以用map + list来做：list放元素，Map中key是元素，值为目前list的size
    // 删除的时候把要删除的元素和list尾部元素swap后，再list.remove(list.size() - 1)
    // swap为constant time所以整个操作为O(1)
    private Map<Integer, Integer> map;
    private List<Integer> list;
    java.util.Random rand = new java.util.Random();
    /** Initialize your data structure here. */
    public Medium_InsertDeleteRandom_380() {
        map = new HashMap<>();
        list = new ArrayList<>();
    }

    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if(map.containsKey(val)) {return false;}
        map.put(val, list.size());
        list.add(val);
        return true;
    }

    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if(!map.containsKey(val)) {return false;}
        if(map.get(val) != list.size() - 1){
            int temp = list.get(list.size() - 1);
            list.set(map.get(val), temp);
            map.put(temp, map.get(val));
        }
        list.remove(list.size() - 1);
        map.remove(val);
        return true;
    }

    /** Get a random element from the set. */
    public int getRandom() {
        return list.get(rand.nextInt(list.size()));
    }
}
