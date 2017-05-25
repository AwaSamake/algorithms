/*
@Copyright:LintCode
@Author:   LLihao
@Problem:  http://www.lintcode.com/problem/insert-delete-getrandom-o1
@Language: Java
@Datetime: 17-05-24 22:44
*/

public class RandomizedSet {
    ArrayList<Integer> list;
    HashMap<Integer, Integer> map;
    Random rand;

    public RandomizedSet() {
        // do initialize if necessary
        list = new ArrayList<>();
        map = new HashMap<>();
        rand = new Random();
    }
    
    // Inserts a value to the set
    // Returns true if the set did not already contain the specified element or false
    public boolean insert(int val) {
        if (!map.containsKey(val)) {
            // put Entry<val, index> into the map
            map.put(val, list.size());
            list.add(val);
            return true;
        }
        return false;
    }
    
    // Removes a value from the set
    // Return true if the set contained the specified element or false
    public boolean remove(int val) {
        if (map.containsKey(val)) {
            // remove the val from hashmap and get location of the value in list
            int loc = map.remove(val);
            // remove last element from list
            int last = list.get(list.size() - 1);
            // override the val with the last element removed
            list.set(loc, last);
            // remove the last element in the list
            list.remove(list.size() - 1);
            // update the index of the element removed frmo the end
            map.put(last, loc);
            return true;
        }
        return false;
    }
    
    // Get a random element from the set
    public int getRandom() {
        // Write your code here
        return list.get(rand.nextInt(list.size()));
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param = obj.insert(val);
 * boolean param = obj.remove(val);
 * int param = obj.getRandom();
 */