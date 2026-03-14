class Solution:
    def longestConsecutive(self, nums: List[int]) -> int:
        lcs = 0
        nums = set(nums)
        for num in nums:
            if num - 1 in nums:
                continue
            else:
                length = 1
                while num + length in nums:
                    length += 1
                
                lcs = max(lcs, length)
        
        return lcs
