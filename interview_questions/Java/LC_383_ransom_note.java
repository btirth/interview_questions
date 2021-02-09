/*

Given an arbitrary ransom note string and another string containing letters from all the magazines, 
write a function that will return true if the ransom note can be constructed from the magazines ; otherwise, it will return false.

Each letter in the magazine string can only be used once in your ransom note.

Example 1:
    Input: ransomNote = "a", magazine = "b"
    Output: false

Example 2:
    Input: ransomNote = "aa", magazine = "ab"
    Output: false

Example 3:
    Input: ransomNote = "aa", magazine = "aab"
    Output: true
 

Constraints:
    You may assume that both strings contain only lowercase letters.

*/


class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] str = new int[26];
        
        for(int i=0; i<magazine.length(); i++) {
            str[magazine.charAt(i) - 97]++;
        }
        
        for(int i=0; i<ransomNote.length(); i++) {
            if(str[ransomNote.charAt(i) - 97] == 0) {
                
                return false;
            } else {
                str[ransomNote.charAt(i) - 97]--;    
                
            }
            
        }
        
        return true;
    }
}