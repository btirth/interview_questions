/*

You are given an array of integers nums, there is a sliding window of size k which is moving from the very left of the array to the very right. You can only see the k numbers in the window. Each time the sliding window moves right by one position.

Return the max sliding window.

Example 1:
  Input: nums = [1,3,-1,-3,5,3,6,7], k = 3
  Output: [3,3,5,5,6,7]
  Explanation: 
  Window position                Max
  ---------------               -----
  [1  3  -1] -3  5  3  6  7       3
   1 [3  -1  -3] 5  3  6  7       3
   1  3 [-1  -3  5] 3  6  7       5
   1  3  -1 [-3  5  3] 6  7       5
   1  3  -1  -3 [5  3  6] 7       6
   1  3  -1  -3  5 [3  6  7]      7

Example 2:
  Input: nums = [1], k = 1
  Output: [1]

Example 3:
  Input: nums = [1,-1], k = 1
  Output: [1,-1]

Example 4:
  Input: nums = [9,11], k = 2
  Output: [11]

Example 5:
  Input: nums = [4,-2], k = 2
  Output: [4]
 
Constraints:
  1 <= nums.length <= 10^5
  -10^4 <= nums[i] <= 10^4
  1 <= k <= nums.length

*/



class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] r = new int[n-k+1];
        int rIdx = 0;
        Deque<Integer> q = new ArrayDeque<>();
        
        for(int i=0; i<n; i++) {
            // remove numbers of out range k
            if(!q.isEmpty() && q.peek() == i-k) {
                q.poll();
            }
            
            //remove smaller numbers in range k as they are useless
            while(!q.isEmpty() && nums[q.peekLast()] <= nums[i]) {
                q.pollLast();
            }
            q.add(i);
            if(i >= k-1) {
                r[rIdx++] = nums[q.peek()];
            }
        }
        
        return r;
    }
}
