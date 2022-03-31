/*

Given an integer array nums and an integer k, return true if it is possible to divide this array into k non-empty subsets whose sums are all equal.

Example 1:
Input: nums = [4,3,2,3,5,2,1], k = 4
Output: true
Explanation: It is possible to divide it into 4 subsets (5), (1, 4), (2,3), (2,3) with equal sums.

Example 2:
Input: nums = [1,2,3,4], k = 3
Output: false
 
Constraints:
1 <= k <= nums.length <= 16
1 <= nums[i] <= 10^4
The frequency of each element is in the range [1, 4].

*/


class Solution {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        if(k == 1) {
            return true;
        }
        
        int sum = 0;
        for(int num: nums) {
            sum += num;
        }
        
        if(sum%k != 0 || nums.length<k) {
            return false;
        }
        
        Arrays.sort(nums);
        return helper(nums, k, sum/k, new int[k], nums.length-1);
    }
    
    boolean helper(int[] nums, int k, int target, int[] partitions, int idx) {
        if(idx < 0) {
            return true;
        }
        
        for(int i=0; i<partitions.length; i++) {
            if(partitions[i] + nums[idx] <= target) {
                partitions[i] += nums[idx];
                if(helper(nums, k, target, partitions, idx-1)) {
                    return true;
                }
                
                partitions[i] -= nums[idx];
            }
            
            if(partitions[i] == 0) {
                break;
            }
        }
        
        return false;
    }
}
