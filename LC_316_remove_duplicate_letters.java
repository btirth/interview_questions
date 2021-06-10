/*

Given a string s, remove duplicate letters so that every letter appears once and only once. You must make sure your result is the smallest in lexicographical order among all possible results.

Example 1:
  Input: s = "bcabc"
  Output: "abc"

Example 2:
  Input: s = "cbacdcbc"
  Output: "acdb"
 
Constraints:
  1 <= s.length <= 10^4
  s consists of lowercase English letters.


*/



class Solution {
    public String removeDuplicateLetters(String s) {
        int n = s.length();
        if(n==1) {
            return s;
        }
        
        int[] lastIdx = new int[26];
        for(int i=0; i<n; i++) {
            lastIdx[s.charAt(i)-'a'] = i;
        }
        
        boolean[] ch = new boolean[26];
        Stack<Integer> st = new Stack<Integer>();
        for(int i=0; i<n; i++) {
            int c = s.charAt(i)-'a';
            if(ch[c]) {
                continue;
            }
            while(!st.empty() && st.peek()>c && lastIdx[st.peek()]>i) {
                ch[st.pop()] = false;
            }
            st.push(c);
            ch[c] = true;
        }
        
        StringBuilder sb = new StringBuilder();
        while(!st.empty()) {
            sb.append((char)(st.pop()+'a'));
        }
        sb.reverse();
        
        return new String(sb);
    }
}
