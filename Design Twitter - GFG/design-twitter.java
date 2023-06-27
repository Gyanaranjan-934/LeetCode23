//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.math.*;
import java.io.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        Twitter obj = new Twitter();
        int total_queries = sc.nextInt();

        while (total_queries-- > 0) {
            int query = sc.nextInt();

            // if query = 1, postTweet()
            // if query = 2, getNewsFeed()
            // if query = 3, follow()
            // if query = 4, unfollow()

            if (query == 1) {
                int userId = sc.nextInt(), tweetId = sc.nextInt();

                obj.postTweet(userId, tweetId);
            } else if (query == 2) {
                int userId = sc.nextInt();

                List<Integer> vec = obj.getNewsFeed(userId);
                for (int a : vec) System.out.print(a + " ");
                System.out.println();
            } else if (query == 3) {
                int follower = sc.nextInt(), followee = sc.nextInt();
                obj.follow(follower, followee);
            } else {
                int follower = sc.nextInt(), followee = sc.nextInt();
                obj.unfollow(follower, followee);
            }
        }
    }
}

// } Driver Code Ends


// User function Template for Java


class Tweet{
    public int id;
    public Tweet next;
    public int time;
    Tweet(int a,int b){
        this.id = a;
        this.time = b;
        this.next = null;
    }
}
class User{
    
    public int userId;
    public Tweet tweetHead;
    Set<Integer> following ;
    User(int a){
        this.userId = a;
        following = new HashSet<Integer>();
        tweetHead = null;
        follow(a);
    }
    
    public void post(int id,int time){
		Tweet t = new Tweet(id,time);
		t.next=tweetHead;
		tweetHead=t;
	}
    
    public void follow(int id){
        this.following.add(id);
    }
    public void unfollow(int id){
        if(this.following.contains(id))
            this.following.remove(id);
    }
}
class Twitter {
    static int timeStamp = 0;
    
    HashMap<Integer,User> userMap;
    
    // Initialize your data structure here
    Twitter() {
        userMap = new HashMap<>();
    }

    // Compose a new tweet
    void postTweet(int userId, int tweetId) {
        if(!userMap.containsKey(userId)){
			User u = new User(userId);
			userMap.put(userId, u);
		}
		userMap.get(userId).post(tweetId,timeStamp++);
    }

    // Retrieve the 10 most recent tweet ids as mentioned in question
    List<Integer> getNewsFeed(int userId) {
        List<Integer> list = new ArrayList<>();
        if(!userMap.containsKey(userId))   return list;
        PriorityQueue<Tweet> q = new PriorityQueue<Tweet>((a,b)->(b.time-a.time));
        for(int i:userMap.get(userId).following){
            Tweet t = userMap.get(i).tweetHead;
            if(t!=null){
                q.add(t);
            }
        }
        list.clear();
        int n=10;
        while(!q.isEmpty() && n>0){
            Tweet t = q.poll();
            list.add(t.id);
            n--;
            if(t.next!=null)q.add(t.next);
        }
        return list;
    }

    // Follower follows a followee. If the operation is invalid, it should be a
    // no-op.
    void follow(int followerId, int followeeId) {
        if(!userMap.containsKey(followerId)){
            User u = new User(followerId);
            userMap.put(followerId,u);
        }
        if(!userMap.containsKey(followeeId)){
            User u = new User(followeeId);
            userMap.put(followeeId,u);
        }
        userMap.get(followerId).follow(followeeId);
    }

    // Follower unfollows a followee. If the operation is invalid, it should be
    // a no-op.
    void unfollow(int followerId, int followeeId) {
        if(!userMap.containsKey(followerId) || followerId==followeeId)
			return;
		userMap.get(followerId).unfollow(followeeId);
    }
}