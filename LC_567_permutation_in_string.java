/*

Given two strings s1 and s2, return true if s2 contains a permutation of s1, or false otherwise.

In other words, return true if one of s1's permutations is the substring of s2.

Example 1:
  Input: s1 = "ab", s2 = "eidbaooo"
  Output: true
  Explanation: s2 contains one permutation of s1 ("ba").

Example 2:
  Input: s1 = "ab", s2 = "eidboaoo"
  Output: false
 
Constraints:
  1 <= s1.length, s2.length <= 10^4
  s1 and s2 consist of lowercase English letters.

*/

class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int n1 = s1.length();
        int n2 = s2.length();

        if(n1 > n2) {
            return false;
        } 

        int[] ch1 = new int[26];
        int[] ch2 = new int[26];

        for(int i=0; i<n1; i++) {
            ch1[s1.charAt(i)-'a']++;
        }

        int left = 0;
        int right = 0;

        while(right < n2) {
            int ch = s2.charAt(right) - 'a';

            ch2[ch]++;
            if(ch2[ch] == ch1[ch]) {
                if(Arrays.equals(ch1, ch2)) {
                    return true;
                }
            } else if(ch1[ch] == 0) {
                while(left <= right) {
                    ch2[s2.charAt(left) - 'a']--;
                    left++;
                }

            } else if(ch1[ch] < ch2[ch]) {
                while(left<=right) {
                    ch2[s2.charAt(left) - 'a']--;
            
                    if(s2.charAt(left)-'a' == ch) {
                        break;
                    }
                    left++;
                }
                left++;
            }

            right++;
        }

        return false;
    }
}
