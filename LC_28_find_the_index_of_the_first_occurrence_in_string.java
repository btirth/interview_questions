/*


Implement strStr().

Return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.

Clarification:
  What should we return when needle is an empty string? This is a great question to ask during an interview.
  For the purpose of this problem, we will return 0 when needle is an empty string. This is consistent to C's strstr() and Java's indexOf().

Example 1:
  Input: haystack = "hello", needle = "ll"
  Output: 2

Example 2:
  Input: haystack = "aaaaa", needle = "bba"
  Output: -1

Example 3:
  Input: haystack = "", needle = ""
  Output: 0
 
Constraints:
  0 <= haystack.length, needle.length <= 5 * 10^4
  haystack and needle consist of only lower-case English characters.


*/



// using KMP string matching algorithm
class Solution {
    public int[] compute_pi(String s) {
        int m = s.length();
        int[] pi = new int[m];
        pi[0] = -1;
        int k = -1;
        for(int i=1; i<m; i++) {
            while(k>-1 && s.charAt(i)!=s.charAt(k+1)) {
                k = pi[k];
            }
            if(s.charAt(i)==s.charAt(k+1)) {
                k++;
            }
            pi[i] = k;
        }
        return pi;
    }
    public int strStr(String s, String t) {
        int n = s.length();
        int m = t.length();
        if(m==0) {
            return 0;
        }
        if(n==0 || m>n) {
            return -1;
        }
        int[] pi = compute_pi(t);
        
        int j=-1;
        
        for(int i=0; i<n; i++) {
            while(j>-1 && s.charAt(i) != t.charAt(j+1)) {
                j = pi[j];
            }
            if(s.charAt(i)==t.charAt(j+1)) {
                j++;
            }
            if(j==m-1) {
                return i-m+1;
            }
        }
        return -1;
    }
}
