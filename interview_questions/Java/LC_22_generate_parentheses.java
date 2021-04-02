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
        handler(n, 0, 0, new char[n*2], 0, 0);
        return res;
    }
    
    void handler(int n, int countOpen, int countClose, char[] ch, int leftOpen, int pos) {
        if(leftOpen == 0 && countClose == n) {
            res.add(new String(ch).substring(0, pos));
            return;
        }
        
        if(countOpen > n) {
            return;
        }
        
        if(countClose > n) {
            return;
        }
        
        
        ch[pos] = '(';
        handler(n, countOpen+1, countClose, ch, leftOpen+1, pos+1);
        
        
        if(leftOpen > 0) {
            ch[pos] = ')';
            handler(n, countOpen, countClose+1, ch, leftOpen-1, pos+1);
           
        }
    }
}