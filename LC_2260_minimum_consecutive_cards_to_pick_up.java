/*

You are given an integer array cards where cards[i] represents the value of the ith card. A pair of cards are matching if the cards have the same value.

Return the minimum number of consecutive cards you have to pick up to have a pair of matching cards among the picked cards. If it is impossible to have matching cards, return -1.

Example 1:
  Input: cards = [3,4,2,3,4,7]
  Output: 4
  Explanation: We can pick up the cards [3,4,2,3] which contain a matching pair of cards with value 3. Note that picking up the cards [4,2,3,4] is also optimal.

Example 2:
  Input: cards = [1,0,5,3]
  Output: -1
  Explanation: There is no way to pick up a set of consecutive cards that contain a pair of matching cards.

Constraints:
  1 <= cards.length <= 10^5
  0 <= cards[i] <= 10^6

*/


class Solution {
    public int minimumCardPickup(int[] cards) {
        HashMap<Integer, Integer> map = new HashMap<>();
        
        int n = cards.length;
        int ans = Integer.MAX_VALUE;
        for(int i=0; i<n; i++) {
            if(map.containsKey(cards[i])) {
                ans = Math.min(ans, i-map.get(cards[i])+1);
            }
            map.put(cards[i], i);
            
        }
        
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}
