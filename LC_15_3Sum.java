/*

Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.

Notice that the solution set must not contain duplicate triplets.

Example 1:
  Input: nums = [-1,0,1,2,-1,-4]
  Output: [[-1,-1,2],[-1,0,1]]

Example 2:
  Input: nums = []
  Output: []

Example 3:
  Input: nums = [0]
  Output: []

Constraints:
  0 <= nums.length <= 3000
  -10^5 <= nums[i] <= 10^5

*/



class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        int i = 0;
        int n = nums.length;
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        while(i<n-2) {
            if(i==0 || nums[i] != nums[i-1]) {
                int low = i+1;
                int high = n-1;
                int sum = 0-nums[i];
                while(low < high) {
                    if(nums[low]+nums[high] == sum) {
                        List<Integer> list = new ArrayList<>();
                        list.add(nums[i]);
                        list.add(nums[low]);
                        list.add(nums[high]);
                        ans.add(list);
                        while(low<high && nums[low] == nums[low+1]) {
                            low++;
                        }
                        low++;
                        while(high>low && nums[high] == nums[high-1]) {
                            high--;
                        }
                        high--;
                    } else if(nums[low]+nums[high] < sum) {
                        low++;
                    } else if(nums[low]+nums[high] > sum) {
                        high--;
                    }
                }
            }
            
            i++;
            
        }
        return ans;
    }
}
