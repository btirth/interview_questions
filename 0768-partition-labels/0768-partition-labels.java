class Solution {
    public List<Integer> partitionLabels(String s) {
        int[] lastIdx = new int[26];
        int len = s.length();
        List<Integer> ans = new ArrayList<>();

        for(int i=0; i<len; i++) {
            lastIdx[s.charAt(i) - 'a'] = i;
        }

        int prev = 0;
        int idx = 0;
        while(idx != s.length()) {
            int lastIdxOfCharAtIdx = lastIdx[s.charAt(idx) - 'a'];
            int nextIdx = lastIdxOfCharAtIdx;
            for(int i=idx+1; i<=nextIdx; i++) {
                nextIdx = Math.max(nextIdx, lastIdx[s.charAt(i) - 'a']);
            }    

            ans.add(nextIdx - prev + 1);
            prev = nextIdx + 1;
            idx = nextIdx + 1;
        }

        return ans;
    }
}