class MyHashSet {
    List<Integer>[] hashSet;
    int capacity = 1000;

    public MyHashSet() {
        hashSet = new ArrayList[capacity];    
    }
    
    public void add(int key) {
        if(contains(key)) {
            return;
        }

        int hash = getHash(key);
        if(hashSet[hash] == null) {
            hashSet[hash] = new ArrayList<>();
        }

        hashSet[hash].add(key);
    }
    
    public void remove(int key) {
        if(!contains(key)) {
            return;
        }

        hashSet[getHash(key)].remove(new Integer(key));
    }
    
    public boolean contains(int key) {
        int hash = getHash(key);
        if(hashSet[hash] == null) {
            return false;
        }
        return hashSet[hash].contains(key);
    }

    private int getHash(int key) {
        return key%capacity;
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */