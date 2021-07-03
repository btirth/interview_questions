/*

Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.

If such an arrangement is not possible, it must rearrange it as the lowest possible order (i.e., sorted in ascending order).

The replacement must be in place and use only constant extra memory.

Example 1:
  Input: nums = [1,2,3]
  Output: [1,3,2]

Example 2:
  Input: nums = [3,2,1]
  Output: [1,2,3]

Example 3:
  Input: nums = [1,1,5]
  Output: [1,5,1]

Example 4:
  Input: nums = [1]
  Output: [1]

Constraints:
  1 <= nums.length <= 100
  0 <= nums[i] <= 100

*/


// https://www.youtube.com/watch?v=LuLCLgMElus&list=PLgUwDviBIf0rPG3Ictpu74YWBQ1CaBkm2&index=10
class Solution {
    public void nextPermutation(int[] nums) {
        int idx1 = -1;
        int idx2 = -1;
        int n = nums.length;
        if(n==1) {
            return;
        }
        for(int i=n-2; i>=0; i--) {
            if(nums[i]<nums[i+1]) {
                idx1 = i;
                break;
            }
        }
        if(idx1 != -1) {
            for(int i=n-1; i>=0; i--) {
                if(nums[i] > nums[idx1]) {
                    idx2 = i;
                    break;
                }
            }    
            swap(nums, idx1, idx2); 
        }
        reverseArray(nums, idx1+1, n-1);
    }
    
    void reverseArray(int[] nums, int start, int last) {
        while(start<last) {
            swap(nums, start, last);
            start++;
            last--;
        }
    }
    
    void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
