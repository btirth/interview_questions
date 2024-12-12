class Solution {
    public long pickGifts(int[] gifts, int k) {
        PriorityQueue<Integer> giftsQueue = new PriorityQueue<>(Collections.reverseOrder());
        for(int gift: gifts) {
            giftsQueue.add(gift);
        }

        for(int i=0; i<k; i++) {
            int gift = giftsQueue.poll();
            giftsQueue.add((int)Math.pow(gift, 0.5));
        }

        long remainingGifts = 0;
        while(!giftsQueue.isEmpty()) {
            remainingGifts += giftsQueue.poll();
        }

        return remainingGifts;
    }
}