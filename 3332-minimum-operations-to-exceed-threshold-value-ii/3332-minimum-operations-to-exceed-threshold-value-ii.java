class Solution {
    public int minOperations(int[] nums, int k) {
        PriorityQueue<Long> pq = new PriorityQueue<>();
        for(int num: nums) {
            pq.add((long)num);
        }

        int ops = 0;
        while(pq.size() >= 2 && pq.peek() < k) {
            long num1 = pq.poll();
            long num2 = pq.poll();
            long num = (Math.min(num1, num2) * 2) + Math.max(num1, num2);
            pq.add(num);
            ops++;
        }

        return ops;
    }
}