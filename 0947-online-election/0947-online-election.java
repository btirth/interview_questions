class TopVotedCandidate {
    /**
    [0,0,1,1,2]
    [0,67,69,74,87]


    0 -> 0
    67 -> 0
    69 -> 0
    74 -> 1
    87 -> 
    
    
    TC -> N logN
     */
    HashMap<Integer, Integer> score;
    int currWinner;
    int[] winner;
    int[] times;
    
    public TopVotedCandidate(int[] persons, int[] times) {
        score = new HashMap<>();
        this.times = times;
        int length = persons.length;
        winner = new int[length];

        for(int i=0; i<length; i++) {
            int person = persons[i];

            score.put(person, score.getOrDefault(person, 0) + 1);
            
            if(score.get(person) >= score.get(currWinner)) {
                currWinner = person;
            }

            winner[i] = currWinner;
        }
    }
    
    public int q(int t) {
        int len = times.length;
        int left = 0;
        int right = len - 1;
        int bs = len - 1;

        while(left <= right) {
            int mid = (right + left) / 2;

            if(times[mid] == t) {
                return winner[mid];
            } else if(times[mid] < t) {
                left = mid + 1;
                bs = mid;
            } else {
                right = mid - 1;
            }
        }

        return winner[bs];
    }

    
}

/**
 * Your TopVotedCandidate object will be instantiated and called as such:
 * TopVotedCandidate obj = new TopVotedCandidate(persons, times);
 * int param_1 = obj.q(t);
 */