/*

Given a string s, find the length of the longest substring without repeating characters.

 

Example 1:

Input: s = "abcabcbb"
Output: 3
Explanation: The answer is "abc", with the length of 3.
Example 2:

Input: s = "bbbbb"
Output: 1
Explanation: The answer is "b", with the length of 1.
Example 3:

Input: s = "pwwkew"
Output: 3
Explanation: The answer is "wke", with the length of 3.
Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.
Example 4:

Input: s = ""
Output: 0
 

Constraints:

0 <= s.length <= 5 * 10^4
s consists of English letters, digits, symbols and spaces.

*/


class Solution {
    public int lengthOfLongestSubstring(String s) {
        int sLength = s.length();
        if(sLength < 2) {
            return sLength;
        }
        
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        int ans = 0;
        int left = 0;
        
        for(int right = 0; right<sLength; right++) {
            if(map.containsKey(s.charAt(right))) {
                left = Math.max(map.get(s.charAt(right))+1, left);
            }
            map.put(s.charAt(right), right);
            ans = Math.max(right-left+1, ans);
        }
        
        return ans;
    }
}



// O(2n) time and O(n) space
class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s.length()==0) {
            return 0;
        }
        Set<Character> set = new HashSet<Character>();
        int maxL = 1;
        int l = 0;
        int r = 0;
        while(r < s.length()) {
            if(set.contains(s.charAt(r))) {
                while(s.charAt(l) != s.charAt(r) && l<r) {
                    set.remove(s.charAt(l));
                    l++;
                }    
                l++;
            }
            set.add(s.charAt(r));
            maxL = Math.max(r-l+1, maxL);
            r++;
        }
        
        return maxL;
    }
}
