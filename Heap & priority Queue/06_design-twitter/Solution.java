class Twitter {
    static int timestamp = 0;
    Map<Integer, Set<Integer>> followMap; 
    Map<Integer, List<Tweet>> tweetMap;   

    class Tweet {
        int tweetId;
        int time;

        public Tweet(int tweetId, int time) {
            this.tweetId = tweetId;
            this.time = time;
        }
    }

    public Twitter() {
        followMap = new HashMap<>();
        tweetMap = new HashMap<>();
    }

    public void postTweet(int userId, int tweetId) {
        tweetMap.putIfAbsent(userId, new ArrayList<>());
        tweetMap.get(userId).add(new Tweet(tweetId, timestamp++));
    }

    public List<Integer> getNewsFeed(int userId) {
        PriorityQueue<Tweet> pq = new PriorityQueue<>((a, b) -> b.time - a.time);
        if (tweetMap.containsKey(userId)) {
            pq.addAll(tweetMap.get(userId));
        }
        if (followMap.containsKey(userId)) {
            for (int followeeId : followMap.get(userId)) {
                if (tweetMap.containsKey(followeeId)) {
                    pq.addAll(tweetMap.get(followeeId));
                }
            }
        }
        List<Integer> feed = new ArrayList<>();
        int count = 0;
        while (!pq.isEmpty() && count < 10) {
            feed.add(pq.poll().tweetId);
            count++;
        }
        return feed;
    }

    public void follow(int followerId, int followeeId) {
        followMap.putIfAbsent(followerId, new HashSet<>());
        followMap.get(followerId).add(followeeId);
    }

    public void unfollow(int followerId, int followeeId) {
        if (followMap.containsKey(followerId)) {
            followMap.get(followerId).remove(followeeId);
        }
    }
}
