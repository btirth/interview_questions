class Solution:
    def maxArea(self, h: List[int]) -> int:
        """
        For every left go in right and calculate -> O(n^2)
        10^5 TC should be O(nlogn) or O(n)

        If I take 2 pointers:
            area = cal_area(l, r)
        Now the que is should I change l or r?
            -> h[l] < h[r] then l++
            -> else r--
        """

        def get_area(l,r):
            return min(h[l], h[r]) * (r - l)

        l = 0
        r = len(h) - 1
        max_area = 0
        
        while l < r:
            area = get_area(l, r)
            max_area = max(max_area, area)

            if h[l] < h[r]:
                l += 1
            else:
                r -= 1
        
        return max_area