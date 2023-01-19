/*

Given an integer array nums and an integer k, return the number of non-empty subarrays that have a sum divisible by k.

A subarray is a contiguous part of an array.

Example 1:
  Input: nums = [4,5,0,-2,-3,1], k = 5
  Output: 7
  Explanation: There are 7 subarrays with a sum divisible by k = 5:
  [4, 5, 0, -2, -3, 1], [5], [5, 0], [5, 0, -2, -3], [0], [0, -2, -3], [-2, -3]

Example 2:
  Input: nums = [5], k = 9
  Output: 0

Constraints:
  1 <= nums.length <= 3 * 10^4
  -10^4 <= nums[i] <= 10^4
  2 <= k <= 10^4

*/

class Solution {
    // Modified Kadane's algo if the remainder after divinding by K of two prefix sum is equal then we can say that the subarray between them will be divisible by K.
    public int subarraysDivByK(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0, remainder; i < nums.length; i++) {
            if (i > 0) nums[i] += nums[i - 1];
            remainder = (nums[i] % k + k) % k;
            map.put(remainder, map.getOrDefault(remainder, 0) + 1);
        }
        int result = map.getOrDefault(0, 0);
        for (int frequency : map.values())
            result += frequency * (frequency - 1) / 2;
        return result;
    }
}
