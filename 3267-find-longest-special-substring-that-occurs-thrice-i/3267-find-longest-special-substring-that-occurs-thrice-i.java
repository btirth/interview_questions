class Solution {
    public int maximumLength(String s) {
        HashMap<String, Integer> freq = new HashMap<>();
        int maxLen = 0;

        int l = 0;
        int r = 0;

        while(r < s.length()) {
            if(s.charAt(l) != s.charAt(r)) {
                l++;
                while(l < r) {
                    String substr = s.substring(l, r);
                    freq.put(substr, freq.getOrDefault(substr, 0) + 1);

                    if(freq.get(substr) >= 3) {
                        maxLen = Math.max(maxLen, substr.length());
                    }
                    l++;
                }
            } 
            
            String substr = s.substring(l, r+1);
            freq.put(substr, freq.getOrDefault(substr, 0) + 1);

            if(freq.get(substr) >= 3) {
                maxLen = Math.max(maxLen, substr.length());
            }

            if(r-l >= 2)
                maxLen = Math.max(maxLen, r-l+1-2);
            r++;
        }

        return maxLen == 0 ? -1 : maxLen;
    }
}

/**
aaaa -> 4 2
aa aa aa

aaaaa -> 5 3
aaa aaa aaa

aaaaaa -> 6 4
aaaa aaaa aaaa
 */