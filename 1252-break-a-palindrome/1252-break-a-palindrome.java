class Solution {
    public String breakPalindrome(String palindrome) {

        char[] ch = palindrome.toCharArray();
        int len = palindrome.length();
        if(len == 1) {
            return "";
        }
        
        boolean replaced = false;
        for(int i=0; i<len; i++) {
            if(len%2 == 1 && i == len/2) {
                continue;
            }


            /**
            3 -> 1
            5 -> 01234
            7 -> 0123456
            
             */

            if(ch[i] > 'a') {
                ch[i] = 'a';
                
                return new String(ch);
                
            }
        }

        
        ch[len - 1] = 'b';
        

        return new String(ch);
    }

    boolean isPalindrom(char[] ch) {
        int left = 0;
        int right = ch.length - 1;

        while(left < right) {
            if(ch[left] != ch[right]) {
                return false;
            }

            left++;
            right--;
        }

        return true;
    }
}