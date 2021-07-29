/*

Design and implement a data structure for a Least Frequently Used (LFU) cache.

Implement the LFUCache class:
  LFUCache(int capacity) Initializes the object with the capacity of the data structure.
  int get(int key) Gets the value of the key if the key exists in the cache. Otherwise, returns -1.
  void put(int key, int value) Update the value of the key if present, or inserts the key if not already present. When the cache reaches its capacity, it should invalidate and remove the least frequently used key before inserting a new item. 
  For this problem, when there is a tie (i.e., two or more keys with the same frequency), the least recently used key would be invalidated.
  To determine the least frequently used key, a use counter is maintained for each key in the cache. The key with the smallest use counter is the least frequently used key.

When a key is first inserted into the cache, its use counter is set to 1 (due to the put operation). The use counter for a key in the cache is incremented either a get or put operation is called on it.

The functions get and put must each run in O(1) average time complexity.

 

Example 1:
  Input
    ["LFUCache", "put", "put", "get", "put", "get", "get", "put", "get", "get", "get"]
    [[2], [1, 1], [2, 2], [1], [3, 3], [2], [3], [4, 4], [1], [3], [4]]
  Output
    [null, null, null, 1, null, -1, 3, null, -1, 3, 4]
  Explanation
    // cnt(x) = the use counter for key x
    // cache=[] will show the last used order for tiebreakers (leftmost element is  most recent)
    LFUCache lfu = new LFUCache(2);
    lfu.put(1, 1);   // cache=[1,_], cnt(1)=1
    lfu.put(2, 2);   // cache=[2,1], cnt(2)=1, cnt(1)=1
    lfu.get(1);      // return 1
                     // cache=[1,2], cnt(2)=1, cnt(1)=2
    lfu.put(3, 3);   // 2 is the LFU key because cnt(2)=1 is the smallest, invalidate 2.
                     // cache=[3,1], cnt(3)=1, cnt(1)=2
    lfu.get(2);      // return -1 (not found)
    lfu.get(3);      // return 3
                     // cache=[3,1], cnt(3)=2, cnt(1)=2
    lfu.put(4, 4);   // Both 1 and 3 have the same cnt, but 1 is LRU, invalidate 1.
                     // cache=[4,3], cnt(4)=1, cnt(3)=2
    lfu.get(1);      // return -1 (not found)
    lfu.get(3);      // return 3
                     // cache=[3,4], cnt(4)=1, cnt(3)=3
    lfu.get(4);      // return 4
                     // cache=[3,4], cnt(4)=2, cnt(3)=3
 
Constraints:
  0 <= capacity <= 10^4
  0 <= key <= 10^5
  0 <= value <= 10^9
  At most 2 * 10^5 calls will be made to get and put

*/



class LFUCache {
    final int capacity;
    int cache_size;
    int minFreq;
    Map<Integer, DLLNode> cache;
    Map<Integer, DoubleLinkedList> freq;
    
    public LFUCache(int capacity) {
        this.capacity = capacity;
        cache_size = 0;
        minFreq = 0;
        cache = new HashMap<>();
        freq = new HashMap<>();
    }
    
    public int get(int key) {
        DLLNode curNode = cache.get(key);
        if(curNode == null) {
            return -1;
        }
        update(curNode);
        return curNode.val;
    }
    
    public void put(int key, int value) {
        if(capacity == 0) {
            return;
        }
        
        if(cache.containsKey(key)) {
            DLLNode curNode = cache.get(key);
            curNode.val = value;
            update(curNode);
        } else {
            cache_size++;
            if(cache_size > capacity) {
                DoubleLinkedList minFreqList = freq.get(minFreq);
                cache.remove(minFreqList.tail.prev.key);
                minFreqList.removeNode(minFreqList.tail.prev);
                cache_size--;
            }
            // reset min frequency to 1 because of adding new node
            minFreq = 1;
            DLLNode newNode = new DLLNode(key, value);
            
            DoubleLinkedList curList = freq.getOrDefault(1, new DoubleLinkedList());
            curList.addNode(newNode);
            freq.put(1,curList);
            cache.put(key, newNode);
            
        }
    }
    
    public void update(DLLNode node) {
        int nodeFreq = node.freq;
        DoubleLinkedList curList = freq.get(nodeFreq);
        curList.removeNode(node);
        
        // if current list the the last list which has lowest frequency and current node is the only node in that list
        // we need to remove the entire list and then increase min frequency value by 1
        if(nodeFreq == minFreq && curList.listSize == 0) {
            minFreq++;
        }
        
        node.freq++;
        DoubleLinkedList newList = freq.getOrDefault(node.freq, new DoubleLinkedList());
        newList.addNode(node);
        freq.put(node.freq, newList);
    }
}


class DLLNode {
    int key;
    int val;
    int freq;
    DLLNode prev;
    DLLNode next;
    
    DLLNode(int key, int val) {
        this.key = key;
        this.val = val;
        this.freq = 1;
    }
}

class DoubleLinkedList {
    int listSize;
    DLLNode head;
    DLLNode tail;
    
    public DoubleLinkedList() {
        listSize = 0;
        head = new DLLNode(0,0);
        tail = new DLLNode(0,0);
        head.next = tail;
        tail.prev = head;
    }
    
    public void addNode(DLLNode node) {
        DLLNode nextNode = head.next;
        head.next = node;
        node.next = nextNode;
        nextNode.prev = node;
        node.prev = head;
        listSize++;
    }
    
    public void removeNode(DLLNode node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
        listSize--;
    }
}
/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
