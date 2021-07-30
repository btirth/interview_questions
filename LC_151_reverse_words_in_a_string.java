/*

Given an input string s, reverse the order of the words.

A word is defined as a sequence of non-space characters. The words in s will be separated by at least one space.

Return a string of the words in reverse order concatenated by a single space.

Note that s may contain leading or trailing spaces or multiple spaces between two words. The returned string should only have a single space separating the words. Do not include any extra spaces.

Example 1:
  Input: s = "the sky is blue"
  Output: "blue is sky the"

Example 2:
  Input: s = "  hello world  "
  Output: "world hello"
  Explanation: Your reversed string should not contain leading or trailing spaces.

Example 3:
  Input: s = "a good   example"
  Output: "example good a"
  Explanation: You need to reduce multiple spaces between two words to a single space in the reversed string.

Example 4:
  Input: s = "  Bob    Loves  Alice   "
  Output: "Alice Loves Bob"

Example 5:
  Input: s = "Alice does not even like bob"
  Output: "bob like even not does Alice"
 
Constraints:
  1 <= s.length <= 10^4
  s contains English letters (upper-case and lower-case), digits, and spaces ' '.
  There is at least one word in s.

*/



class Solution {
    public String reverseWords(String s) {
        int start = 0;
        int n = s.length();
        while(start<n && s.charAt(start) == ' ') {
            start++;
        }
        int end = n-1;
        while(end >= 0 && s.charAt(end) == ' ') {
            end--;
        }
        
        int wordStart = start;
        char[] ch = s.toCharArray();
        for(int i=start; i<=end; i++) {
            if(ch[i] == ' ') {
                reverse(ch, wordStart, i-1);
                wordStart = i+1;
            }
        }
        reverse(ch, wordStart, end);
        reverse(ch, start, end);
        StringBuilder sb = new StringBuilder("");
        for(int i=start; i<=end; i++) {
            if(ch[i] == ' ' && (i!=start && ch[i-1] == ' ')) {
                continue;
            } 
            sb.append(ch[i]);
        }
        return new String(sb);
    }
    
    public void reverse(char[] ch, int start, int end) {
        while(start <= end) {
            char temp = ch[start];
            ch[start] = ch[end];
            ch[end] = temp;
            start++;
            end--;
        }
    }
}
