class Solution:
    def countTriples(self, n: int) -> int:
        count = 0
        squares = []

        for b in range(1, n):
            for c in range(b + 1, n + 1):
                a = (c*c) - (b*b)
                if a in squares:
                    count += 2
                
            squares.append(b * b)
       
        return count