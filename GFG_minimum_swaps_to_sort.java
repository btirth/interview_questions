/*

Given an array of n distinct elements. Find the minimum number of swaps required to sort the array in strictly increasing order.

Example 1:
  Input: nums = {2, 8, 5, 4}
  Output: 1
  Explaination: swap 8 with 4.

Example 2:
  Input: nums = {10, 19, 6, 3, 5}
  Output: 2
  Explaination: swap 10 with 3 and swap 19 with 5.

Your Task:
You do not need to read input or print anything. Your task is to complete the function minSwaps() which takes the nums as input parameter and returns an integer denoting the minimum number of swaps required to sort the array. If the array is already sorted, return 0. 

Expected Time Complexity: O(nlogn)
Expected Auxiliary Space: O(n)

Constraints:
  1 ≤ n ≤ 10^5
  1 ≤ numsi ≤ 10^6

*/

class Solution
{
    //Function to find the minimum number of swaps required to sort the array.
    public int minSwaps(int nums[])
    {
        // Code here
        int n = nums.length;
        Pair[] pairs = new Pair[n];
        
        for(int i=0; i<n; i++) {
            pairs[i] = new Pair(i, nums[i]);
        }
        
        Arrays.sort(pairs);
        int res = 0;
        
        boolean[] visited = new boolean[n];
        
        for(int i=0; i<n; i++) {
            if(visited[i] || i == pairs[i].idx) {
                continue;
            }
            
            int cycleLen = 0;
            int j = i;
            while(!visited[j]) {
                visited[j] = true;
                cycleLen++;
                j = pairs[j].idx;
            }
            
            res += cycleLen-1;
        }
        
        return res;
    }
    
    class Pair implements Comparable<Pair> {
        int idx;
        int value;
        
        Pair(int idx, int value) {
            this.idx = idx;
            this.value = value;
        }
        
        public int compareTo(Pair p) {
            if(value < p.value) {
                return -1;
            } else if(value > p.value) {
                return 1;
            } else {
                return 0;
            }
        }
    }
}
