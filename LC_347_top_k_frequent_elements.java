/*

Given an integer array nums and an integer k, return the k most frequent elements. You may return the answer in any order.

Example 1:
  Input: nums = [1,1,1,2,2,3], k = 2
  Output: [1,2]

Example 2:
  Input: nums = [1], k = 1
  Output: [1]

Constraints:
  1 <= nums.length <= 10^5
  k is in the range [1, the number of unique elements in the array].
  It is guaranteed that the answer is unique.
 
Follow up: Your algorithm's time complexity must be better than O(n log n), where n is the array's size.

*/



// time complexity O(k log(n)) space complexity O(n)
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int n: nums){
            map.put(n, map.getOrDefault(n,0)+1);
        }
           
        PriorityQueue<Map.Entry<Integer, Integer>> maxHeap = 
                         new PriorityQueue<>((a,b)->(b.getValue()-a.getValue()));
        for(Map.Entry<Integer,Integer> entry: map.entrySet()){
            maxHeap.add(entry);
        }
        
        int[] res = new int[k];
        int i = 0;
        while(i<k){
            Map.Entry<Integer, Integer> entry = maxHeap.poll();
            res[i] = entry.getKey();
            i++;
        }
        return res;
    }
}
