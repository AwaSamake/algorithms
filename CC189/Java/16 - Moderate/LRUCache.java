/**
 *
 * 16.25 LRU Cache
 *     design and build a "least recently used" cache, which evicts the least recently 
 *     used item. The cache should map from keys to values (allowing you to insert and 
 *     retrieve  a value associated with a particular key) and be initialized with a max 
 *     size. When it is full, it should evict the least recently used item. You can assume 
 *     the keys are integers and the values are strings.
 *
 */
import java.util.*;

/*==============================================
=            NOT OPTIMIZED SOLUTION            =
==============================================*/
class LRUCache {
	private HashMap<Integer, String> lrc = new HashMap<Integer, String>();
	private LinkedList<Integer> list = new LinkedList<Integer>();
	private int SIZE;
	
	public LRUCache(int size) {
		this.SIZE = size;
	}
	
	public void insert(int key, String value) {
		if (list.size() < SIZE) {
			list.add(key);
			lrc.put(key, value);
		} else if (lrc.containsKey(key)) {
			lrc.put(key, value);
		} else {
			lrc.put(key, value);
			int remove = list.removeFirst();
			lrc.remove(remove);
		}
	}
	
	public String getValue(int key) {
		if (lrc.containsKey(key)) {
			int index = list.indexOf(key);
			int key = list.remove(index);
			list.add(key);
			return lrc.get(key);
		}
		return null;
	}
}

class test {
	public static void main(String[] args) {
		
	}
}