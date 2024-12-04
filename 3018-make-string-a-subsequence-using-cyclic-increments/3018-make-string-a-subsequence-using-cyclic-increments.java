class Solution {
    public boolean canMakeSubsequence(String str1, String str2) {
        int sIdx1 = 0;
        int sIdx2 = 0;

        while(sIdx1<str1.length() && sIdx2<str2.length()) {
            if(str1.charAt(sIdx1) == str2.charAt(sIdx2) || 
                (str1.charAt(sIdx1) == 'z' && str2.charAt(sIdx2) == 'a') ||
                (str1.charAt(sIdx1) + 1 == str2.charAt(sIdx2))
            ) {
                sIdx2++;
            } 

            sIdx1++;
        }

        if(sIdx2 == str2.length()) {
            return true;
        }

        return false;
    }
}