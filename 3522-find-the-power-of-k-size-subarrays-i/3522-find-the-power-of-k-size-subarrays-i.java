class Solution {
    public int[] resultsArray(int[] nums, int k) {
        int n = nums.length;
        int[] ans = new int[n-k+1];
        Arrays.fill(ans, -1);
        int lastMisMatch = -1;

        Deque<Integer> deque = new ArrayDeque<>();
        for(int i=0; i<n; i++) {
            if(i>=k && deque.peekFirst() == nums[i-k]) {
                deque.pollFirst();
            }

            while(!deque.isEmpty() && deque.peekLast() < nums[i]) {
                deque.pollLast();
            }

            deque.add(nums[i]);

            if(i != 0 && nums[i] != nums[i-1] + 1) {
                lastMisMatch = i-1;
            }

            if(lastMisMatch < i-k+1 && i>=k-1) {
                ans[i-k+1] = deque.peekFirst();
            }
        }

        return ans;
    }
}