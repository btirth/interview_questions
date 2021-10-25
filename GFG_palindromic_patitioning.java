/*

Given a string str, a partitioning of the string is a palindrome partitioning if every sub-string of the partition is a palindrome. Determine the fewest cuts needed for palindrome partitioning of given string.

Example 1:
  Input: str = "ababbbabbababa"
  Output: 3
  Explaination: After 3 partitioning substrings are "a", "babbbab", "b", "ababa".

Example 2:
  Input: str = "aaabba"
  Output: 1
  Explaination: The substrings after 1 partitioning are "aa" and "abba".

Your Task:
You do not need to read input or print anything, Your task is to complete the function palindromicPartition() which takes the string str as input parameter and returns minimum number of partitions required.

Expected Time Complexity: O(n*n) [n is the length of the string str]
Expected Auxiliary Space: O(n*n)

Constraints:
1 ≤ length of str ≤ 500

*/


class Solution{
    static int palindromicPartition(String str)
    {
        // code here
        int n = str.length();
        boolean[][] isPalindrome = new boolean[n][n];
        
        for(int i=n-1; i>=0; i--) {
            for(int j=i; j<n; j++) {
                if(i == j) {
                    isPalindrome[i][j] = true;
                } else if(j == i+1) {
                    if(str.charAt(i) == str.charAt(j)) {
                        isPalindrome[i][j] = true;
                    }
                } else {
                    if(str.charAt(i) == str.charAt(j) && isPalindrome[i+1][j-1]) {
                        isPalindrome[i][j] = true;
                    }
                }
            }
        }
        
        int[] minCut = new int[n];
        for(int i=1; i<n; i++) {
            if(isPalindrome[0][i]) {
                minCut[i] = 0;
            } else {
                int min = Integer.MAX_VALUE;
                for(int j=i; j>=1; j--) {
                    if(isPalindrome[j][i] && min > minCut[j-1]) {
                        min = minCut[j-1];
                    }
                }
                minCut[i] = min + 1;
            }
        }
        
        
        return minCut[n-1];
    }
}
