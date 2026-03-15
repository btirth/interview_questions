class Solution:
    def isPalindrome(self, s: str) -> bool:
        def valid_alphanum(ch) -> bool:
            ch_ord = ord(ch)
            return (ch_ord >= ord('A') and ch_ord <= ord('Z')) or (ch_ord >= ord('a') and ch_ord <= ord('z')) or (ch_ord >= ord('0') and ch_ord <= ord('9'))

        left = 0
        right = len(s) - 1
        s = s.lower()
        while left < right:
            while left <= right and not valid_alphanum(s[left]):
                left += 1
            
            while left <= right and not valid_alphanum(s[right]):
                right -= 1
            
            if left < right and s[left] != s[right]:
                return False

            left += 1
            right -= 1
        
        return True