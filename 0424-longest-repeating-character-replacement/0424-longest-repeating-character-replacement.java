class Solution {
    public int characterReplacement(String s, int k) {
        HashSet<Character> hashset = new HashSet<>();
        int ans = 0;
        int n = s.length();

        for(char ch: s.toCharArray()) {
            hashset.add(ch);
        }

        for(Character ch: hashset) {
            int left = 0;
            int right = 0;
            int count = 0;

            while(right < n) {
                if(s.charAt(right) == ch) {
                    count++;
                }

                while((right - left + 1) - count > k) {
                    if(s.charAt(left) == ch) {
                        count--;
                    }

                    left++;
                }

                ans = Math.max(ans, right - left + 1);
                right++;
            }
        }

        return ans;
    }
}