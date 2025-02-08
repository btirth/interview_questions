class NumberContainers {
    HashMap<Integer, PriorityQueue<Integer>> indexMap = new HashMap<>();
    HashMap<Integer, Integer> indexValMap = new HashMap<>();
    public NumberContainers() {
        
    }
    
    public void change(int index, int number) {
        if(indexValMap.containsKey(index)) {
            int prevNum = indexValMap.get(index);
            PriorityQueue<Integer> set = indexMap.get(prevNum);
            indexMap.put(prevNum, set);
        }

        indexValMap.put(index, number);
        PriorityQueue<Integer> set = indexMap.getOrDefault(number, new PriorityQueue<>());
        set.add(index);
        indexMap.put(number, set);
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