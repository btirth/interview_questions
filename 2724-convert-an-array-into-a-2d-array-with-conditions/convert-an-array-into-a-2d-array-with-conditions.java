class Solution {
    public List<List<Integer>> findMatrix(int[] nums) {
        int n = nums.length;
        int[] count = new int[n+1];
        int maxCount = 0;
        for(int i=0; i<n; i++) {
            count[nums[i]]++;
            maxCount = Math.max(maxCount, count[nums[i]]);  
        }

        List<List<Integer>> ans = new ArrayList<>();

        for(int i=1; i<=n; i++) {
            for(int j=1; j<=count[i]; j++) {
                if(j > ans.size()) {
                    ans.add(new ArrayList<Integer>());
                }

                ans.get(j-1).add(i);
            }
        }


        return ans;
    }
}