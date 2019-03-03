# Given an unsorted array of integers, find the length of longest continuous increasing subsequence (subarray).
# Example 1:
#	Input: [1,3,5,4,7]
#	Output: 3
#	Explanation: The longest continuous increasing subsequence is [1,3,5], its length is 3. 
#	Even though [1,3,5,7] is also an increasing subsequence, it's not a continuous one where 5 and 7 are separated by 4. 

# Example 2:
#	Input: [2,2,2,2,2]
#	Output: 1
#	Explanation: The longest continuous increasing subsequence is [2], its length is 1. 

class Solution:
    def findLengthOfLCIS(self, nums: List[int]) -> int:
        a = 0
        j = 1
        m = 0
        n = len(nums)
        if n==0:
            return 0
        if n==1:
            return 1
        for i in range(n-1):
            if nums[i]<nums[i+1] :
                j+=1
            else :
                if j>a :
                    a = j
                j=1
                m = 1
            
            if a<=j or i==n-1:
                a = j
        return a