class Solution {
    public int maxLengthBetweenEqualCharacters(String s) {
        int[] idx = new int[26];
        int ans = 0;
        Arrays.fill(idx, -1);

        for(int i=0; i<s.length(); i++) {
            char ch = s.charAt(i);
            if(idx[ch-'a'] == -1) {
                idx[ch-'a'] = i;
            } else {
                ans = Math.max(ans, i - idx[ch-'a']);
            }
        }
        return ans-1;
    }
}