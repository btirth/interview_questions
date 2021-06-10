/*

Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

An input string is valid if:

Open brackets must be closed by the same type of brackets.
Open brackets must be closed in the correct order.
 
Example 1:
  Input: s = "()"
  Output: true

Example 2:
  Input: s = "()[]{}"
  Output: true

Example 3:
  Input: s = "(]"
  Output: false

Example 4:
  Input: s = "([)]"
  Output: false

Example 5:
  Input: s = "{[]}"
  Output: true
 
Constraints:
  1 <= s.length <= 10^4
  s consists of parentheses only '()[]{}'

*/


// time complexity O(n) space complexity O(n)
class Solution {
    public boolean isValid(String s) {
        int n = s.length();
        if(n==1) {
            return false;
        }
        Stack<Character> parenthese = new Stack<Character>();
        
        for(int i=0; i<n; i++) {
            if(s.charAt(i)=='(' || s.charAt(i)=='[' || s.charAt(i)=='{') {
                parenthese.push(s.charAt(i));
            } else if(parenthese.empty()) {
                return false;
            } else if(s.charAt(i)==')') {
                if(parenthese.peek() == '(') {
                    parenthese.pop();
                } else {
                    return false;
                }
            } else if(s.charAt(i)==']') {
                if(parenthese.peek() == '[') {
                    parenthese.pop();
                } else {
                    return false;
                }
            } else if(s.charAt(i)=='}') {
                if(parenthese.peek() == '{') {
                    parenthese.pop();
                } else {
                    return false;
                }
            }
        }
        
        if(!parenthese.empty()) {
            return false;
        }
        
        return true;
    }
}






class Solution {
    public boolean isValid(String s) {
        int n = s.length();
        if(n==1) {
            return false;
        }
        
        HashMap<Character, Character> map = new HashMap<Character, Character>();
        map.put(']', '[');
        map.put(')', '(');
        map.put('}', '{');
        
        Stack<Character> p = new Stack<Character>();
        for(int i=0; i<n; i++) {
            if(map.containsKey(s.charAt(i))) {
                if(!p.empty() && p.peek() == map.get(s.charAt(i))) {
                    p.pop();
                } else {
                    return false;
                }
            } else {
                p.push(s.charAt(i));
            }
        }
        
        if(!p.empty()) {
            return false;
        }
        
        return true;
    }
}
