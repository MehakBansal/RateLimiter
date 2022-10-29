package RateLimiter.SlidingWindow;

import java.util.HashMap;
import java.util.Map;

public class UserBucketCreator {
    Map<Integer,SlidingWindowRateLimiterImpl> userIdSlidingWindowBucketMap=new HashMap<>();
    public UserBucketCreator(int id){
        this.userIdSlidingWindowBucketMap.put(id,new SlidingWindowRateLimiterImpl(10,1));
    }

    void accessApplication(int id){
        if(userIdSlidingWindowBucketMap.get(id).grantAccess()){
            System.out.println("accessing the app-->"+Thread.currentThread().getName());
        }
        else{
            System.out.println("too many req accessing the app-->"+Thread.currentThread().getName());
        }

    }
}
