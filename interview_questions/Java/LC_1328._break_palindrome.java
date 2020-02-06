/*
Given a palindromic string palindrome, replace exactly one character by any lowercase 
English letter so that the string becomes the lexicographically smallest possible string 
that isn't a palindrome.

After doing so, return the final string.  If there is no way to do so, return the empty string.

 

Example 1:
    Input: palindrome = "abccba"
    Output: "aaccba"

Example 2:
    Input: palindrome = "a"
    Output: ""

*/




class Solution {
    public String breakPalindrome(String palindrome) {
        char[] ch = palindrome.toCharArray();
        int n = ch.length;
        
        if(n==1){
            return "";
        }
        
        for(int i=0; i<n; i++){
            int j = n-i-1;
            
            if(j == i){
                ch[n-1] = 'b';
                return new String(ch);
            }
            
            if(ch[i] != 'a'){
                ch[i] = 'a';
                return new String(ch);
            }
            
            
        }
        ch[n-1] = 'b';
        return new String(ch);
    }
}