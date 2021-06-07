/*

Given an array of integers nums and an integer k, return the total number of continuous subarrays whose sum equals to k.

Example 1:
  Input: nums = [1,1,1], k = 2
  Output: 2

Example 2:
  Input: nums = [1,2,3], k = 3
  Output: 2
 
Constraints:
  1 <= nums.length <= 2 * 10^4
  -1000 <= nums[i] <= 1000
  -10^7 <= k <= 10^7

*/




// Brute-force
class Solution {
    public int subarraySum(int[] nums, int k) {
        int n = nums.length;
        if(n==1) {
            return nums[0]==k ? 1 : 0;
        }
        int count = 0;
        for(int i=0; i<n; i++) {
            int sum = 0;
            for(int j=i; j<n; j++) {
                sum += nums[j];
                if(sum == k) {
                    count++;
                }
            }
        }
        return count;
    }
}



// Method 1
class Solution {
    public int subarraySum(int[] nums, int k) {
        int n = nums.length;
        if(n==1) {
            return nums[0]==k ? 1 : 0;
        }
        HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
        int count = 0;
        int sum = 0;
        
        for(int i=0; i<n; i++) {
            sum += nums[i];
            if(sum == k) {
                count++;
            }
            if(hm.containsKey(sum-k)) {
                count += hm.get(sum-k);
            }
            if(hm.containsKey(sum)) {
                hm.replace(sum, hm.get(sum)+1);
            } else {
                hm.put(sum, 1);
            }
        }
        
        return count;
    }
}



// Method 2
class Solution {
    public int subarraySum(int[] nums, int k) {
        int res = 0, sum = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        for(int e : nums) {
            sum += e;
            res += map.getOrDefault(sum - k, 0);
            map.put(sum, map.getOrDefault(sum, 0)+1);
        }
        return res;
    }
}
