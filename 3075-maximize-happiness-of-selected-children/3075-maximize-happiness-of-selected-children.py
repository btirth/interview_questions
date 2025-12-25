class Solution:
    def maximumHappinessSum(self, happiness: List[int], k: int) -> int:
        happiness.sort(reverse = True)
        maxHappiness = 0

        for i in range(0, k):
            if i > happiness[i]:
                break

            maxHappiness += (happiness[i] - i)

        return maxHappiness