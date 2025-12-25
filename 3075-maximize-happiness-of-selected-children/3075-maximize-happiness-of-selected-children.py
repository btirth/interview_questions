class Solution:
    def maximumHappinessSum(self, happiness: List[int], k: int) -> int:
        happiness.sort(reverse = True)
        maxHappiness = 0
        i = 0

        for i in range(0, k):
            maxHappiness += max(happiness[i] - i, 0)

        return maxHappiness