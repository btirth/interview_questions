/*

Given a string S, check if it is palindrome or not.

Example 1:
  Input: S = "abba"
  Output: 1
  Explanation: S is a palindrome

Example 2:
  Input: S = "abc" 
  Output: 0
  Explanation: S is not a palindrome
 
Your Task:  
You don't need to read input or print anything. Complete the function isPlaindrome() which accepts string S and returns a boolean value

Expected Time Complexity: O(Length of S) 
Expected Auxiliary Space: O(1) 

Constraints:
1 <= Length of S <= 10^5

*/


class Solution {
    int isPalindrome(String S) {
        // code here
        int start = 0;
        int end = S.length()-1;
        
        while(start <= end) {
            if(S.charAt(start) != S.charAt(end)) {
                return 0;
            }
            start++;
            end--;
        }
        
        return 1;
    }
}
