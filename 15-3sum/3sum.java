class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        int n = nums.length;
        Arrays.sort(nums);

        for(int i=0; i<n; i++) {
            
            while(i>0 && i<n && nums[i] == nums[i-1]) {
                i++;
            }
            int j = i+1;
            int k = n-1;
            while(j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                if(sum == 0) {
                    ans.add(Arrays.asList(new Integer[]{nums[i], nums[j], nums[k]}));
                    j++;
                    while(j<k && nums[j] == nums[j-1]) {
                        j++;
                    }
                    
                    k--;
                    while(j<k && nums[k] == nums[k+1]) {
                        k--;
                    }
                    
                } else if(sum > 0) {
                    k--;
                } else {
                    j++;
                }
            }
        }

        return ans;
    }
}