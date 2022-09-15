/*

An integer array original is transformed into a doubled array changed by appending twice the value of every element in original, and then randomly shuffling the resulting array.

Given an array changed, return original if changed is a doubled array. If changed is not a doubled array, return an empty array. The elements in original may be returned in any order.

Example 1:
  Input: changed = [1,3,4,2,6,8]
  Output: [1,3,4]
  Explanation: 
    One possible original array could be [1,3,4]:
    - Twice the value of 1 is 1 * 2 = 2.
    - Twice the value of 3 is 3 * 2 = 6.
    - Twice the value of 4 is 4 * 2 = 8.
    Other original arrays could be [4,3,1] or [3,1,4].

Example 2:
  Input: changed = [6,3,0,1]
  Output: []
  Explanation: changed is not a doubled array.

Example 3:
  Input: changed = [1]
  Output: []
  Explanation: changed is not a doubled array.

Constraints:
  1 <= changed.length <= 10^5
  0 <= changed[i] <= 10^5

*/


class Solution {
    public int[] findOriginalArray(int[] changed) {
        int n = changed.length;
        
        if(n%2!=0) return new int[0];
        
        int max = 0;
        for(int chg: changed){
            max = Math.max(max, chg);
        }
        
        int[] freq = new int[2 * max+1];
        for(int chg: changed){
            freq[chg]++;
        }
        
        int[] orig = new int[n/2];
        int oi = 0;
        for(int i=0; i<=max; i++)
        {
            while(freq[i]>0)
            {
                freq[i]--;
                int twice = 2 * i;
                if(freq[twice]> 0){
                    freq[twice]--;
                    orig[oi] = i;
                    oi++;    
                }
                else
                {
                    return new int[0];
                }
            }
        }
        return orig;
    }
}
