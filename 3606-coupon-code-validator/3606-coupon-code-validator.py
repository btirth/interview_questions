class Solution:
    def validateCoupons(self, code: List[str], businessLine: List[str], isActive: List[bool]) -> List[str]:
        n = len(code)
        valid_code = []
        valid_business_lines = ["electronics", "grocery", "pharmacy", "restaurant"]
        
        def isValidBusinessLine(business_line):
            return business_line in valid_business_lines
        
        def isValidCode(code):
            if code is "":
                return False

            for char in code:
                if (char == '_') or (char >= 'a' and char <= 'z') or (char >= 'A' and char <= 'Z') or (char >= '0' and char <= '9'):
                    continue
                else:
                    return False
            
            return True


        for i in range(0,n):
            if isActive[i] and isValidBusinessLine(businessLine[i]) and isValidCode(code[i]):

                valid_code.append([code[i], businessLine[i]])
        
        valid_code.sort(key=lambda x: (x[1], x[0]))
        valid_coupons = []
        for code in valid_code:
            valid_coupons.append(code[0])

        return valid_coupons