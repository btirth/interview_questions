/*

Write a function that takes a string as input and reverse only the vowels of a string.

Example 1:
    Input: "hello"
    Output: "holle"

Example 2:
    Input: "leetcode"
    Output: "leotcede"

Note:
    The vowels does not include the letter "y".

*/

// Method 1 is more optimized than Method 2

//Method 1   

class Solution {
    public String reverseVowels(String s) {
        
        int i = 0;
        int j = s.length()-1;
        char[] str = s.toCharArray();
        while(i < j) {
            char ci = Character.toLowerCase(str[i]);
            char cj = Character.toLowerCase(str[j]);
        
            if((ci == 'a' || ci == 'e' || ci == 'i' || ci == 'o' || ci == 'u') && (cj == 'a' || cj == 'e' || cj == 'i' || cj == 'o' || cj == 'u')) {
                char temp = str[i];
                str[i] = str[j];
                str[j] = temp;
                i++;
                j--;
            } else if(ci == 'a' || ci == 'e' || ci == 'i' || ci == 'o' || ci == 'u') {
                j--;
            } else if (cj == 'a' || cj == 'e' || cj == 'i' || cj == 'o' || cj == 'u') {
                i++;
            } else {
                i++;
                j--;
            }
        }
        
        
        return new String(str);
    }
}




// Method 2

class Solution {
    public String reverseVowels(String s) {
        List<Character> vowels = new ArrayList<Character>();
        vowels.add('a');
        vowels.add('e');
        vowels.add('i');
        vowels.add('o');
        vowels.add('u');
       
        
        int i = 0;
        int j = s.length()-1;
        char[] str = s.toCharArray();
        while(i < j) {
            if(vowels.contains(Character.toLowerCase(str[i])) && vowels.contains(Character.toLowerCase(str[j]))) {
                char temp = str[i];
                str[i] = str[j];
                str[j] = temp;
                i++;
                j--;
            } else if(vowels.contains(Character.toLowerCase(str[i]))) {
                j--;
            } else if (vowels.contains(Character.toLowerCase(str[j]))) {
                i++;
            } else {
                i++;
                j--;
            }
        }
        
        
        return new String(str);
    }
}