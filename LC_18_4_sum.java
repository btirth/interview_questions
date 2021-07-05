/*

Given an array nums of n integers, return an array of all the unique quadruplets [nums[a], nums[b], nums[c], nums[d]] such that:
  0 <= a, b, c, d < n
  a, b, c, and d are distinct.
  nums[a] + nums[b] + nums[c] + nums[d] == target
  You may return the answer in any order.

Example 1:
  Input: nums = [1,0,-1,0,-2,2], target = 0
  Output: [[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]

Example 2:
  Input: nums = [2,2,2,2,2], target = 8
  Output: [[2,2,2,2]]

Constraints:
  1 <= nums.length <= 200
  -10^9 <= nums[i] <= 10^9
  -10^9 <= target <= 10^9

*/



class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> ans = new ArrayList<>(); 
        int n = nums.length;
        if(n<4) {
            return ans;
        }
        Arrays.sort(nums);
        for(int i=0; i<n-3; i++) {
            for(int j=i+1; j<n-2; j++) {
                int val = target - nums[i] - nums[j];
                int left = j+1;
                int right = n-1;
                while(left < right) {
                    if(nums[left]+nums[right] == val) {
                        List<Integer> list = new ArrayList<>();
                        list.add(nums[i]);
                        list.add(nums[j]);
                        list.add(nums[left]);
                        list.add(nums[right]);
                        ans.add(list);
                        while(left<right && nums[left] == nums[left+1]) {
                            left++;
                        }
                        left++;
                        while(right>left && nums[right] == nums[right-1]) {
                            right--;
                        }
                        right--;
                    } else if(nums[left]+nums[right] < val) {
                        while(left<right && nums[left] == nums[left+1]) {
                            left++;
                        }
                        left++;
                    } else if(nums[left]+nums[right] > val) {
                        while(left<right && nums[right] == nums[right-1]) {
                            right--;
                        }
                        right--;
                    }
                }
                
                while(j<n-2 && nums[j] == nums[j+1]) {
                    j++;
                }
            }
            while(i<n-3 && nums[i] == nums[i+1]) {
                i++;
            }
        }
        return ans;
    }
}
