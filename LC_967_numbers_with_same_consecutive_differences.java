/*

Return all non-negative integers of length n such that the absolute difference between every two consecutive digits is k.

Note that every number in the answer must not have leading zeros. For example, 01 has one leading zero and is invalid.

You may return the answer in any order.

Example 1:
  Input: n = 3, k = 7
  Output: [181,292,707,818,929]
  Explanation: Note that 070 is not a valid number, because it has leading zeroes.

Example 2:
  Input: n = 2, k = 1
  Output: [10,12,21,23,32,34,43,45,54,56,65,67,76,78,87,89,98]
 
Constraints:
  2 <= n <= 9
  0 <= k <= 9

*/


class Solution {
    
    private void dfs (int num, int digit, int n, int k, List<Integer> numbers) {
        
        if (n == 0) {
            numbers.add (num);
            return;
        }
        if (digit + k <= 9) {
            dfs (num * 10 + (digit + k), digit + k, n - 1, k, numbers);
        }
        if (k != 0 && digit - k >= 0) {
            dfs (num * 10 + (digit - k), digit - k, n - 1, k, numbers);
        }
    }
    
    public int[] numsSameConsecDiff(int n, int k) {
        
        List<Integer> numbers = new ArrayList<> ();
        
        for (int num = 1; num < 10; num++) {
            dfs (num, num, n - 1, k, numbers);
        }
        
        int[] answer = new int[numbers.size ()];
        
        for (int i = 0; i < answer.length; i++) {
            answer[i] = numbers.get (i);
        }
        
        return answer;
    }
}
