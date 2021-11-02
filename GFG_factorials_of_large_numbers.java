/*

Given an integer N, find its factorial.

Example 1:
  Input: N = 5
  Output: 120
  Explanation : 5! = 1*2*3*4*5 = 120

Example 2:
  Input: N = 10
  Output: 3628800
  Explanation :
  10! = 1*2*3*4*5*6*7*8*9*10 = 3628800

Your Task:
You don't need to read input or print anything. Complete the function factorial() that takes integer N as input parameter and returns a list of integers denoting the digits that make up the factorial of N.

Expected Time Complexity : O(N^2)
Expected Auxilliary Space : O(1)

Constraints:
1 ≤ N ≤ 1000

*/


class Solution {
    static ArrayList<Integer> factorial(int N){
        //code here
        ArrayList<Integer> result = new ArrayList<Integer>();
        java.math.BigInteger fact = new java.math.BigInteger("1");
        for(int i=1; i<=N; i++) {
            fact = fact.multiply(java.math.BigInteger.valueOf(i));
        }
        
        String stringFact = fact.toString();
        for(int i=1; i<=stringFact.length(); i++) {
            result.add(Integer.parseInt(stringFact.substring(i-1,i)));
        }
        
        return result;
    }
}
