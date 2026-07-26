class Twitter {

    int timeCounter;
    Map<Integer, List<int[]>> mapOfUserToTweet;
    Map<Integer, Set<Integer>> mapOfFollowerToFollowee;
    public Twitter() {
        timeCounter = 0;
        mapOfUserToTweet = new HashMap<>();
        mapOfFollowerToFollowee = new HashMap<>();
    }

    public void postTweet(int userId, int tweetId) {
        mapOfUserToTweet.computeIfAbsent(userId, k -> new ArrayList<>()).add(new int[]{timeCounter--, tweetId});
    }

    public List<Integer> getNewsFeed(int userId) {

        int k = 10;

        Set<Integer> followeeSet = mapOfFollowerToFollowee.computeIfAbsent(userId, u -> new HashSet<>());

        followeeSet.add(userId);

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0]-b[0]);
//        Integer[] followeeArray = (Integer[]) followeeSet.toArray();
        Iterator<Integer> itr = followeeSet.iterator();

        while(itr.hasNext()) {
            int followee = itr.next();
            List<int[]> listOfTweets = mapOfUserToTweet.get(followee);
            if(listOfTweets==null || listOfTweets.isEmpty())
                continue;
            int[] lastTweet = listOfTweets.get(listOfTweets.size()-1);

            pq.offer(new int[]{lastTweet[0], lastTweet[1], followee, listOfTweets.size() - 1});
        }

        int tweetNumber = 0;
        List<Integer> sol = new ArrayList<>();
        while(tweetNumber<10) {

            if(pq.size()==0)
                break;
            int[] tweet = pq.poll();
            sol.add(tweet[1]);
            tweetNumber++;
            List<int[]> tweetList = mapOfUserToTweet.get(tweet[2]);
            if(tweet[3]==0)
                continue;
            int[] checkTweet = tweetList.get(tweet[3]-1);
            pq.offer(new int[]{checkTweet[0], checkTweet[1], tweet[2], tweet[3]-1});
        }

        return sol;
    }

    public void follow(int followerId, int followeeId) {
        mapOfFollowerToFollowee.computeIfAbsent(followerId, f-> new HashSet<>()).add(followeeId);
    }

    public void unfollow(int followerId, int followeeId) {
        mapOfFollowerToFollowee.computeIfPresent(followerId, (follower, followee) -> {followee.remove(followeeId); return followee;});
    }
}
