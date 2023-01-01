/*

Given a pattern and a string s, find if s follows the same pattern.

Here follow means a full match, such that there is a bijection between a letter in pattern and a non-empty word in s.

Example 1:
  Input: pattern = "abba", s = "dog cat cat dog"
  Output: true

Example 2:
  Input: pattern = "abba", s = "dog cat cat fish"
  Output: false

Example 3:
  Input: pattern = "aaaa", s = "dog cat cat dog"
  Output: false
 
Constraints:
  1 <= pattern.length <= 300
  pattern contains only lower-case English letters.
  1 <= s.length <= 3000
  s contains only lowercase English letters and spaces ' '.
  s does not contain any leading or trailing spaces.
  All the words in s are separated by a single space.

*/

class Solution {
    public boolean wordPattern(String pattern, String s) {
        HashMap<Character, String> map = new HashMap<>();
        HashMap<String, Character> map1 = new HashMap<>();
        int left = 0;
        int right = 0; 
        int patternIdx = 0;
        int n = s.length();
        
        while(right<=n) {
            if(patternIdx >= pattern.length()) {
                return false;
            }
            if(right == n || s.charAt(right) == ' ') {
                String str = s.substring(left, right);
                Character ch = pattern.charAt(patternIdx);
                if(map.containsKey(ch) || map1.containsKey(str)) {
                    if(!str.equals(map.get(ch)) && map1.get(str) != ch) {
                        return false;
                    } 
                } else {
                    map.put(ch, str);
                    map1.put(str, ch);
                }
                left = right+1;
                patternIdx++;
            }
            right++;
        }

        if(patternIdx != pattern.length()) {
            return false;
        }

        return true;
    }
}
