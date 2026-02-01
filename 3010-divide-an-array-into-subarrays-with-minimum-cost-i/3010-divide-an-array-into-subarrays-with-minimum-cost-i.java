class Solution {
    public int minimumCost(int[] nums) {
        int cost = nums[0];
        PriorityQueue<Integer> pq = new PriorityQueue<>(2);
        for(int i=1; i<nums.length; i++) {
            pq.add(nums[i]);
        }

        return cost + pq.poll() + pq.poll();
    }
}