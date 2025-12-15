class Solution:
    def getDescentPeriods(self, prices: List[int]) -> int:
        periods = 0
        count = 1

        for idx in range(1, len(prices)):
            if prices[idx] == (prices[idx - 1] - 1):
                count += 1
            else:
                periods += ((count * (count + 1)) // 2)
                count = 1
        
        periods += ((count * (count + 1)) // 2)
        return periods