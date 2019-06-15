'''
Given a non-empty array of integers, every element appears twice except for one. Find that single one.

Note:
Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?

Example 1:
Input: [2,2,1]
Output: 1

Example 2:
Input: [4,1,2,1,2]
Output: 4
'''


class Solution:
    def singleNumber(self, nums):
        nums = sorted(nums)
        for i in range(0,len(nums)-1):
            if nums[i]==nums[i+1] or nums[i]==nums[i-1]:
                continue
            else:
                return nums[i]
        return nums[len(nums)-1]        '''because last digit of sorted array doesn't come in the loop...
                                        for example given array is [4,1,2,1,2]'''
