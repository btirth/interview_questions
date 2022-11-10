/*
Given a string S of lowercase letters, a duplicate removal consists of choosing two adjacent and equal letters, and removing them.
We repeatedly make duplicate removals on S until we no longer can.
Return the final string after all such duplicate removals have been made.  It is guaranteed the answer is unique.
 
Example 1:
    Input: "abbaca"
    Output: "ca"
    Explanation: 
        For example, in "abbaca" we could remove "bb" since the letters are adjacent and equal, and this is the only possible move.  
        The result of this move is that the string is "aaca", of which only "aa" is possible, so the final string is "ca".
    
Note:
    1 <= S.length <= 20000
    S consists only of English lowercase letters.
*/


class Solution {
    public String removeDuplicates(String s) {
        int n = s.length();
        char[] sCh = s.toCharArray();
        int idx = 0;

        for(int i=0; i<s.length(); i++) {
            sCh[idx] = sCh[i];
            if(idx > 0 && sCh[idx] == sCh[idx-1]) {
                idx-=2;
            }
            idx++;
        }

        return new String(sCh, 0, idx);
    }
}


class Solution {
    public String removeDuplicates(String S) {
        if(S==null || S.length() == 0)
            return S;
        char [] st = new char[S.length()];
        
        int i=0;
        for(int j=0;j<S.length();j++){
            char currentChar = S.charAt(j);
            
            if(i > 0 && currentChar == st[i-1])
                i--;
            else {
                st[i] = currentChar;
                i++;
            }
        }
        return new String(st, 0, i);
    }
}
