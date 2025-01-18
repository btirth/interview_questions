class LRUCache {

    /**
    1,1 [1]
    2,2 [1,2]
    
    1 [2,1]

    3,3 [1,3]


    1 head = null, tail = null then head = node, tail = head;
    2 & head 1 -> 
    1 - 2 - 3
    take 2 -> 
                if node.prev != null
                    node.prev.next = node.next;
                else head = node.next;    
                if node.next != null
                    node.next.prev = node.prev;
                else tail = node.prev;    
                
                node.prev = null;
                node.next = null;
                

    tail at 3 -> now we want to add 2 -> tail.next = node; tail = tail.next; [now tail = 2]   


    TC -> O(1), O(1)
    SC -> O(capacity)         
     */
    
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

    Node head;
    Node tail;
    int capacity;
    HashMap<Integer, Node> map; 
    public LRUCache(int capacity) {
        map = new HashMap<>();
        this.capacity = capacity;
    }
    
    public int get(int key) {
        if(!map.containsKey(key)) {
            return -1;
        }

        Node node = remove(key);
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

    void add(int key, int val) {
        Node node = new Node(key, val);
        if(head == null) {
            head = node;
            tail = node;
        }else {
            tail.next = node;
            node.prev = tail;
            tail = tail.next;
        }
        
        map.put(key, node);
        capacity--;
    }

    Node remove(int key) {
        Node node = map.remove(key);
        capacity++;
        if(node.prev != null) {
            node.prev.next = node.next;
        } else {
            head = node.next;
        }

        if(node.next != null) {
            node.next.prev = node.prev;
        } else {
            tail = node.prev;
        }

        node.next = null;
        node.prev = null;
        return node;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */