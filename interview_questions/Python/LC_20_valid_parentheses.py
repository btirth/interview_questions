# Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

# An input string is valid if:
# Open brackets must be closed by the same type of brackets.
# Open brackets must be closed in the correct order.
# Note that an empty string is also considered valid.

# Example 1:
# Input: "()"
# Output: true

# Example 2:
# Input: "()[]{}"
# Output: true

# Example 3:
# Input: "(]"
# Output: false



import array
class Solution:
    def isValid(self, s):
        a = len(s)
        if a%2!=0:
            return False
        cur = s
        k=0
        str = array.array('c', [])
        for i in range(a):
            if cur[i]=='[' or cur[i]=='{' or cur[i]=='(':
                str.append(cur[i])
                k=k+1
                return False
            else:
                if k==0:
                    return False
                else:
                    if cur[i]==')'and str[k-1]=='(' or cur[i]==']'and str[k-1]=='[' or cur[i]=='}' and str[k-1]=='{' :
                        return True
                    else:
                        return False