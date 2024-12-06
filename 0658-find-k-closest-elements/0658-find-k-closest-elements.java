class Solution {
    class Pair implements Comparable<Pair>{
        int val;
        int dist;

        Pair(int val, int dist) {
            this.val = val;
            this.dist = dist;
        }

        public int compareTo(Pair p) {
            if(this.dist == p.dist) {
                return Integer.compare(this.val, p.val);
            }

            return Integer.compare(this.dist, p.dist);
        }
    }
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        for(int num: arr) {
            pq.add(new Pair(num, Math.abs(num-x)));
        }

        List<Integer> closestElements = new ArrayList<>();
        while(!pq.isEmpty() && k-- > 0) {
            closestElements.add(pq.poll().val);
        }

        Collections.sort(closestElements);
        return closestElements;
    }
}