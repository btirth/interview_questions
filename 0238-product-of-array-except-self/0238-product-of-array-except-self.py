class Solution:
    def productExceptSelf(self, nums: List[int]) -> List[int]:
        contains_zero = False
        product = 1

        ans = []

        for num in nums:
            if num == 0:
                if contains_zero == True:
                    return len(nums) * [0]
                contains_zero = True
            else:
                product *= num
        
        for num in nums:
            if num == 0:
                ans.append(product)
            elif contains_zero:
                ans.append(0)
            else:
                ans.append(int(product / num))
        
        return ans
            