class Solution {
    class Pair {
        int n1;
        int n2;

        Pair(int n1, int n2) {
            this.n1 = n1;
            this.n2 = n2;
        }
    }

    public long maxScore(int[] nums1, int[] nums2, int k) {
        int n = nums1.length;
        Pair[] pairs = new Pair[n];

        for(int i=0; i<n; i++) {
            pairs[i] = new Pair(nums1[i], nums2[i]);
        }    

        Arrays.sort(pairs, (a, b) -> Integer.compare(b.n2, a.n2));

        long ans = 0;
        long sum = 0;
        int i = 0; 
        PriorityQueue<Integer> pq = new PriorityQueue<>(k);

        while(i < n) {
            Pair p = pairs[i];
            pq.add(p.n1);
            sum += p.n1;

            if(pq.size() == k) {
                ans = Math.max(ans, sum*p.n2);
                sum -= pq.poll();
            }
            
            i++;
        }
        
        return ans;
    }
}