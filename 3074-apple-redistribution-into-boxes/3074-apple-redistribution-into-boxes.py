class Solution:
    def minimumBoxes(self, apple: List[int], capacity: List[int]) -> int:
        total_apples = 0
        for app in apple:
            total_apples += app
        
        capacity.sort(reverse=True)
        total_capacity = 0

        for i in range(0, len(capacity)):
            total_capacity += capacity[i]

            if total_capacity >= total_apples:
                return i + 1

        return -1