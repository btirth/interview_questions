class LRUCache {
    class Node {
        int key;
        int val;
        Node prev;
        Node next;

        Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

    int capacity;
    HashMap<Integer, Node> map;
    Node head;
    Node tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;  
        map = new HashMap<>();  
    }
    
    public int get(int key) {
        if(!map.containsKey(key)) {
            return -1;
        }

        Node node = map.get(key);
        remove(key);
        add(key, node.val);
        return node.val;
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)) {
            remove(key);
        }

        if(capacity == 0) {
            remove(head.key);
        }

        add(key, value);
    }

    void remove(int key) {
        Node node = map.get(key);

        if(node.prev == null) {
            head = node.next;
        } else {
            node.prev.next = node.next;
        }

        if(node.next == null) {
            tail = node.prev;
        } else {
            node.next.prev = node.prev;
        }

        capacity++;
        map.remove(key);
    }

    void add(int key, int value) {
        Node node = new Node(key, value);
        if(tail == null) {
            head = node;
            tail = head;
        } else {
            tail.next = node;
            node.prev = tail;
            tail = tail.next;
        }

        capacity--;
        map.put(key, node);
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */