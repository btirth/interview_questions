class Twitter {

    int counter = 0;    
    HashMap<Integer, List<Integer>> followeeMap;
    HashMap<Integer, List<Integer[]>> tweetMap;

    public Twitter() {
        followeeMap = new HashMap<>();
        tweetMap = new HashMap<>();
    }
    
    public void postTweet(int userId, int tweetId) {
        if(!tweetMap.containsKey(userId)) {
            tweetMap.put(userId, new ArrayList<>());
        }

        tweetMap.get(userId).add(new Integer[]{counter, tweetId});
        counter++;
    }
    
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> result = new ArrayList<>();
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> Integer.compare(b[0], a[0]));

        List<Integer> followeeList = followeeMap.getOrDefault(userId, new ArrayList<>());

        if(tweetMap.containsKey(userId)) {
            List<Integer[]> tweets = tweetMap.get(userId);
            int idx = tweets.size() - 1;
            Integer[] lastTweet = tweets.get(idx);
            pq.add(new int[]{lastTweet[0], lastTweet[1], idx, userId});
        }

        for(Integer followee: followeeList) {
            
            if(tweetMap.containsKey(followee)) {
                List<Integer[]> tweets = tweetMap.get(followee);
                int idx = tweets.size() - 1;
                Integer[] lastTweet = tweets.get(idx);
                pq.add(new int[]{lastTweet[0], lastTweet[1], idx, followee});
            }
        }

        while(!pq.isEmpty() && result.size() < 10) {
            int[] topTweet = pq.poll();
            int tweetId = topTweet[1];
            int idx = topTweet[2];
            int followee = topTweet[3];

            result.add(tweetId);
            if(idx > 0) {
                List<Integer[]> tweets = tweetMap.get(followee);
                Integer[] prevTweet = tweets.get(idx - 1);
                pq.add(new int[]{prevTweet[0], prevTweet[1], idx - 1, followee});
            }
        }

        return result;
    }
    
    public void follow(int followerId, int followeeId) {
        if(!followeeMap.containsKey(followerId)) {
            followeeMap.put(followerId, new ArrayList<>());
        }

        if(followeeMap.get(followerId).contains(followeeId)) {
            return;
        }

        followeeMap.get(followerId).add(followeeId);
    }
    
    public void unfollow(int followerId, int followeeId) {
        if(!followeeMap.containsKey(followerId) || !followeeMap.get(followerId).contains(followeeId)) {
            return;
        }
        
        followeeMap.get(followerId).remove(new Integer(followeeId));
    }
}

/**
 * Your Twitter object will be instantiated and called as such:
 * Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId);
 * List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */