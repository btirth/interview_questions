class NumberContainers {
    HashMap<Integer, PriorityQueue<Integer>> indexMap = new HashMap<>();
    HashMap<Integer, Integer> indexValMap = new HashMap<>();
    public NumberContainers() {
        
    }
    
    public void change(int index, int number) {
        indexValMap.put(index, number);
        PriorityQueue<Integer> pq = indexMap.getOrDefault(number, new PriorityQueue<>());
        pq.add(index);
        indexMap.put(number, pq);
    }
    
    public int find(int number) {
        if(!indexMap.containsKey(number)) {
            return -1;
        }

        PriorityQueue<Integer> set = indexMap.get(number);
       
        while(!set.isEmpty() && indexValMap.get(set.peek()) != number) {
            set.poll();
        }

         if(set.isEmpty()) {
            return -1;
        }

        return set.peek();
    }
}

/**
 * Your NumberContainers object will be instantiated and called as such:
 * NumberContainers obj = new NumberContainers();
 * obj.change(index,number);
 * int param_2 = obj.find(number);
 */