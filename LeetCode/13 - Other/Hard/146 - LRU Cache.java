/**
 *
 * 146. LRU Cache
 *    Design and implement a data structure for Least Recently Used (LRU) cache. It
 *    should support the following operations: get and put.
 *
 *    get(key) - Get the value (will always be positive) of the key if the key exists
 *    in the cache, otherwise return -1.
 *    put(key, value) - Set or insert the value if the key is not already present.
 *    When
 *    the cache reached its capacity, it should invalidate the least recently used
 *    item
 *    before inserting a new item.
 *
 *    Follow up:
 *    Could you do both operations in O(1) time complexity?
 *
 *    Example:
 *
 *    LRUCache cache = new LRUCache( 2 /* capacity */ );
*
*    cache.put(1, 1);
*    cache.put(2, 2);
*    cache.get(1);       // returns 1
*    cache.put(3, 3);    // evicts key 2
*    cache.get(2);       // returns -1 (not found)
*    cache.put(4, 4);    // evicts key 1
*    cache.get(1);       // returns -1 (not found)
*    cache.get(3);       // returns 3
*    cache.get(4);       // returns 4
*
* /

class LRUCache {
    HashMap<Integer, Node> map;
    MyLinkedList ls;
    int capacity;

    public LRUCache(int capacity) {
        map = new HashMap<Integer, Node>(capacity);
        this.capacity = capacity;
        ls = new MyLinkedList();
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            ls.removeNode(node);
            ls.appendNode(node);
            return node.val;
        }
        return -1;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            ls.removeNode(node);
            ls.appendNode(node);
            node.val = value;
            return;
        }
        if (map.size() == capacity) {
            Node node = ls.dequeueNode();
            if (node != null) {
                map.remove(node.key);
            }
        }
        Node node = new Node(key, value);
        map.put(key, node);
        ls.appendNode(node);
    }

    class Node {
        Node prev;
        Node next;
        int val;
        int key;
        public Node(int key, int val) {
            this.key = key;
            this.val = val;
            prev = null;
            next = null;
        }
    }

    class MyLinkedList {
        Node head;
        Node tail;

        public MyLinkedList() {
            head = null;
            tail = null;
        }

        public void removeNode(Node node) {
            if (node.next != null) {
                node.next.prev = node.prev;
            }
            if (node.prev != null) {
                node.prev.next = node.next;
            }
            if (head == node) {
                head = node.next;
            }
            if (tail == node) {
                tail = node.prev;
            }
            node.prev = null;
            node.next = null;
        }

        public void appendNode(Node node) {
            if (head == null && tail == null) {
                head = node;
                tail = node;
            } else {
                tail.next = node;
                node.prev = tail;
                tail = node;
            }
        }

        public Node dequeueNode() {
            if (head != null) {
                Node node = head;
                head = head.next;
                node.next = null;
                return node;
            }
            return null;
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */