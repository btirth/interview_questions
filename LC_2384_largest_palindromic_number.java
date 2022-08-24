/*

You are given a string num consisting of digits only.

Return the largest palindromic integer (in the form of a string) that can be formed using digits taken from num. It should not contain leading zeroes.

Notes:
  You do not need to use all the digits of num, but you must use at least one digit.
  The digits can be reordered.
 
Example 1:
  Input: num = "444947137"
  Output: "7449447"
  Explanation: 
    Use the digits "4449477" from "444947137" to form the palindromic integer "7449447".
    It can be shown that "7449447" is the largest palindromic integer that can be formed.

Example 2:
  Input: num = "00009"
  Output: "9"
  Explanation: 
    It can be shown that "9" is the largest palindromic integer that can be formed.
    Note that the integer returned should not contain leading zeroes.
 
Constraints:
  1 <= num.length <= 10^5
  num consists of digits.

*/

class Solution {
    public String largestPalindromic(String num) {
        int[] digits = new int[10];
        for(char n: num.toCharArray()) {
            digits[n-'0']++;
        }
        
        boolean isZero = digits[0]>0;
        StringBuilder ans = new StringBuilder("");
        for(int i=9; i>=0; i--) {
            if(digits[i]%2 == 1) {
                digits[i]--;
                ans.append(String.valueOf(i)); 
                break;
            }
        }
        
        for(int i=0; i<10; i++) {
            while(digits[i]>1) {
                ans.insert(0, String.valueOf(i));
                ans.append(String.valueOf(i));
                digits[i] -= 2;
            }
            
        }
        
        String res = new String(ans);
        int start = 0;
        int end = res.length()-1;
        while(start<end && res.charAt(start) == '0') {
            start++;
            end--;
        }
        if(isZero && start == end+1) {
            return "0";
        }
        return res.substring(start, end+1);
    }
}
