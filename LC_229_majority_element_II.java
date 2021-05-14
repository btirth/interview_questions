/*

Given an integer array of size n, find all elements that appear more than ⌊ n/3 ⌋ times.

Follow-up: Could you solve the problem in linear time and in O(1) space?

Example 1:
  Input: nums = [3,2,3]
  Output: [3]

Example 2:
  Input: nums = [1]
  Output: [1]

Example 3:
  Input: nums = [1,2]
  Output: [1,2]
 
Constraints:
  1 <= nums.length <= 5 * 10^4
  -10^9 <= nums[i] <= 10^9

*/


// Using Moore's Voting Algorithm
class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int c1 = 0;
        int c2 = 0;
        int n1 = -1;
        int n2 = -1;
        
        for(int i=0; i<nums.length; i++) {
            if(nums[i] == n1) {
                c1++;
            } else if(nums[i] == n2) {
                c2++;
            } else if(c1 == 0) {
                n1 = nums[i];
                c1++;
            } else if(c2 == 0) {
                n2 = nums[i];
                c2++;
            } else {
                c1--;
                c2--;
            }
        }
        
        int count1 = 0;
        int count2 = 0;
        for(int i=0; i<nums.length; i++) {
            if(nums[i] == n1) {
                count1++;
            } else if(nums[i] == n2) {
                count2++;
            }
        }
        
        List<Integer> ans = new ArrayList<Integer>();
        if(count1 > nums.length/3) {
            ans.add(n1);
        }
        if(count2 > nums.length/3) {
            ans.add(n2);
        }
        
        return ans;
    }
}
