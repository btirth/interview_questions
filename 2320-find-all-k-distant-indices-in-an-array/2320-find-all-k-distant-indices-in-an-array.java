class Solution {
    public List<Integer> findKDistantIndices(int[] nums, int key, int k) {
        List<Integer> ans = new ArrayList<>();
        int n = nums.length;
        Queue<Integer> q = new LinkedList<>();
        int lastKeyIdx = -1;

        int idx = 0;
        while(idx < n) {
            if(nums[idx] == key) {
                lastKeyIdx = idx;
                while(!q.isEmpty()) {
                    
                    int i = q.poll();
                    if(Math.abs(i - lastKeyIdx) <= k) {
                        ans.add(i);
                    }
                }
                ans.add(idx);
                
            } else if(lastKeyIdx != -1 && Math.abs(idx - lastKeyIdx) <= k) {
                ans.add(idx);
            } else {
                q.add(idx);
            }

            idx++;
        }

        return ans;
    }
}