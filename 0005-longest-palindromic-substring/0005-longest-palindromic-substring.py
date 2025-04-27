class Solution:
    def longestPalindrome(self, s: str) -> str:
        length = len(s)
        ans = ''
        dp = [[False for _ in range(length)] for _ in range(length)]
        
        for i in range(length - 1, -1, -1):
            for j in range(i, length):
                if i == j:
                    dp[i][j] = True
                elif j == i + 1:
                    dp[i][j] = s[i] == s[j]
                elif s[i] == s[j] and dp[i+1][j-1]:
                    dp[i][j] = True

                if dp[i][j] and (j - i + 1) > len(ans):
                    ans = s[i:j+1]

        return ans                    



        