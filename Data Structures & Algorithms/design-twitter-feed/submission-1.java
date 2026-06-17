class Twitter {

    private int timestamp = 0;
    private Map<Integer, List<int[]>> tweets ;
    private Map<Integer, Set<Integer>> followMap ;


    public Twitter() {
        tweets = new HashMap<>();
        followMap = new HashMap<>();
    }

    public void postTweet(int userId, int tweetId) {
        tweets.putIfAbsent(userId, new ArrayList<>());
        tweets.get(userId).add(new int[]{timestamp++, tweetId});
    }

    public List<Integer> getNewsFeed(int userId) {
        // heap entries: [timestamp, tweetId, followeeId, indexInThatUsersList]
    PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a, b) -> b[0] - a[0]);

    Set<Integer> followees = new HashSet<>(followMap.getOrDefault(userId, new HashSet<>()));
    followees.add(userId);

    // seed with each followee's most recent tweet only
    for (int f : followees) {
        List<int[]> list = tweets.get(f);
        if (list != null && !list.isEmpty()) {
            int i = list.size() - 1;
            maxHeap.offer(new int[]{list.get(i)[0], list.get(i)[1], f, i});
        }
    }

    List<Integer> res = new ArrayList<>();
    while (!maxHeap.isEmpty() && res.size() < 10) {
        int[] cur = maxHeap.poll();
        res.add(cur[1]);
        int f = cur[2], i = cur[3];
        if (i > 0) {                         // push that user's next-older tweet
            int[] prev = tweets.get(f).get(i - 1);
            maxHeap.offer(new int[]{prev[0], prev[1], f, i - 1});
        }
    }
    return res;
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
