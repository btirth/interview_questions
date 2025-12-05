class Solution:
    def shuffle(self, nums: List[int], n: int) -> List[int]:
        res = [0] * (2 * n)
        idx = 0

        for i in range(0, n):
            res[idx] = nums[i]
            res[idx + 1] = nums[n + i]
            idx = idx + 2

        return res 