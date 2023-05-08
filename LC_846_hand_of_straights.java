/*

Alice has some number of cards and she wants to rearrange the cards into groups so that each group is of size groupSize, and consists of groupSize consecutive cards.

Given an integer array hand where hand[i] is the value written on the ith card and an integer groupSize, return true if she can rearrange the cards, or false otherwise.

Example 1:
Input: hand = [1,2,3,6,2,3,4,7,8], groupSize = 3
Output: true
Explanation: Alice's hand can be rearranged as [1,2,3],[2,3,4],[6,7,8]

Example 2:
Input: hand = [1,2,3,4,5], groupSize = 4
Output: false
Explanation: Alice's hand can not be rearranged into groups of 4.

Constraints:
1 <= hand.length <= 10^4
0 <= hand[i] <= 10^9
1 <= groupSize <= hand.length

*/

class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        int n = hand.length;
        if(n%groupSize != 0) {
            return false;
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        HashMap<Integer, Integer> freq = new HashMap<>();

        for(int h: hand) {
            pq.add(h);
            freq.put(h, freq.getOrDefault(h, 0) + 1);
        }

        while(!pq.isEmpty()) {
            int minVal = pq.poll();
            int minFreq = freq.get(minVal);
            if(minFreq <= 0) {
                continue;
            }
            freq.put(minVal, 0);
            for(int i=1; i<groupSize; i++) {
                if(freq.containsKey(minVal+i) && freq.get(minVal+i) >= minFreq) {
                    freq.put(minVal+i, freq.get(minVal+i) - minFreq); 
                } else {
                    return false;
                }
            }
        }
        
        return true;
    }
}
