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
        for(int i=0; i<maxCount; i++) {
            ans.add(new ArrayList<Integer>());
        }

        for(int i=1; i<=n; i++) {
            for(int j=0; j<count[i]; j++) {
                ans.get(j).add(i);
            }
        }


        return ans;
    }
}