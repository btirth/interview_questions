class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        List<Integer> list = new ArrayList<>();
        Deque<Integer> q = new LinkedList<>();
        int n = nums.length;
        for(int i=0; i<k; i++) {
            while(!q.isEmpty() && q.peekLast() < nums[i]) {
                q.removeLast();
            }

            
                q.add(nums[i]);
            
        }

        list.add(q.peekFirst());

        for(int i=k; i<n; i++) {
            if(q.peekFirst() == nums[i - k]) {
                q.removeFirst();
            }

            while(!q.isEmpty() && q.peekLast() < nums[i]) {
                q.removeLast();
            }

            
                q.add(nums[i]);
            
            list.add(q.peekFirst());
        }

        int[] ans = new int[list.size()];
        int idx = 0;
        for(int num: list) {
            ans[idx++] = num;
        }

        return ans;
    }
}