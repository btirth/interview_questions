/*

Given strings A, B, and C, find whether C is formed by an interleaving of A and B.

An interleaving of two strings S and T is a configuration such that it creates a new string Y from the concatenation substrings of A and B and |Y| = |A + B| = |C|

For example:

A = "XYZ"

B = "ABC"

so we can make multiple interleaving string Y like, XYZABC, XAYBCZ, AXBYZC, XYAZBC and many more so here your task is to check whether you can create a string Y which can be equal to C.

Specifically, you just need to create substrings of string A and create substrings B and concatenate them and check whether it is equal to C or not.

Note: a + b is the concatenation of strings a and b.

Return true if C is formed by an interleaving of A and B, else return false.

Example 1:
  Input:
  A = YX, B = X, C = XXY
  Output: 0
  Explanation: XXY is not interleaving of YX and X

Example 2:
  Input:
  A = XY, B = X, C = XXY
  Output: 1
  Explanation: XXY is interleaving of XY and X.

Your Task:
Complete the function isInterleave() which takes three strings A, B and C as input and returns true if C is an interleaving of A and B else returns false. (1 is printed by the driver code if the returned value is true, otherwise 0.)

Expected Time Complexity: O(N * M)
Expected Auxiliary Space: O(N * M)
here, N = length of A, and M = length of B

Constraints:
1 ≤ length of A, B ≤ 100
1 ≤ length of C ≤ 200

*/


class Solution {
	public boolean isInterLeave(String a,String b,String c)
	{
        //Your code here
        if(a.length() + b.length() != c.length()) {
            return false;
        }
            
        return helper(a, b, c, 0, 0, new Boolean[a.length()+1][b.length()+1]);   
	}
	
	boolean helper(String a, String b, String c, int i, int j, Boolean dp[][]) {
	    if(i == a.length() && j == b.length()) {
	        return true;
	    }
	    
	    if(dp[i][j] != null) {
	        return dp[i][j];
	    }
	    
	    dp[i][j] = false;
	    
	    if(i < a.length() && a.charAt(i) == c.charAt(i+j)) {
	        dp[i][j] = helper(a,b,c,i+1,j,dp);
	        if(dp[i][j]) {
	            return true;
	        }
	    }
	    
	    if(j < b.length() && b.charAt(j) == c.charAt(i+j)) {
	        dp[i][j] = helper(a,b,c,i,j+1,dp);
	        if(dp[i][j]) {
	            return true;
	        }
	    }
	    
	    return false;
	}
}

