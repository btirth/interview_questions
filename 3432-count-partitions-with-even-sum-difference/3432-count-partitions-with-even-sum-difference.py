class Solution:
    def countPartitions(self, nums: List[int]) -> int:
        totalSum = sum(nums)
        partitions = 0
        currSum = 0
        for i in range(0, len(nums) - 1):
            currSum += nums[i]
            totalSum -= nums[i]
            diff = totalSum - currSum

            if (diff % 2) == 0:
                partitions += 1

        return partitions
