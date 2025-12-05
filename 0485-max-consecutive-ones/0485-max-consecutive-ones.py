class Solution:
    def findMaxConsecutiveOnes(self, nums: List[int]) -> int:
        count = 0
        maxConsecutiveOnes = 0

        for i in range(0, len(nums)):
            if nums[i] == 1:
                count = count + 1
            else:
                maxConsecutiveOnes = max(maxConsecutiveOnes, count)
                count = 0

        return max(maxConsecutiveOnes, count)