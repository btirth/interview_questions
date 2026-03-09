class Solution:
    def isAnagram(self, s: str, t: str) -> bool:
        freq = 26 * [0]

        for char in s:
            freq[ord(char) - ord('a')] += 1
        
        for char in t:
            freq[ord(char) - ord('a')] -= 1
        
        for fr in freq:
            if fr != 0:
                return False
        
        return True