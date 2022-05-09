/*

Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent. Return the answer in any order.

A mapping of digit to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.

Example 1:
    Input: digits = "23"
    Output: ["ad","ae","af","bd","be","bf","cd","ce","cf"]

Example 2:
    Input: digits = ""
    Output: []

Example 3:
    Input: digits = "2"
    Output: ["a","b","c"]
    
Constraints:
    0 <= digits.length <= 4
    digits[i] is a digit in the range ['2', '9']

*/


class Solution {
    List<String> ans;
    char[][] map;
    
    public List<String> letterCombinations(String digits) {
        ans = new ArrayList<>();
        if(digits.length() == 0) {
            return ans;
        }
        
        map = new char[][] {
            {'a', 'b', 'c'},
            {'d', 'e', 'f'},
            {'g', 'h', 'i'},
            {'j', 'k', 'l'},
            {'m', 'n', 'o'},
            {'p', 'q', 'r', 's'},
            {'t', 'u', 'v'},
            {'w', 'x', 'y', 'z'}
        };
      
        helper(digits, 0, "");
        return ans;
    }
    
    void helper(String digits, int index, String result) {
        if(index>=digits.length()) {
            ans.add(result);
            return;
        }
        
        int mapIndex = digits.charAt(index)-'0'-2;
        for(int i=0; i<map[mapIndex].length; i++) {
            helper(digits, index+1, result + map[mapIndex][i]);
        }
    }
}




class Solution {
    public List<String> letterCombinations(String digits) {
        int len = digits.length();
        List<String> curr = new ArrayList<String>();
        if(len == 0) {
            return curr;
        }
        char[][] ch = new char[][]{{'a','b','c'},
                      {'d', 'e', 'f'},
                      {'g', 'h', 'i'},
                      {'j', 'k', 'l'},
                      {'m', 'n', 'o'},
                      {'p', 'q', 'r', 's'},
                      {'t', 'u', 'v'},
                      {'w', 'x', 'y', 'z'}
                     };
        
        int charIdx = digits.charAt(len-1)-'0'-2;
        for(int k=0; k<ch[charIdx].length; k++) {
            curr.add(Character.toString(ch[charIdx][k]));
        }
        for(int i=len-2; i>=0; i--) {
            List<String> prev = curr;
            curr = new ArrayList<String>();
            for(int j=0; j<prev.size(); j++) {
                charIdx = digits.charAt(i)-'0'-2;
                for(int k=0; k<ch[charIdx].length; k++) {
                    curr.add(Character.toString(ch[charIdx][k]) + prev.get(j));
                }
            }
        }
        
        return curr;
    }
}
