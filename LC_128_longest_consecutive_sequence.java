/*

Given an unsorted array of integers nums, return the length of the longest consecutive elements sequence.

You must write an algorithm that runs in O(n) time.

Example 1:
  Input: nums = [100,4,200,1,3,2]
  Output: 4
  Explanation: The longest consecutive elements sequence is [1, 2, 3, 4]. Therefore its length is 4.

Example 2:
  Input: nums = [0,3,7,2,5,8,4,6,0,1]
  Output: 9
 
Constraints:
  0 <= nums.length <= 10^5
  -10^9 <= nums[i] <= 10^9

*/



class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> hs = new HashSet<Integer>();
        int n = nums.length;
        for(int i=0; i<n; i++) {
            hs.add(nums[i]);
        }
        
        int count = 0;
        int maxCount = 0;
        for(int num : nums) {
            if(hs.contains(num-1)) {
                continue;
            } 
            int next = num;
            while(hs.contains(++next)) ;
            maxCount = Math.max(maxCount, next-num);
            
        }
        return maxCount;
    }
}
