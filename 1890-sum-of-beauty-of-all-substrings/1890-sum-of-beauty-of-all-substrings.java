class Solution {
    public int beautySum(String s) {
        int sum = 0;
        int n = s.length();

        for(int i=0; i<n; i++) {
            int[] freq = new int[26];

            for(int j=i; j<n; j++) {
                freq[s.charAt(j) - 'a']++;
                int minF = Integer.MAX_VALUE;
                int maxF = 0;

                for(int k=0; k<26; k++) {
                    if(freq[k] > 0) {
                        minF = Math.min(minF, freq[k]);
                    }

                    maxF = Math.max(maxF, freq[k]);
                }

                sum += (maxF - minF);
            }
        }

        return sum;
    }
}