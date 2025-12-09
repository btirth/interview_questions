class Solution:
    def specialTriplets(self, nums: List[int]) -> int:
        pair1 = dict({})
        pair2 = dict({})
        count = 0
        MOD = 1000000007

        for num in nums:
            if num in pair2:
                count = (count + pair2[num])%MOD
            
            numi = 2 * num

            if numi in pair1:
                if numi not in pair2:
                    pair2[numi] = 0
                
                pair2[numi] = (pair2[numi] + pair1[numi])%MOD

            if num not in pair1:
                pair1[num] = 0
            
            pair1[num] = (pair1[num] + 1)%MOD
        
        return count