'''
Given an array containing n distinct numbers taken from 0, 1, 2, ..., n, find the one that is missing from the array.

Example 1:
    Input: [3,0,1]
    Output: 2

Example 2:
    Input: [9,6,4,2,3,5,7,0,1]
    Output: 8
'''


class Solution:
    def missingNumber(self, nums: List[int]) -> int:
        n = len(nums)
        nums.sort()
        a = 0
        for i in range(n):
            if nums[i]!=i :
                a = 1
                break
        if a==1:
            return i
        else :
            return n
            
        
