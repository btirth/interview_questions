class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> freq = new HashMap<>();

        for(int num: nums) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>((n1, n2) ->  freq.get(n2) - freq.get(n1));

        for(int n: freq.keySet()) {
            pq.add(n);
        }

        int[] res = new int[k];

        for(int i=0; i<k; i++) {
            res[i] = pq.poll();
        }

        return res;
    }
}