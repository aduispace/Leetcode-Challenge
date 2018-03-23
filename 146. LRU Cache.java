/*
Design and implement a data structure for Least Recently Used (LRU) cache. It should support the following operations: get and put.

get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
put(key, value) - Set or insert the value if the key is not already present. When the cache reached its capacity, it should invalidate the least recently used item before inserting a new item.

Follow up:
Could you do both operations in O(1) time complexity?

Example:

LRUCache cache = new LRUCache( 2 /* capacity */ );

cache.put(1, 1);
cache.put(2, 2);
cache.get(1);       // returns 1
cache.put(3, 3);    // evicts key 2
cache.get(2);       // returns -1 (not found)
cache.put(4, 4);    // evicts key 1
cache.get(1);       // returns -1 (not found)
cache.get(3);       // returns 3
cache.get(4);       // returns 4

*/

public class LRUCache {
    public class Node {
        int key;
        int value;
        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
    public Map<Integer, Node> map = new HashMap<Integer, Node>();
    public List<Node> cache = new LinkedList<Node>();
    public int size = cache.size();
    public int capacity;
    
    public LRUCache(int capacity) {
        this.capacity = capacity;
    }
    
    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        } else { // get will update the cache as well!
            Node oldNode = map.get(key);
            Node newNode = new Node(key, oldNode.value);
            cache.remove(oldNode);
            cache.add(newNode);
            map.put(key, newNode);
            return oldNode.value;
        }
    }
    
    public void put(int key, int value) {
        Node node = new Node(key, value);
        if (!map.containsKey(key)) {
            if (size < capacity) {
                map.put(key, node);
                cache.add(node);
                size++;
            } else { // ejection
                Node ejection = cache.remove(0);
                map.remove(ejection.key);
                map.put(key, node);
                cache.add(node);
            }
        } else { // swap
            Node oldNode = map.get(key);
            Node newNode = new Node(key, value);
            cache.remove(oldNode);
            cache.add(newNode);
            map.put(key, newNode);
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
