class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> ans = new ArrayList<>();
        int len1 = nums1.length;
        int len2 = nums2.length;
        PriorityQueue<Integer[]> pq = new PriorityQueue<>((a,b) -> Integer.compare(a[0], b[0]));
        HashSet<Pair<Integer, Integer>> processed = new HashSet<>();

        pq.add(new Integer[]{nums1[0]+nums2[0], 0, 0});

        while(!pq.isEmpty() && ans.size() < k) {
            Integer[] p = pq.poll();
            int i = (int)p[1];
            int j = (int)p[2];

            List<Integer> pair = new ArrayList<>();
            pair.add(nums1[i]);
            pair.add(nums2[j]);
            ans.add(pair);

            Pair next1 = new Pair(i+1, j);
            Pair next2 = new Pair(i, j+1);
            if(i+1 < len1 && !processed.contains(next1)) {
                pq.add(new Integer[]{nums1[i+1]+nums2[j], i+1, j});
                processed.add(next1);
            }
            if(j+1 < len2 && !processed.contains(next2)) {
                pq.add(new Integer[]{nums1[i]+nums2[j+1], i, j+1});
                processed.add(next2);
            }
        }

        return ans;
    }
}