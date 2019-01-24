#Given an array A of non-negative integers, return an array consisting of 
#all the even elements of A, followed by all the odd elements of A.
#You may return any answer array that satisfies this condition.

#Example 1:
#Input: [3,1,2,4]
#Output: [2,4,3,1]
#The outputs [4,2,3,1], [2,4,1,3], and [4,2,1,3] would also be accepted.



import array as arr

B = arr.array('i',[])

class Solution:
    
    def sortArrayByParity(self, A):
        
        j=0
        k=0
        n=len(A)
        if n==1:
            return A
        for i in range(n):
            if A[i]%2==0:
                B.insert(j,A[i])
                j+=1
            else:
                B.insert(n-k,A[i])
                k+=1
        return B
