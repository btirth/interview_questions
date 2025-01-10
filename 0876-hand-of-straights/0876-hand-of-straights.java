class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        int len = hand.length;
        if(len % groupSize != 0) {
            return false;
        }

        /**
        
        This is similar to LCS
        will find Consecutive Sequence length % groupSize != 0 -> return false
        
        But here's catch -> there can be multiple hands of same value
        can we use hashmap for freq ? -> yes
         */

        HashMap<Integer, Integer> freq = new HashMap<>();
        for(int h: hand) {
            freq.put(h, freq.getOrDefault(h, 0) + 1);
        }

        Arrays.sort(hand);
        for(int h: hand) {
            if(freq.getOrDefault(h, 0) > 0) {
                for(int i=0; i<groupSize; i++) {
                    if(!freq.containsKey(h + i) || freq.get(h+i) <= 0) {
                        return false;
                    }

                    freq.put(h+i, freq.getOrDefault(h+i, 0) - 1);
                    if(freq.get(h+i) <= 0) {
                        freq.remove(h+i);
                    }
                }
            }
        }

        return true;
    }
}