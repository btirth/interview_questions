class Solution:
    def groupAnagrams(self, strs: List[str]) -> List[List[str]]:
        map = {}

        for s in strs:
            sorted_s = str(sorted(s))
            if sorted_s not in map:
                map[sorted_s] = []
            map[sorted_s].append(s)
        
        res = []
        for key in map:
            res.append(map[key])
        
        return res

