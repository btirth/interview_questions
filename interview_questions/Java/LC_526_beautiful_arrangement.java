/*

Suppose you have n integers labeled 1 through n.
A permutation of those n integers perm (1-indexed) is considered a beautiful arrangement if for every i (1 <= i <= n), either of the following is true:
- perm[i] is divisible by i.
- i is divisible by perm[i].
Given an integer n, return the number of the beautiful arrangements that you can construct.

Example 1:
    Input: n = 2
    Output: 2
    Explanation: 
        The first beautiful arrangement is [1,2]:
            - perm[1] = 1 is divisible by i = 1
            - perm[2] = 2 is divisible by i = 2
        The second beautiful arrangement is [2,1]:
            - perm[1] = 2 is divisible by i = 1
            - i = 2 is divisible by perm[2] = 1

Example 2:
    Input: n = 1
    Output: 1
 
Constraints:
    1 <= n <= 15

*/


// ref: https://www.youtube.com/watch?v=vhHrUeSdFGU
class Solution {
    
    void arrangement(int[] visited, int n) {
        if(n == 1) {
            // 1 could be settled anywhere, sum++
            visited[0]++;
            return;
        }     
        
        for(int i=1; i < visited.length; i++) {
            // check i is not occupied and fit n
            if(visited[i] == 0 && (i%n == 0 || n%i == 0)) {
                // n is settled to i
                visited[i]++;
                // get n - 1 settled
                arrangement(visited, n-1);
                // backtrack
                visited[i]--;
            }
            
        }
    }
    
    public int countArrangement(int n) {
        // visited[0] is reserved for sum
        int[] visited = new int[n+1];
        arrangement(visited, n);
        return visited[0];
    }
}