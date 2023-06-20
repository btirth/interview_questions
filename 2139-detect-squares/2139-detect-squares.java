class DetectSquares {

    HashMap<String, Integer> freq; 
    public DetectSquares() {
        freq = new HashMap<>();
    }
    
    public void add(int[] point) {
        String key = point[0]+"-"+point[1];
        freq.put(key, freq.getOrDefault(key, 0) + 1);
        System.out.println("Key -- " + key);
    }
    
    public int count(int[] point) {
        int count = 0;

        for(Map.Entry<String, Integer> e: freq.entrySet()) {
            String[] keyPt = e.getKey().split("-");
            int[] pt = new int[]{Integer.valueOf(keyPt[0]), Integer.valueOf(keyPt[1])};
            if(Math.abs(point[0]-pt[0]) != Math.abs(point[1]-pt[1]) 
                || point[0] == pt[0] || point[1] == pt[1]) {
                continue;
            }

                String topPtKey = pt[0] +"-"+ point[1];
                String bottomPtKey = point[0] +"-"+ pt[1];
                if(freq.containsKey(topPtKey) && freq.containsKey(bottomPtKey)) {
                    count += (freq.get(bottomPtKey) * freq.get(topPtKey) * e.getValue());
                }
        }

        return count;   
    }
}

/**
 * Your DetectSquares object will be instantiated and called as such:
 * DetectSquares obj = new DetectSquares();
 * obj.add(point);
 * int param_2 = obj.count(point);
 */