/*

Given a string containing just the characters '(' and ')', find the length of the longest valid (well-formed) parentheses substring.

Example 1:
  Input: s = "(()"
  Output: 2
  Explanation: The longest valid parentheses substring is "()".

Example 2:
  Input: s = ")()())"
  Output: 4
  Explanation: The longest valid parentheses substring is "()()".

Example 3:
  Input: s = ""
  Output: 0
 
Constraints:
  0 <= s.length <= 3 * 10^4
  s[i] is '(', or ')'.

*/


public class Solution {
    public int longestValidParentheses(String s) {
        int left = 0, right = 0, maxlength = 0;
        
        for (int i = 0; i < s.length(); i++) 
        {
            if (s.charAt(i) == '(') left++;
            else right++;
            
            if (left == right) {
                maxlength = Math.max(maxlength, 2 * right);
            } else if (right >= left) {
                left = right = 0;
            }
        }
        
        left = right = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            
            if (s.charAt(i) == '(') left++;
            else right++;
            
            if (left == right) {
                maxlength = Math.max(maxlength, 2 * left);
            } else if (left >= right) {
                left = right = 0;
            }
        }
        return maxlength;
    }
}




class Solution {
    public int longestValidParentheses(String s) {
        int length = s.length();
        if(length <=  1) {
            return 0;
        }
        int[] dp = new int[length + 1];
        int max = 0;
        dp[1] = 0;
        dp[2] = s.charAt(1) == ')' && s.charAt(0) == '(' ? 2 : 0;
        max = Integer.max(dp[1], max);
        for (int i = 2; i <= length; i++) {
            if (s.charAt(i - 1) == ')') {
                if (s.charAt(i - 2) == '(') {
                    dp[i] = dp[i-2] + 2;
                } else if (i - 2 - dp[i-1] >= 0 && s.charAt(i - 2 - dp[i-1]) == '(') {
                    dp[i] = dp[i - 1] + 2 + dp[i - 2 - dp[i-1]];
                }
            }
            max = Integer.max(dp[i], max);
        }
        return max;
    }
}
