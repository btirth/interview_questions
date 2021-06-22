/*

Given a string s, return the longest palindromic substring in s.

Example 1:
  Input: s = "babad"
  Output: "bab"
  Note: "aba" is also a valid answer.

Example 2:
  Input: s = "cbbd"
  Output: "bb"

Example 3:
  Input: s = "a"
  Output: "a"

Example 4:
  Input: s = "ac"
  Output: "a"

Constraints:
  1 <= s.length <= 1000
  s consist of only digits and English letters (lower-case and/or upper-case),

*/


// Using DP
class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();
        
        boolean [][] dp = new boolean[n][n];
        String res = s.substring(0,1);
        
        for(int i=n-1; i>=0; i--) {
            for(int j=i; j<n; j++) {
                dp[i][j] = s.charAt(i)==s.charAt(j) && (j-i<3 || dp[i+1][j-1]);
                if(dp[i][j] && j-i+1>res.length()) {
                    res = s.substring(i,j+1);
                }
            }
        }
        
        return res;
    }
}



class Solution {
    public String longestPalindrome(String s) {
        
        if(s == null || s.length() < 1){
            return "";
        }
        int start = 0, end = 0, totalLength = s.length();
        for(int index = 0; index < totalLength; index++){
            int oddLen = expand(s, index, index, totalLength);
            int evenLen = expand(s, index, index+1, totalLength);
            int max = Math.max(oddLen, evenLen);
            if(max > end - start){
                start = index - (max-1)/2;
                end = index + max/2;
            }
        }
        return s.substring(start, end + 1);
    }
    
    
    public int expand(String str, int leftEnd, int rightEnd, int totalLength){
        while(leftEnd >= 0 && rightEnd < totalLength && str.charAt(leftEnd)== str.charAt(rightEnd)){
            leftEnd--;
            rightEnd++;
        }
        return rightEnd - leftEnd -1;
    }
}
