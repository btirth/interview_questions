class Solution:
    def countSubarrays(self, nums: List[int]) -> int:
        count = 0

        for end in range(2, len(nums)):
            sum = nums[end - 2] + nums[end]

            if (sum * 2) == nums[end - 1]:
                count += 1
            
        return count