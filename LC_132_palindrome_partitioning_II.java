/*

Given a string s, partition s such that every substring of the partition is a palindrome.

Return the minimum cuts needed for a palindrome partitioning of s.

Example 1:
  Input: s = "aab"
  Output: 1
  Explanation: The palindrome partitioning ["aa","b"] could be produced using 1 cut.

Example 2:
  Input: s = "a"
  Output: 0

Example 3:
  Input: s = "ab"
  Output: 1
 
Constraints:
  1 <= s.length <= 2000
  s consists of lower-case English letters only.

*/



class Solution {
    public int minCut(String s) {
        int n = s.length();
        boolean[][] isPalindrome = new boolean[n][n];
        
        for(int i=n-1; i>=0; i--) {
            for(int j=i; j<n; j++) {
                if(i == j) {
                    isPalindrome[i][j] = true;
                }else if(i+1 == j) {
                    if(s.charAt(i) == s.charAt(j)) {
                        isPalindrome[i][j] = true;
                    }
                } else {
                    if(s.charAt(i) == s.charAt(j) && isPalindrome[i+1][j-1]) {
                        isPalindrome[i][j] = true;
                    }
                }
            }
        }
        
        int[] minCut = new int[n];
        minCut[0] = 0;
        for(int i=1; i<n; i++) {
            if(isPalindrome[0][i]) {
                minCut[i] = 0;
                continue;
            }
            int min = Integer.MAX_VALUE;
            for(int j=i; j>=1; j--) {
                if(isPalindrome[j][i]) {
                    if(min > minCut[j-1]) {
                        min = minCut[j-1];
                    }
                }
            }
            minCut[i] = min+1;
        }
        
        return minCut[n-1];
    }
}
