class Solution:
    def threeSum(self, nums: list[int]) -> list[list[int]]:
        result = []
        i = 0
        n = len(nums)
        nums = sorted(nums)

        while i < n - 2:
            j = i + 1
            k = n - 1

            while j < k:
                sum = nums[i] + nums[j] + nums[k]

                if sum == 0:
                    result.append([nums[i], nums[j], nums[k]])
                    j += 1
                    while j<k and nums[j] == nums[j-1]:
                        j += 1
                    k -= 1 
                    while j<k and nums[k] == nums[k+1]:
                        k -= 1
                elif sum < 0:
                    j += 1

                    while j<k and nums[j] == nums[j-1]:
                        j += 1
                else:
                    k -= 1 

                    while j<k and nums[k] == nums[k+1]:
                        k -= 1

            i += 1
            while i<n-2 and nums[i] == nums[i-1]:
                i += 1
        return result