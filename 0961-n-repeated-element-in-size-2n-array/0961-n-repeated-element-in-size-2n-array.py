class Solution:
    def repeatedNTimes(self, nums: List[int]) -> int:
        for i in range(1, len(nums)):
            for j in range(0, i):
                if nums[i] == nums[j]:
                    return nums[i]
        