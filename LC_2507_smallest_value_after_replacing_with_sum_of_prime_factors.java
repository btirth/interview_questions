/*

You are given a positive integer n.

Continuously replace n with the sum of its prime factors.

Note that if a prime factor divides n multiple times, it should be included in the sum as many times as it divides n.
Return the smallest value n will take on.

Example 1:
  Input: n = 15
  Output: 5
  Explanation: Initially, n = 15.
    15 = 3 * 5, so replace n with 3 + 5 = 8.
    8 = 2 * 2 * 2, so replace n with 2 + 2 + 2 = 6.
    6 = 2 * 3, so replace n with 2 + 3 = 5.
    5 is the smallest value n will take on.

Example 2:
  Input: n = 3
  Output: 3
  Explanation: Initially, n = 3.
  3 is the smallest value n will take on.

Constraints:
  2 <= n <= 10^5

*/

class Solution {
    public int smallestValue(int n) {
        int x = 0;
        while(true) {
            x = sumOfPrimeFac(n);
            if (x == n) {
                break;
            }
            n = x;
        }
        return x;
    }
    private int sumOfPrimeFac(int n) {
        int x = 0;
        while(n % 2 == 0) {
            x += 2;
            n /= 2;
        }
        for (int i = 3; i <= Math.sqrt(n); i += 2) {
            while(n % i == 0) {
                x += i;
                n /= i;
                
            }
        }
        if (n >= 2) {
            x += n;
        }
        return x;
    }
}
