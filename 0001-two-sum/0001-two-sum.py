class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        dict = {}
        for i in range(0, len(nums)):
            required = target - nums[i]

            if required in dict:
                return [dict[required], i]

            dict[nums[i]] = i