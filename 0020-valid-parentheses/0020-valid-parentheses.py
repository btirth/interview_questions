class Solution:
    def isValid(self, s: str) -> bool:
        stack = []
        for ch in s:
            if ch in ['(', '{', '[']:
                stack.append(ch)
            else:
                if ch == ')':
                    if len(stack) == 0 or stack[-1] != '(':
                        return False
                    stack.pop()
                if ch == '}':
                    if len(stack) == 0 or stack[-1] != '{':
                        return False
                    stack.pop()
                if ch == ']':
                    if len(stack) == 0 or stack[-1] != '[':
                        return False
                    stack.pop()
        return len(stack) == 0