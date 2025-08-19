class Solution {
    public String longestPalindrome(String s) {
        /**
        longest palindromic substring

        palindrom -> aba, bab, 
        
        odd length -> middle character anything, on both side same values
        even length -> if we divide the string of equal length one string is reverse of another.

        for character in s:
            // odd length
            we'll go idx - 1 and idx + 1, idx is index of character at it is in the center.


            // even length
            There's two option, current index might on left part of the string or right part.
            baab -> ba|ab , we'll only check index part of left part of the palindrom.
            if s[idx] == s[idx + 1]:

        TC -> O(n^2) 
        SC -> O(1)


            b a b   
        b   1 0 3
        a     1 0
        b       1

        TC -> O(n^2)
        SC -> O(n^2)
         */

        int start = 0;
        int end = 0;
        int resLen = 1;
        int length = s.length();

        for(int i=0; i<length; i++) {
            // Odd length
            int j = 1;

            while((i-j) >= 0 && (i+j) < length && s.charAt(i - j) == s.charAt(i + j)) {
                j++;
            }

            if(resLen < (2 * (j - 1) + 1)) {
                start = i - (j-1);
                end = i + (j-1);
                resLen = (2 * (j - 1) + 1);
            }

            // Even length
            j = 0;
            while((i-j) >= 0 && (i+j+1) < length && s.charAt(i-j) == s.charAt(i+j+1)) {
                j++;
            }

            if(resLen < (2 * j)) {
                start = i - (j-1);
                end = i + j;
                resLen = 2 * j;
            }
        } 

        return s.substring(start, end + 1);
    }
}