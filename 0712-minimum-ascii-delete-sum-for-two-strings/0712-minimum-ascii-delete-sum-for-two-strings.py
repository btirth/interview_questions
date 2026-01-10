class Solution:
    def minimumDeleteSum(self, s1: str, s2: str) -> int:
        visited = {}
        visited[(len(s1),len(s2))] = 0

        def recursion(idx1: int, idx2: int):
            val = float('inf')
            
            if (idx1, idx2) in visited:
                return visited[(idx1, idx2)]
            
            if idx1 == len(s1):
                val = ord(s2[idx2]) + recursion(idx1, idx2 + 1)
            elif idx2 == len(s2):
                val = ord(s1[idx1]) + recursion(idx1 + 1, idx2)
            elif s1[idx1] == s2[idx2]:
                val = recursion(idx1 + 1, idx2 + 1)
            else:
                val = min(val, ord(s1[idx1]) + recursion(idx1 + 1, idx2))
                val = min(val, ord(s2[idx2]) + recursion(idx1, idx2 + 1))
            
            visited[(idx1, idx2)] = val
            return val

        return recursion(0,0)
