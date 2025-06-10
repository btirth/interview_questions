class Solution {
    public int maxDifference(String s) {
        int[] freq = new int[26];
        for(char ch: s.toCharArray()) {
            freq[ch - 'a']++;
        }

        Arrays.sort(freq);
        int minOdd = Integer.MAX_VALUE;
        int maxOdd = 0;
        int minEven = Integer.MAX_VALUE;
        int maxEven = 0;

        for(int i: freq) {
            if(i>0) {
                if(i%2 == 0) {
                    minEven = Math.min(minEven, i);
                    maxEven = Math.max(maxEven, i);
                } else {
                    minOdd = Math.min(minOdd, i);
                    maxOdd = Math.max(maxOdd, i);
                }
            }
        }
        
        return Math.max(minOdd - maxEven, maxOdd - minEven);
        
    }
}