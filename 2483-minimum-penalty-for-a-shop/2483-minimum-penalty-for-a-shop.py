class Solution:
    def bestClosingTime(self, customers: str) -> int:
        n = len(customers)
        penalties = [0] * (n + 1)
        penalty = 0
        

        for i in range(0, n):
            

            if customers[i] == 'N':
                penalty += 1

            penalties[i + 1] = penalty
        
        penalty = 0
        min_penalty = penalties[n]
        min_penalty_hour = n



        for i in range(n-1, -1, -1):
            if customers[i] == 'Y':
                penalty += 1

            penalties[i] += penalty
            
            if penalties[i] <= min_penalty:
                min_penalty_hour = i
                min_penalty = penalties[i]
        
        return min_penalty_hour

        
