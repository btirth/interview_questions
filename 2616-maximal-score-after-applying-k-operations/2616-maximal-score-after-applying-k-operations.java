class Solution {
    public long maxKelements(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        long score = 0;

        for(int num: nums) {
            pq.add(num);
        }

        while(k-- > 0 && !pq.isEmpty()) {
            int num = pq.poll(); 
            score += num;
            pq.add((int)Math.ceil((double)num/3));
        }

        return score;
    }
}