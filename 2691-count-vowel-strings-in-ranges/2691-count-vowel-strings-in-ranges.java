class Solution {
    public int[] vowelStrings(String[] words, int[][] queries) {
        /**
        ["aba","bcb","ece","aa","e"]
        Prefix sum: 
        [0, 1, 1, 2, 3, 4]

        [[0,2],[1,4],[1,1]]
        [last + 1] - [first]
        
         */
        int len = words.length;
        int[] prefixSum = new int[len + 1];
        Set<Character> vowels = Set.of('a', 'e', 'i', 'o', 'u');
        
        for(int i=0; i<len; i++) {
            String word = words[i];
            boolean isGoodWord = false;
            if(vowels.contains(word.charAt(0)) && vowels.contains(word.charAt(word.length() - 1))) {
                isGoodWord = true;
            }

            prefixSum[i + 1] = prefixSum[i] + (isGoodWord == true ? 1 : 0);
        }

        int n = queries.length;
        int[] ans = new int[n];
        for(int i=0; i<n; i++) {
            ans[i] = prefixSum[queries[i][1] + 1] - prefixSum[queries[i][0]];
        }

        return ans;
    }
}