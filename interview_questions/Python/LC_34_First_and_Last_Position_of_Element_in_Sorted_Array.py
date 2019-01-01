#Given an array of integers nums sorted in ascending order, find the starting and ending position of a given target value.

#Your algorithm's runtime complexity must be in the order of O(log n).

#If the target is not found in the array, return [-1, -1].



from array import *
class Solution:
    def searchRange(self, nums, target):
        
        a = array('i',[]) 
        j=0
        m=0
        
        #sort the given array
        nums.sort()
        
        for i in range(len(nums)):
            #find first position in sorted array
            if nums[i]==target and j==0:
                a.append(i) 
                j+=1
            
            #find last position in sorted array
            if nums[i]==target:
                m = i
       
        if m!=0:
            a.append(m)
        
        if j==0:
            a = [-1,-1]
        elif m==0:
            a.append(a[0])
        elif len(nums)==1:
            a = [0,0]
        
        return a
        
        