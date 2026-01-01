class Solution:
    def plusOne(self, digits: List[int]) -> List[int]:
        carry = 1

        for idx in range(len(digits)-1, -1, -1):
            new_digit = carry + digits[idx]
            if new_digit == 10:
                carry = 1
                digits[idx] = 0
            else:
                digits[idx] = new_digit
                return digits
        
        if carry == 1:
            digits.insert(0,1)
        
        return digits