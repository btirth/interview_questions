class Solution {
    public int[] getFinalState(int[] nums, int k, int multiplier) {
        PriorityQueue<Pair<Integer, Integer>> pq = new PriorityQueue<>((a,b) -> {
            int valueComparison = Integer.compare(a.getKey(), b.getKey());
            if(valueComparison == 0) {
                return Integer.compare(a.getValue(), b.getValue());
            }    
            
            return valueComparison;
        });

        for(int i=0; i<nums.length; i++) {
            pq.add(new Pair(nums[i], i));
        }

        while(k-- > 0) {
            Pair p = pq.poll();
            int idx = (int) p.getValue();
            nums[idx] *= multiplier;
            pq.add(new Pair(nums[idx], idx));
        }

        return nums;
    }
}