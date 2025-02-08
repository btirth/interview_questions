class NumberContainers {
    HashMap<Integer, TreeSet<Integer>> indexMap = new HashMap<>();
    HashMap<Integer, Integer> indexValMap = new HashMap<>();
    public NumberContainers() {
        
    }
    
    public void change(int index, int number) {
        if(indexValMap.containsKey(index)) {
            int prevNum = indexValMap.get(index);
            TreeSet<Integer> set = indexMap.get(prevNum);
            set.remove(index);
            indexMap.put(prevNum, set);
        }

        indexValMap.put(index, number);
        TreeSet<Integer> set = indexMap.getOrDefault(number, new TreeSet<>());
        set.add(index);
        indexMap.put(number, set);
    }
    
    public int find(int number) {
        if(!indexMap.containsKey(number)) {
            return -1;
        }

        TreeSet<Integer> set = indexMap.get(number);
        if(set.isEmpty()) {
            return -1;
        }

        return set.first();
    }
}

/**
 * Your NumberContainers object will be instantiated and called as such:
 * NumberContainers obj = new NumberContainers();
 * obj.change(index,number);
 * int param_2 = obj.find(number);
 */