class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        int n = nums.length;
        HashMap<Long, Integer>[] map = new HashMap[n];
        for(int i=0; i<n; i++) {
            map[i] = new HashMap<>();
        }
        int totalComb = 0;

        for(int i=0; i<n; i++) {
            for(int j=i-1; j>=0; j--) {
                long diff = ((long)nums[i] - (long)nums[j]);
                int seq = 1 + map[j].getOrDefault(diff, 0);
                map[i].put(diff, map[i].getOrDefault(diff, 0) + seq);
                totalComb += seq;
            }
        }

        return totalComb - (n*(n-1))/2;
    }
}