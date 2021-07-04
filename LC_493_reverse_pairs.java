/*

Given an integer array nums, return the number of reverse pairs in the array.

A reverse pair is a pair (i, j) where 0 <= i < j < nums.length and nums[i] > 2 * nums[j].

Example 1:
  Input: nums = [1,3,2,3,1]
  Output: 2

Example 2:
  Input: nums = [2,4,3,5,1]
  Output: 3

Constraints:
  1 <= nums.length <= 5 * 10^4
  -2^31 <= nums[i] <= 2^31 - 1

*/


class Solution {
    public int reversePairs(int[] nums) {
        return merge_sort(nums, 0, nums.length-1);
    }
    
    int merge_sort(int[] nums, int start, int end) {
        if(start>=end) {
            return 0;
        }
        int count = 0;
        int mid = (end+start)/2;
        count+=merge_sort(nums, start, mid);
        count+=merge_sort(nums, mid+1, end);
        count+=merge(nums, start, end, mid);
      
        return count;
    }
    
    int merge(int[] nums, int start, int end, int mid ) {
        int count = 0;
        int j = mid+1;
        for(int i=start; i<=mid; i++) {
            while(j<=end && nums[i]>(2*(long)nums[j])) {
                j++;
            }
            count += (j-(mid+1));
        }
        
        ArrayList<Integer> temp = new ArrayList<Integer>();
        int left = start;
        int right = mid+1;
        
        while(left<=mid && right<=end) {
            if(nums[left]<=nums[right]) {
                temp.add(nums[left++]);
            } else {
                temp.add(nums[right++]);
            }
        }
        while(left<=mid) {
            temp.add(nums[left++]);
        }
        while(right<=end) {
            temp.add(nums[right++]);
        }
        
        for(int i=start; i<=end; i++) {
            nums[i] = temp.get(i-start);
        }
        return count;
    }
}
