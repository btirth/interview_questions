'''
Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

Example 1:
  Input: n = 3
  Output: ["((()))","(()())","(())()","()(())","()()()"]

Example 2:
  Input: n = 1
  Output: ["()"]
 
Constraints:
  1 <= n <= 8

'''


class Solution:
    def generateParenthesis(self, n: int) -> List[str]:
        def backtrack(self, openParentheses, closeParentheses, n, s, ans):
            if closeParentheses == n:
                ans.append(s)
                return

            if openParentheses != n:
                backtrack(self, openParentheses+1, closeParentheses, n, s+"(", ans)

            if closeParentheses < openParentheses:
                backtrack(self, openParentheses, closeParentheses+1, n, s+")", ans)
        ans = []
        backtrack(self, 0,0,n,"",ans)
        return ans
    
    
