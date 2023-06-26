class Solution {
    class Pair implements Comparable<Pair>{
        int cost;
        int idx;
        boolean isLeft;
        Pair(int cost, int idx, boolean isLeft) {
            this.cost = cost;
            this.idx = idx;
            this.isLeft = isLeft;
        }

        public int compareTo(Pair p) {
            if(p.cost == this.cost) {
                return Integer.compare(this.idx, p.idx);
            }

            return Integer.compare(this.cost, p.cost);
        }
    }
    public long totalCost(int[] costs, int k, int candidates) {
        int n = costs.length;
        int left = 0;
        int right = n-1;
        PriorityQueue<Pair> heap = new PriorityQueue<>();
        long cost = 0;

        for(int i=0; i<candidates; i++) {
            heap.add(new Pair(costs[left], left, true));
            left++; 
        }

        for(int i=0; i<candidates; i++) {
            if(left >= right) {
                break;
            }

            heap.add(new Pair(costs[right], right, false));
            right--;
        }

        for(int i=0; i<k; i++) {
            Pair p = heap.remove();
            cost += p.cost;

            if(left <= right) {
                if(p.isLeft) {
                    heap.add(new Pair(costs[left], left, true));
                    left++;
                } else {
                    heap.add(new Pair(costs[right], right, false));
                    right--;
                }
            }
        }

        return cost;
    }
}