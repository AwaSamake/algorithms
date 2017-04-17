/**
 *
 * 380. Insert Delete GetRandom O(1)
 *    Design a data structure that supports all following operations in average O(1) time.
 *    
 *    insert(val): Inserts an item val to the set if not already present.
 *    remove(val): Removes an item val from the set if present.
 *    getRandom: Returns a random element from current set of elements. Each element must 
 *    have the same probability of being returned.
 *
 */
import java.util.*;

public class RandomizedSet {
	ArrayList<Integer> data;
	HashMap<Integer, Integer> dataLocation;
	Random rand;
	
	/** Initialize your data structure here. */
	public RandomizedSet() {
		data = new ArrayList<Integer>();
		dataLocation = new HashMap<Integer, Integer>();
		rand = new Random();
	}
	
	/** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
	public boolean insert(int val) {
		if (dataLocation.containsKey(val)) {
			return false;
		}
		dataLocation.put(val, data.size());
		data.add(val);
		return true;
	}
	
	/** Removes a value from the set. Returns true if the set contained the specified element. */
	public boolean remove(int val) {
		if (!dataLocation.containsKey(val)) {
			return false;
		}
		int index = dataLocation.get(val);
		if (index < data.size() - 1) {
			int lastVal = data.get(data.size() - 1);
			data.set(index, lastVal);
			dataLocation.remove(lastVal);
			dataLocation.put(lastVal, index);
		}
		dataLocation.remove(val);
		data.remove(data.size() - 1);
		return true;
	}
	
	/** Get a random element from the set. */
	public int getRandom() {
		if (data.size() < 1) {
			return -1;
		}
		return data.get(rand.nextInt(data.size()));
	}
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */