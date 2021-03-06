/*

Given an integer array nums, find a contiguous non-empty subarray within the array that has the largest product, and return the product.

It is guaranteed that the answer will fit in a 32-bit integer.

A subarray is a contiguous subsequence of the array.

Example 1:
    Input: nums = [2,3,-2,4]
    Output: 6
    Explanation: [2,3] has the largest product 6.

Example 2:
    Input: nums = [-2,0,-1]
    Output: 0
    Explanation: The result cannot be 2, because [-2,-1] is not a subarray.
    
Constraints:
    1 <= nums.length <= 2 * 10^4
    -10 <= nums[i] <= 10

*/


class Solution {
    public int maxProduct(int[] nums) {
        int len = nums.length;
        if(len == 1) {
            return nums[0];
        }
        
        int max = nums[0];
        int min = nums[0];
        int products[] = new int[len];
        
        products[0] = max;
        
        for(int i=1; i<len; i++) {
            if(nums[i] == 0) {
                max = 1;
                min = 1;
                products[i] = 0;
                continue;
            }
            int temp = max;
            max = Math.max(nums[i], Math.max(max*nums[i], min*nums[i]));
            min = Math.min(nums[i], Math.min(temp*nums[i], min*nums[i]));
            products[i] = max;
        }
        
        int product = Integer.MIN_VALUE;
        for(int i=0; i<len; i++) {
            if(products[i] > product) {
                product = products[i];
            }
        }
        
        return product;
    }
}