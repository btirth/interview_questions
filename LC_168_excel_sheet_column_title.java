/*
Given a positive integer, return its corresponding column title as appear in an Excel sheet.
For example:
    1 -> A
    2 -> B
    3 -> C
    ...
    26 -> Z
    27 -> AA
    28 -> AB 
    ...
Example 1:
    Input: 1
    Output: "A"
Example 2:
    Input: 28
    Output: "AB"
Example 3:
    Input: 701
    Output: "ZY"
*/

class Solution {
    StringBuilder sb = new StringBuilder();
    public String convertToTitle(int n) {
        convert(n);
        return sb.toString();
    }
    
    void convert(int n) {
        if(n==0) {
            return;
        }
        int q = n/26;
        int r = n %26;
        
        if(q>0 && r==0) {
            sb.insert(0, 'Z');
            q--;
        } else {
            sb.insert(0, (char)('A'-1+r));
        }
        
        convert(q);
    }
}
