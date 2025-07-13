class Solution {
    public int matchPlayersAndTrainers(int[] players, int[] trainers) {
        /**
        We can match player with trainer if
        -> player[i] <= trainers[j]
        
        So we need to sort the array,
        start from the end or start

        for player in players:
            if player <= trainers[idx]:
                player++

            idx++

            if idx >= trainers.len:
                break    
         */

        Arrays.sort(players);
        Arrays.sort(trainers);

        int idx = 0;
        int playersLen = players.length;
        int trainersSize = trainers.length; 

        for(int i=0; i<trainersSize; i++) {
            if(players[idx] <= trainers[i]) {
                idx++;                
            }
        }

        return idx;
    }
}