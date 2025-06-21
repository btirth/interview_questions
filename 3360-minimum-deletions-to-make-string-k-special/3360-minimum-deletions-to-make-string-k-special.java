class Solution {
    public int minimumDeletions(String word, int k) {
        /**
        first of all we need freq of each char -> freq arr/map

        Our task is to freq[i] - freq[j] <= k , so let's say we have min number -> fMin
        
        for fr in freq:
            fr - fMin <= k -> True


        either fMin will work or median.    
        by looking at the 1st example we can say that we need median
        no. of character is 26, so even if for all character we can try to take it's freq as median.

        Our task is to bring max - min <= k, we can remove max or min. if max - min > 
        dabdcbdcdcd, k == 2
        a -> 1
        b -> 2
        c -> 3
        d -> 5


        for a = 1
            cnt = 4
         */

        int ans = word.length();
        int[] freq = new int[26];

        for(char ch: word.toCharArray()) {
            freq[ch - 'a']++;
        }
        
        Arrays.sort(freq);
        int prefix = 0;

        for(int i=0; i<26; i++) {
            if(freq[i] == 0) {
                continue;
            }

            int cnt = 0;
            int j = 25;

            while(freq[j] - freq[i] > k) {
                cnt += freq[j] - freq[i] - k;
                j--;
            }

            ans = Math.min(ans, cnt + prefix);
            prefix += freq[i];
        }

        return ans;
    }
}