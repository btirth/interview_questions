class Solution {
    public String breakPalindrome(String palindrome) {

        char[] ch = palindrome.toCharArray();
        int len = palindrome.length();
        if(len == 1) {
            return "";
        }
        
        for(int i=0; i<len; i++) {
            if(len%2 == 1 && i == len/2) {
                continue;
            }

            if(ch[i] > 'a') {
                ch[i] = 'a';
                return new String(ch);
            }
        }

        ch[len - 1] = 'b';
        return new String(ch);
    }
}