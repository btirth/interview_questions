/*

Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

Example 1:
    Input: n = 3
    Output: ["((()))","(()())","(())()","()(())","()()()"]

Example 2:
    Input: n = 1
    Output: ["()"]
    
Constraints:
    1 <= n <= 8

*/


// Brute force Approach
class Solution {
    List<String> res = new ArrayList<String>();
    public List<String> generateParenthesis(int n) {
        
        handler(n, 0, 0, new StringBuilder(), 0);
        return res;
    }
    
    void handler(int n, int countOpen, int countClose, StringBuilder sb, int leftOpen) {
        if(leftOpen == 0 && countClose == n) {
            res.add(new String(sb));
            return;
        }
        
        if(countOpen > n) {
            return;
        }
        
        if(countClose > n) {
            return;
        }
        
        
        sb.append('(');
        handler(n, countOpen+1, countClose, sb, leftOpen+1);
        sb.delete(sb.length()-1, sb.length());
        
        if(leftOpen > 0) {
            sb.append(')');
            handler(n, countOpen, countClose+1, sb, leftOpen-1);
            sb.delete(sb.length()-1, sb.length());
        }
    }
}





// Optimized Approach
class Solution {
    List<String> res = new ArrayList<String>();
    public List<String> generateParenthesis(int n) {
        helper(new char[2*n], 0, 0, n, 0);
        return res;
    }
    
    void helper(char[] ch, int open, int close, int n, int i) {
        if(close == n) {
            res.add(new String(ch));
            return;
        }
        
        if(open < n) {
            ch[i] = '(';
            helper(ch, open+1, close, n, i+1);
            
        }
        if(close < open) {
            ch[i] = ')';
            helper(ch, open, close+1, n, i+1);       
        }  
    }
}
