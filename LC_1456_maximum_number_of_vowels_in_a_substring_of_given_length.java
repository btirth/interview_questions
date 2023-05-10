/*

Given a string s and an integer k, return the maximum number of vowel letters in any substring of s with length k.

Vowel letters in English are 'a', 'e', 'i', 'o', and 'u'.

Example 1:
  Input: s = "abciiidef", k = 3
  Output: 3
  Explanation: The substring "iii" contains 3 vowel letters.

Example 2:
  Input: s = "aeiou", k = 2
  Output: 2
  Explanation: Any substring of length 2 contains 2 vowels.

Example 3:
  Input: s = "leetcode", k = 3
  Output: 2
  Explanation: "lee", "eet" and "ode" contain 2 vowels.
 
Constraints:
  1 <= s.length <= 10^5
  s consists of lowercase English letters.
  1 <= k <= s.length

*/

// Approach: 1
class Solution {
    public int maxVowels(String s, int k) {
        
        List<Character> vowels=Arrays.asList(new Character[]{'a','e','i','o','u'});
        int i = 0;
        int j = 0;
        
        int count = 0;
        int ans = count;
        
        while(i<s.length()) {
            if(vowels.contains(s.charAt(i))) {
                count++;
            }
            
            if(i-j >= k) {
                if(vowels.contains(s.charAt(j))) {
                    count--;
                }
                
                j++;
            }
            
            ans = Math.max(ans, count);
            i++;
        }
        
        return ans;
    }
}

// Approach: 2
class Solution {
    public int maxVowels(String s, int k) {
        int n = s.length();
        List<Character> vowels=Arrays.asList(new Character[]{'a','e','i','o','u'});
        int[] dp = new int[n+1];
        int count = 0;
        int ans = 0;
        
        for(int i=0; i<n; i++) {
            if(vowels.contains(s.charAt(i))) {
                count++;
            }

            dp[i] = count;
            ans = Math.max(ans, i>=k ? count-dp[i-k] : count);
        }
        return ans;
    }
}
