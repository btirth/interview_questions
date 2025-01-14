class DetectSquares {
    private Map<Pair<Integer, Integer>, Integer> ptsCount;

    public DetectSquares() {
        ptsCount = new HashMap<>();
    }
    
    public void add(int[] point) {
        Pair p = new Pair(point[0], point[1]);
        ptsCount.put(p, ptsCount.getOrDefault(p, 0) + 1);
    }

    public int count(int[] point) {
        int res = 0;
        int px = point[0], py = point[1];
        for (Map.Entry<Pair<Integer, Integer>, Integer> entry: ptsCount.entrySet()) {
            Pair pt = entry.getKey();

            int x = (int)pt.getKey(), y = (int)pt.getValue();
            if (Math.abs(py - y) != Math.abs(px - x) || x == px || y == py) {
                continue;
            }
            res += entry.getValue() * ptsCount.getOrDefault(new Pair(x, py), 0) * 
                   ptsCount.getOrDefault(new Pair(px, y), 0);
        }
        return res;
    }
}

/**
 * Your DetectSquares object will be instantiated and called as such:
 * DetectSquares obj = new DetectSquares();
 * obj.add(point);
 * int param_2 = obj.count(point);
 */