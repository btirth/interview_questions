class Solution:
    def findNumbers(self, nums: List[int]) -> int:
        def countDigit(num) -> int:
            digits = 0
            while num > 0:
                num = (int)(num / 10)
                digits += 1

            return digits

        count = 0
        for num in nums:
            if countDigit(num) % 2 == 0:
                count += 1

        return count                