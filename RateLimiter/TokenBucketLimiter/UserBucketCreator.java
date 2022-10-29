package RateLimiter.TokenBucketLimiter;

import java.util.HashMap;
import java.util.Map;

public class UserBucketCreator {
    Map<Integer,TokenBuckerRateLimiterImpl> userIdBucketMap= new HashMap<>();
    public UserBucketCreator(int userId){
        userIdBucketMap.put(userId,new TokenBuckerRateLimiterImpl(10,10));
    }

    void accessApplication(int id){
        if(userIdBucketMap.get(id).grantAccess()){
            System.out.println(Thread.currentThread().getName()+"--->able to access request");
        }
        else{
            System.out.println(Thread.currentThread().getName()+"--->too many requests");
        }
    }
}
