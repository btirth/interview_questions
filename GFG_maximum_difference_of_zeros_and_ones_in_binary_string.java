/*

Given a binary string S consisting of 0s and 1s. The task is to find the maximum difference of the number of 0s and the number of 1s (number of 0s – number of 1s) in the substrings of a string.

Note: In the case of all 1s, the answer will be -1.

Example 1:
  Input : S = "11000010001" 
  Output : 6 
  Explanatio: From index 2 to index 9, there are 7 0s and 1 1s, so number of 0s - number of 1s is 6. 

Example 2:
  Input: S = "111111"
  Output: -1
  Explanation: S contains 1s only 

Your task:
You do not need to read any input or print anything. The task is to complete the function maxSubstring(), which takes a string as input and returns an integer.

Expected Time Complexity: O(|S|)
Expected Auxiliary Space: O(|S|)

Constraints:
  1 ≤ |S| ≤ 10^5
  S contains 0s and 1s only

*/


class Solution {
    int maxSubstring(String S) {
        // convert String into array such as 0 become 1 and 1 become -1 and then apply kadane algorithm 
        int n = S.length();
        int[] numbers = new int[n];
        
        for(int i=0; i<n; i++) {
            numbers[i] = S.charAt(i) == '0' ? 1 : -1;
        }
        
        int maxDiff = numbers[0];
        int currDiff = numbers[0];
        for(int i=1; i<n; i++) {
            currDiff = Math.max(numbers[i], currDiff + numbers[i]);
            maxDiff = Math.max(maxDiff, currDiff);
        }
        
        return maxDiff;
    }
}
