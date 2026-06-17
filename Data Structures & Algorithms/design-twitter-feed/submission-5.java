class Twitter {

    Map<Integer, List<int[]>> tweets;
    Map<Integer, HashSet<Integer>> followers;
    private int timestamp;

    public Twitter() {
        tweets = new HashMap<>();
        followers = new HashMap<>();
        timestamp = 0;
    }
    
    public void postTweet(int userId, int tweetId) {
        tweets.computeIfAbsent(userId, k -> new ArrayList<>()).add(new int[]{timestamp++, tweetId});
    }
    
    public List<Integer> getNewsFeed(int userId) {
        
        //max heap
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> (b[0] - a[0]));

        Set<Integer> followees = followers.getOrDefault(userId, new HashSet<>());
        followees.add(userId);

        for(int followee : followees){
            List<int[]> tweetList = tweets.get(followee);

            if(tweetList != null && !tweetList.isEmpty()){
                int index = tweetList.size() - 1;
                pq.offer(new int[]{tweetList.get(index)[0], tweetList.get(index)[1],followee, index });
            }
           
        }

        List<Integer> res = new ArrayList<>();

        while(!pq.isEmpty() && res.size() < 10){

            int[] curr = pq.poll();
            res.add(curr[1]);
            int i = curr[3];
            int f = curr[2];
            int t = curr[1];

            if(i > 0){
                int[] prev = tweets.get(f).get(i-1);
                pq.offer(new int[]{prev[0], prev[1], f, i-1});
            }

        }
        return res;
    }
    
    public void follow(int followerId, int followeeId) {
        followers.computeIfAbsent(followerId, k -> new HashSet<>()).add(followeeId);
    }
    
    public void unfollow(int followerId, int followeeId) {
        followers.get(followerId).remove(followeeId);
    }
}
