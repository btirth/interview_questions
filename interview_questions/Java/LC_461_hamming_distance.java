/*

The Hamming distance between two integers is the number of positions at which the corresponding bits are different.

Given two integers x and y, calculate the Hamming distance.

Note:
    0 ≤ x, y < 231.

Example:
    Input: x = 1, y = 4
    Output: 2
    Explanation:
    1   (0 0 0 1)
    4   (0 1 0 0)
           ↑   ↑
    The above arrows point to positions where the corresponding bits are different.

*/


class Solution {
    public int hammingDistance(int x, int y) {
        String X = x <= y ? Integer.toBinaryString(x) : Integer.toBinaryString(y);
        String Y = x <= y ? Integer.toBinaryString(y) : Integer.toBinaryString(x);
        
        int dist = 0;
        int Xl = X.length();
        int Yl = Y.length();
        for(int i=X.length()-1; i>=0; i--) {
            if(X.charAt(Xl-i-1) != Y.charAt(Yl-i-1)) {
                dist++;
            }
        }
        
        for(int i=Yl-Xl-1; i>=0; i--) {
            if(Y.charAt(i) == '1') {
                dist++;
            }
        }
        return dist;
    }
}