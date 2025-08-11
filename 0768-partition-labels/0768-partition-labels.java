class Solution {
    public List<Integer> partitionLabels(String s) {
        /**
        Our goal is to keep character in a single partitioned string
        
        So if we know the first and last occurance of the character
        We can say that those indexes will be included in a single string

        ababcc
        a -> 0, 2
        b -> 1, 3
        c -> 4, 5

        first create 2 arrays firstIdx, and lastIdx
        firstIdx = int[26];
        lastIdx = int[26];
        idx = 0

        for char in s:
            if firstIdx[char] not set:
                firstIdx[char] = idx
            
            lastIdx[char] = idx
            idx++
        
        left = 0 -> starting index of partitioned string 
        right = -1 -> Ending index of partitioned string
        idx = 0 -> Current character we're processing

        while idx < len(s):
            lastIdx[s[idx]] > right:
                right = lastIdx[s[idx]]

            if idx == right:
                and(s[left, right])
                left = right + 1
                right++
            

        ababcc
        firstIdx = [0,1,4]
        lastIdx = [2,3,5]

        idx = 0 -> lastIdx(a) > -1 -> right = 2
        idx = 1 -> lastIdx(b) > 2 -> right = 3
        idx = 2 -> lastIdx(a) > 3 -> NO 
        idx = 3 -> lastIdx(b) > 3 -> NO
        
        idx == right (3) -> partitioned string(left, right)
            left = 4
            right = 4
            idx = 4
        
        TC -> O(n) -> n = length of input string
        SC -> O(1) -> Size of length will remain same 
         */ 

        List<Integer> res = new ArrayList<>();
        int[] firstIdx = new int[26];
        int[] lastIdx = new int[26];
        int len = s.length();
        Arrays.fill(firstIdx, -1);

        for(int i=0; i<len; i++) {
            int idx = s.charAt(i) - 'a';

            if(firstIdx[idx] == -1) 
                firstIdx[idx] = i;

            lastIdx[idx] = i;    
        }
        
        int idx = 0;
        int left = 0;
        int right = 0;

        while(idx < len) {
            int charIdx = s.charAt(idx) - 'a';

            if(lastIdx[charIdx] > right) {
                right = lastIdx[charIdx];
            }

            if(right == idx) {
                res.add(right - left + 1);
                right++;
                left = right;
            }

            idx++;
        }

        return res;
    }
}