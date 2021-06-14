/*

Write a function to find the longest common prefix string amongst an array of strings.

If there is no common prefix, return an empty string "".

Example 1:
  Input: strs = ["flower","flow","flight"]
  Output: "fl"

Example 2:
  Input: strs = ["dog","racecar","car"]
  Output: ""
  Explanation: There is no common prefix among the input strings.
 
Constraints:
  1 <= strs.length <= 200
  0 <= strs[i].length <= 200
  strs[i] consists of only lower-case English letters.

*/



class Solution {
    public String longestCommonPrefix(String[] strs) {
       StringBuilder sb =  new StringBuilder();
        int index = 0;
        while(index < strs[0].length()) {
            char c = strs[0].charAt(index);
            for (String s : strs) {
                if (s.length() == index) return sb.toString();
                if (s.charAt(index) != c) return sb.toString();
            }
            sb.append(c);
            index++;
        }
        return sb.toString();
    }
}
