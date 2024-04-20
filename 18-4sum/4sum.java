class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        int n = nums.length;
        Arrays.sort(nums);
        int i = 0;
        while(i < n-3) {

            int j = i+1;
            while(j < n-2) {
                int k = j+1;
                int m = n-1;
                while(k < m) {
                    long sum = (long)nums[i] + (long)nums[j] + (long)nums[k] + (long)nums[m] - (long)target;
                    if(sum == 0) {
                        ans.add(Arrays.asList(new Integer[]{nums[i], nums[j], nums[k], nums[m]}));
                        k++;
                        while(k<m && nums[k] == nums[k-1]) {
                            k++;
                        }
                        m--;
                        while(k<m && nums[m] == nums[m+1]) {
                            m--;
                        }
                    } else if(sum > 0) {
                        m--;
                        while(k<m && nums[m] == nums[m+1]) {
                            m--;
                        }
                    } else {
                        k++;
                        while(k<m && nums[k] == nums[k-1]) {
                            k++;
                        }
                    }
                }
                
                j++;
                while(j<n && nums[j] == nums[j-1]) {
                    j++;
                }
            } 

            i++;       
            while(i>0 && i<n-3 && nums[i] == nums[i-1]) {
                i++;
            }                    
        }

        return ans;
    }
}