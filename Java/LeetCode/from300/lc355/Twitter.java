package from300.lc355;

public class Twitter {
    private int cnt;
    private Map<Integer,Integer> cntAndTwitterIdMap;
    private Map<Integer,Set<Integer>> userFollowMap;
    private Map<Integer,LinkedList<int[]>> userTwittersMap;

    public Twitter() {
        cnt = 0;
        cntAndTwitterIdMap = new HashMap<>();
        userFollowMap = new HashMap<>();
        userTwittersMap = new HashMap<>();
    }
    
    public void postTweet(int userId, int tweetId) {
        int id = ++cnt;
        cntAndTwitterIdMap.put(id,tweetId);
        LinkedList<int[]> twitters = userTwittersMap.getOrDefault(userId,new LinkedList<>());
        twitters.addFirst(new int[]{id,tweetId});
        userTwittersMap.put(userId,twitters);
    }
    
    public List<Integer> getNewsFeed(int userId) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->b[0]-a[0]);
        Set<Integer> follow = userFollowMap.getOrDefault(userId,new HashSet<>());
        for(int item : follow){
            List<int[]> list = userTwittersMap.getOrDefault(item,new LinkedList<>());
            list = list.subList(0,Math.min(10,list.size()));
            list.forEach(x->pq.add(x));
        }
        List<int[]> list = userTwittersMap.getOrDefault(userId,new LinkedList<>());
            list = list.subList(0,Math.min(10,list.size()));
            list.forEach(x->pq.add(x));

        List<Integer> ret = new ArrayList<>();
        for(int i = 0; i < 10; i++){
            if(pq.isEmpty()){
                return ret;
            }
            ret.add(pq.poll()[1]);
        }

        return ret;
    }
    
    public void follow(int followerId, int followeeId) {
        Set<Integer> follow = userFollowMap.getOrDefault(followerId,new HashSet<>());
        follow.add(followeeId);
        userFollowMap.put(followerId,follow);
    }
    
    public void unfollow(int followerId, int followeeId) {
        if(!userFollowMap.containsKey(followerId)){
            return;
        }
        userFollowMap.get(followerId).remove(followeeId);
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