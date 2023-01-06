package from300.lc355;

public class Twitter2 {
    LinkedList<int[]> allTwitters;
    Map<Integer,Set<Integer>> followMap;

    public Twitter2() {
        allTwitters = new LinkedList<>();
        followMap = new HashMap<>();
    }
    
    public void postTweet(int userId, int tweetId) {
        allTwitters.addFirst(new int[]{userId,tweetId});
    }
    
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> ret = new ArrayList<>(16);
        int cnt = 0;
        for(int[] item : allTwitters){
            Set<Integer> followee = followMap.getOrDefault(userId,new HashSet<>());
            if(item[0] == userId || followee.contains(item[0])){
                ret.add(item[1]);
                cnt++;
            }
            if(ret.size() == 10){
                return ret;
            }
        }
        return ret;
    }
    
    public void follow(int followerId, int followeeId) {
        Set<Integer> followee = followMap.getOrDefault(followerId,new HashSet<>());
        followee.add(followeeId);
        followMap.put(followerId,followee);
    }
    
    public void unfollow(int followerId, int followeeId) {
        Set<Integer> followee = followMap.getOrDefault(followerId,new HashSet<>());
        followee.remove(followeeId);
        followMap.put(followerId,followee);
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