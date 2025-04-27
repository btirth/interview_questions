class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        available = set({})

        left = 0
        maxLen = 0

        for right in range(0, len(s)):
            if s[right] in available:
                while left < right and s[left] != s[right]:
                    available.remove(s[left])
                    left += 1

                available.remove(s[left])
                left += 1
            maxLen = max(maxLen, right - left + 1)
            available.add(s[right])
            right += 1

        return maxLen        

