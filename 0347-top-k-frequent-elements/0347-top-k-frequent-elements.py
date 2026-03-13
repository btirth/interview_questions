class Solution:
    def topKFrequent(self, nums: List[int], k: int) -> List[int]:
        freq = {}

        for num in nums:
            if num not in freq:
                freq[num] = 0
            
            freq[num] += 1
        
        sorted_dict = dict(sorted(freq.items(), key=lambda x: x[1], reverse=True))

        res = []
        for i in sorted_dict:
            res.append(i)
            k -= 1
            if k == 0:
                break
        
        return res